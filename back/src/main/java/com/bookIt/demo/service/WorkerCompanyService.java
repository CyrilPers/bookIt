package com.bookIt.demo.service;
import com.bookIt.demo.model.Company;
import com.bookIt.demo.model.Role;
import com.bookIt.demo.model.WorkerCompany;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.WorkerCompanyRepository;
import com.bookIt.demo.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.bookIt.demo.enums.code.company.CompanyError.COMPANY_NOT_FOUND;
import static com.bookIt.demo.enums.code.role.RoleCodeError.ROLE_NOT_FOUND;
import static com.bookIt.demo.enums.code.worker.WorkerError.WORKER_NOT_FOUND;
import static com.bookIt.demo.enums.code.workerCompany.WorkerCompanyError.UPDATING_ROLE_WORKER_COMPANY_FAIL;
import static com.bookIt.demo.enums.code.workerCompany.WorkerCompanyError.WORKER_FROM_COMPANY_NOT_FOUND;

@Service
public class WorkerCompanyService {

    @Autowired
    private WorkerCompanyRepository workerCompanyRepo;
    @Autowired
    private WorkerService workerSvc;
    @Autowired
    private CompanyService companySvc;
    @Autowired
    private RoleService roleSvc;


    public List<Worker> findWorkersByCompanyId(Integer companyId) {
        return workerCompanyRepo.findWorkersByCompanyId(companyId);
    }

    public Worker removeFromCompany(Integer companyId, Integer workerId) {
        return workerCompanyRepo.deleteByCompanyIdAndWorkerId(companyId, workerId);
    }

    public List<Worker> getWorkersWithFreePlanningForService(int companyId, LocalDateTime date, int serviceId) {
        LocalDateTime dateStart = LocalTime.MIN.atDate(LocalDate.from(date));
        LocalDateTime dateEnd = LocalTime.MAX.atDate(LocalDate.from(date));
        return workerCompanyRepo.getWorkersWithFreePlanningForService(companyId, dateStart, dateEnd, serviceId);
    }

    public Worker addWorkerToCompany(int idCompany, int idWorker) throws FunctionalException {
        Worker worker = workerSvc.findById(idWorker);
        if (worker == null) throw new FunctionalException(WORKER_NOT_FOUND);
        Company company = companySvc.findById(idCompany);
        if (company == null) throw new FunctionalException(COMPANY_NOT_FOUND);

        WorkerCompany workerCompany = new WorkerCompany().builder()
                .worker(worker)
                .company(company)
                .build();
        return workerCompanyRepo.save(workerCompany).getWorker();
    }

    public void findWorkerCompanyByCompanyIdAndWorkerId(int companyId, int workerId) {
        workerCompanyRepo.findWorkerCompanyByCompanyIdAndWorkerId(companyId, workerId);
    }

    public WorkerCompany addRoleToWorker(int companyId, int workerId, int roleId) throws FunctionalException {
        WorkerCompany workerCompany = workerCompanyRepo.findWorkerCompanyByCompanyIdAndWorkerId(companyId, workerId);
        if (workerCompany == null) throw new FunctionalException(WORKER_FROM_COMPANY_NOT_FOUND);
        Role role = roleSvc.findById(roleId);
        if (role == null) throw new FunctionalException(ROLE_NOT_FOUND);
        workerCompany.getRoles().add(role);
        WorkerCompany savedWorkerCompany = workerCompanyRepo.save(workerCompany);
        if (savedWorkerCompany == null) throw new FunctionalException(UPDATING_ROLE_WORKER_COMPANY_FAIL);
        return savedWorkerCompany;
    }

    public WorkerCompany findByEmailAndIdCompany(String username, Integer idCompany) {
        return workerCompanyRepo.findByEmailAndCompanyId(username, idCompany);
    }

    public WorkerCompany save(WorkerCompany workerCompany) {
        return workerCompanyRepo.save(workerCompany);
    }
}
