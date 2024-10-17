package com.bookIt.demo.service;

import com.bookIt.demo.dto.CustomerAuthResponseDTO;
import com.bookIt.demo.dto.WorkerCompanyAuthResponseDTO;
import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.security.Token;
import com.bookIt.demo.repository.CustomerRepository;
import com.bookIt.demo.tool.JwtToken.JwtTokenTool;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    public CustomerAuthResponseDTO login(String username, String password) {

        final Customer customer;

        try {
            customer = customerSvc.findByEmail(username);
        } catch (UsernameNotFoundException e) {
            return null;
        }

        if (passwordEncoder.matches(password, customer.getUser().getPassword())) {

            String token = this.jwtTokenUtil.generateToken(customer.getUser());

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
