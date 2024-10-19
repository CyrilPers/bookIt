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
            "JOIN wc.plannings pla " +
            "JOIN wc.treatments p " +
            "WHERE wc.company.id = :companyId " +
            "AND pla.dateStart <= :dateEnd " +
            "AND pla.dateEnd >= :dateStart " +
            "AND p.id = :serviceId")
    List<Worker> getWorkersWithFreePlanningForService(int companyId, LocalDateTime dateStart, LocalDateTime dateEnd, int serviceId);

    WorkerCompany save(WorkerCompany workerCompany);

    WorkerCompany findWorkerCompanyByCompanyIdAndWorkerId(int companyId, int workerId);

    @Query("SELECT wc FROM WorkerCompany wc JOIN wc.worker w JOIN w.user u WHERE u.email = :email AND wc.company.id = :idCompany")
    WorkerCompany findByEmailAndCompanyId(String email, Integer idCompany);
}
