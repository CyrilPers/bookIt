package com.bookIt.demo.mapper;

import com.bookIt.demo.model.WorkerCompany;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class WorkerCompanyMapper {

    public static UserDetails toUserDetails(WorkerCompany workerCompany){
        return User.builder().username(workerCompany.getWorker().getUser().getEmail()).password(workerCompany.getWorker().getUser().getPassword()).authorities(workerCompany.getRoles()).build();
    }
}
