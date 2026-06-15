package com.example.fleshcardservice.exceptions;

import com.example.fleshcardservice.dtos.BaseMessage;
import com.example.fleshcardservice.dtos.ValidationErrorResponse;
import com.example.fleshcardservice.enums.ErrorCode;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

            @ControllerAdvice
            public class GlobalExceptionHandler {

                private final ResourceBundleMessageSource errorMessageSource;
                private final ResourceBundleMessageSource validationMessageSource;

                public GlobalExceptionHandler(ResourceBundleMessageSource errorMessageSource,
                                              ResourceBundleMessageSource validationMessageSource) {
                    this.errorMessageSource = errorMessageSource;
                    this.validationMessageSource = validationMessageSource;
                }

                private Locale currentLocale() {
                    return LocaleContextHolder.getLocale();
                }

                private String currentLanguageCode() {
                    return currentLocale().getLanguage();
                }

                @ExceptionHandler(BaseException.class)
                public ResponseEntity<BaseMessage> handleAppExceptions(BaseException exception) {
                    Locale locale = currentLocale();

                    return ResponseEntity.badRequest().body(
                            new BaseMessage(
                                    exception.errorType().getCode(),
                                    errorMessageSource.getMessage(
                                            exception.errorType().toString(),
                                            null,
                                            locale
                                    )
                            )
                    );
                }



                @ExceptionHandler(MethodArgumentNotValidException.class)
                public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
                    Locale locale = currentLocale();
                    Map<String, List<String>> errors = new LinkedHashMap<>();

                    ex.getBindingResult().getFieldErrors().forEach(error -> {
                        String defaultMsg = error.getDefaultMessage();
                        String messageKey = (defaultMsg != null)
                                ? defaultMsg.replaceAll("^\\{(.+)}$", "$1")
                                : error.getField();

                        String msg = validationMessageSource.getMessage(messageKey, new Object[0], defaultMsg, locale);
                        if (msg != null) {
                            errors.computeIfAbsent(
                                    error.getField() != null ? error.getField() : "unknown",
                                    k -> new ArrayList<>()
                            ).add(msg);
                        }
                    });

                    ex.getBindingResult().getGlobalErrors().forEach(error -> {
                        String defaultMsg = error.getDefaultMessage();
                        String messageKey = (defaultMsg != null)
                                ? defaultMsg.replaceAll("^\\{(.+)}$", "$1")
                                : error.getObjectName();

                        String msg = validationMessageSource.getMessage(messageKey, new Object[0], defaultMsg, locale);
                        if (msg != null) {
                            errors.computeIfAbsent(error.getObjectName(), k -> new ArrayList<>()).add(msg);
                        }
                    });

                    String validationMessage = errorMessageSource.getMessage(ErrorCode.VALIDATION_ERROR.toString(), new Object[0], locale);

                    return ResponseEntity.badRequest().body(
                            new ValidationErrorResponse(400, validationMessage, currentLanguageCode(), errors)
                    );
                }

                @ExceptionHandler(Throwable.class)
                public ResponseEntity<BaseMessage> handleOtherExceptions(Throwable exception) {
                    exception.printStackTrace();
                    return buildErrorMessage(ErrorCode.INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                private ResponseEntity<BaseMessage> buildErrorMessage(ErrorCode code, HttpStatus status) {
                    Locale locale = currentLocale();
                    return ResponseEntity.status(status).body(
                            new BaseMessage(
                                    code.getCode(),
                                    errorMessageSource.getMessage(code.toString(), new Object[0], locale)
                            )
                    );
                }
            }
