package com.bookIt.demo.mapper;

import com.bookIt.demo.model.Customer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerMapper {

    public static UserDetails toUserDetails(Customer customer){
        return User.builder().username(customer.getUser().getEmail()).password(customer.getUser().getPassword()).build();
    }
}
