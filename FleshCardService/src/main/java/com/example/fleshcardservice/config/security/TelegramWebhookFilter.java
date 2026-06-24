package com.example.fleshcardservice.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TelegramWebhookFilter extends OncePerRequestFilter {

    @Value("${telegram.bot.secret-token}")
    private String secretToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        if (!request.getRequestURI().startsWith("/webhook")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("X-Telegram-Bot-Api-Secret-Token");

        if (secretToken.equals(token)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid secret token");
        }
    }
}
