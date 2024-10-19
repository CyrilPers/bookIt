package com.bookIt.demo.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Token {
    private String accessToken;
    private Date expireAt;
}
