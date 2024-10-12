package com.bookIt.demo.repository;

import com.bookIt.demo.entity.Service;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository {

    Service save(Service service);
}
