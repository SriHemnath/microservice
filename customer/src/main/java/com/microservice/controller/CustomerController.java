package com.microservice.controller;

import com.microservice.model.CustomerRegistrationRequest;
import com.microservice.model.CustomerRegistrationResponse;
import com.microservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @PostMapping("/v1/create")
    public ResponseEntity<CustomerRegistrationResponse> registerCustomer(@RequestBody CustomerRegistrationRequest request){
        log.info("received registration request "+request);
        Integer id = customerService.registerCustomer(request);
        return new ResponseEntity<>(new CustomerRegistrationResponse(id),HttpStatus.CREATED);
    }
}
