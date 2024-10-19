package com.bookIt.demo.service;

import com.bookIt.demo.dto.AuthRequestDTO;
import com.bookIt.demo.dto.CustomerAuthResponseDTO;
import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.security.Token;
import com.bookIt.demo.tool.jwtToken.JwtTokenTool;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationCustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenTool jwtTokenUtil;

    @Autowired
    private CustomerService customerSvc;

    public CustomerAuthResponseDTO login(AuthRequestDTO authRequest) {

        final Customer customer;

        try {
            customer = customerSvc.findByEmail(authRequest.getEmail());
        } catch (UsernameNotFoundException e) {
            return null;
        }

        if (passwordEncoder.matches(authRequest.getPassword(), customer.getUser().getPassword())) {

            String token = this.jwtTokenUtil.generateToken(customer);

            return new CustomerAuthResponseDTO(
                    new Token(
                            token,
                            this.jwtTokenUtil.extractClaim(token, Claims::getExpiration)
                    ),
                    customer
            );
        }
        return null;
    }
}
