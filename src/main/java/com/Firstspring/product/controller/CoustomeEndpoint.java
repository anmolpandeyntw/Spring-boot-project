package com.Firstspring.product.controller;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom")

public class CoustomeEndpoint {
    @ReadOperation
    public String getCoustom() {
        return "This is custom endpoint Anmol!";

    }
}