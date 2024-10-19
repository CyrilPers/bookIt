package com.bookIt.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    String companyName;
    String companyDescription;
    Integer companyId;
}
