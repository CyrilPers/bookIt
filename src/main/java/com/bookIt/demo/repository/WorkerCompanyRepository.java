package com.bookIt.demo.repository;

import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.entity.WorkerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerCompanyRepository extends JpaRepository<WorkerCompany, Integer> {
    @Query("SELECT wc.worker FROM WorkerCompany wc WHERE wc.company.id = :companyId")
    List<Worker> findWorkersByCompanyId(Integer companyId);

    Worker deleteByCompanyIdAndWorkerId(Integer companyId, Integer workerId);
}
