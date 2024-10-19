package com.bookIt.demo.dto;

import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.security.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerAuthResponseDTO {
    private Token accessToken;
    private Customer customer;

}
