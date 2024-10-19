package com.bookIt.demo.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointementDTO {
    Date appointementDateStart;
    Date appointementDateEnd;
    String performanceName;
    String performanceDescription;
}
