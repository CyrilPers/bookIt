package com.bookIt.demo.repository;

import com.bookIt.demo.model.Worker;
import com.bookIt.demo.model.WorkerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WorkerCompanyRepository extends JpaRepository<WorkerCompany, Integer> {
    @Query("SELECT wc.worker FROM WorkerCompany wc WHERE wc.company.id = :companyId")
    List<Worker> findWorkersByCompanyId(Integer companyId);

    Worker deleteByCompanyIdAndWorkerId(Integer companyId, Integer workerId);


    @Query("SELECT DISTINCT wc.worker FROM WorkerCompany wc " +
            "JOIN wc.plannings p " +
            "JOIN wc.services s " +
            "WHERE wc.company.id = :companyId " +
            "AND p.dateStart <= :dateEnd " +
            "AND p.dateEnd >= :dateStart " +
            "AND s.id = :serviceId")
    List<Worker> getWorkersWithFreePlanningForService(int companyId, LocalDateTime dateStart, LocalDateTime dateEnd, int serviceId);

    WorkerCompany save(WorkerCompany workerCompany);

    WorkerCompany findWorkerCompanyByCompanyIdAndWorkerId(int companyId, int workerId);

    WorkerCompany findByEmail(String username);

    WorkerCompany findByEmailAndCompanyId(String username, Integer idCompany);
}
