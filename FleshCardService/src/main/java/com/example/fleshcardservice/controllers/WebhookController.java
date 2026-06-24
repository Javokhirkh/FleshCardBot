package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController extends AbstractController<UserService>{
    protected WebhookController(UserService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<Void> handleWebhook(@RequestBody String payload) {
        System.out.println("Received: " + payload);
        return ResponseEntity.ok().build();
    }
}
