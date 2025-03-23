package com.microservice.model;

public record CustomerRegistrationResponse(String message, Integer id) {
    public CustomerRegistrationResponse(Integer id){
        this("created successfully",id);
    }
}
