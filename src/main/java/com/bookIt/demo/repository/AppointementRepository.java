package com.bookIt.demo.repository;

import com.bookIt.demo.model.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointementRepository extends JpaRepository<Appointement, Integer> {
    List<Appointement> findByCustomerId(int idCustomer);
}
