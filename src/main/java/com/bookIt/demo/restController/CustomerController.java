package com.bookIt.demo.restController;

import com.bookIt.demo.dto.AuthRequestDTO;
import com.bookIt.demo.dto.CustomerAuthResponseDTO;
import com.bookIt.demo.service.AuthentificationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private AuthentificationCustomerService authCustomerService;

    @PostMapping("/customer")
    public CustomerAuthResponseDTO login(@RequestBody AuthRequestDTO authRequest){
        return authCustomerService.login(authRequest);
    }
}
