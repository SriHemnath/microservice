package com.microservice.service;

import com.microservice.model.CustomerRegistrationRequest;

public interface CustomerService {
    Integer registerCustomer(CustomerRegistrationRequest request);
}
