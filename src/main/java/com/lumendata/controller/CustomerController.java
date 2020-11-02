package com.lumendata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.Customer;
import com.lumendata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/customer/mv2/publish", consumes = "application/json")
    public String publishMessage(@RequestBody  String data) {

       customerService.processMessage(data);
         return "success";
    }
}
