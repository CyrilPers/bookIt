package com.bookIt.demo.repository;

import com.bookIt.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

    Service save(Service service);
}
