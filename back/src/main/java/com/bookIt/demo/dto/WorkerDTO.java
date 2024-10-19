package com.bookIt.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkerDTO {
    private Integer workerId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String workerPhoneNumber;
}
