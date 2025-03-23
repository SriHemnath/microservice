package com.microservice.service.implementation;

import com.microservice.dao.Customer;
import com.microservice.model.CustomerRegistrationRequest;
import com.microservice.repository.CustomerRepository;
import com.microservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Integer registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .updatedAt(LocalDateTime.now())
                .build();

        repository.saveAndFlush(customer);
        return customer.getId();
    }
}
