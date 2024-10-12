package com.bookIt.demo.repository;

import com.bookIt.demo.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    Worker save(Worker worker);

    Worker findById(int id);

    Worker deleteById(int id);

    Worker findByEmail(String email);

    Worker findByPhoneNumber(String phoneNumber);
}
