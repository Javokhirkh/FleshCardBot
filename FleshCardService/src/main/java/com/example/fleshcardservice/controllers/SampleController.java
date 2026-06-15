package com.example.fleshcardservice.controllers;

import com.example.fleshcardservice.services.SampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fleshcardservice.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/sample")
public class SampleController extends AbstractController<SampleService> {

}
