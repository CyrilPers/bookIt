package com.bookIt.demo.repository;

import com.bookIt.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c JOIN c.user u WHERE u.email = :email")
    Customer findByEmail(String email);
}
