package com.bookIt.demo.repository;

import com.bookIt.demo.model.Worker;
import com.bookIt.demo.model.WorkerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    Worker save(Worker worker);

    Worker findById(int id);

    Worker deleteById(int id);

    @Query("SELECT w FROM Worker w WHERE w.user.email = :email")
    Worker findByEmail(String email);
}
