package com.bookIt.demo.dto;

import com.bookIt.demo.model.Worker;
import com.bookIt.demo.model.security.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkerAuthResponseDTO {
    private Token accessToken;
    private WorkerDTO worker;
}
