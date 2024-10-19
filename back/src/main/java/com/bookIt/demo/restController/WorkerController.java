package com.bookIt.demo.restController;

import com.bookIt.demo.dto.AppointementDTO;
import com.bookIt.demo.dto.WorkerDTO;
import com.bookIt.demo.model.Appointement;
import com.bookIt.demo.service.WorkerService;
import com.bookIt.demo.model.Worker;
import com.bookIt.demo.exception.FunctionalException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerSvc;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/create")
    public WorkerDTO createWorker(@RequestBody Worker worker) throws FunctionalException {
        Worker savedWorker = workerSvc.createWorker(worker);
        return mapper.map(savedWorker, WorkerDTO.class);
    }

    @PostMapping("/update")
    public WorkerDTO updateWorker(@RequestBody Worker worker) throws FunctionalException {
        Worker updatedWorker = workerSvc.update(worker);
        return mapper.map(updatedWorker, WorkerDTO.class);
    }

    @GetMapping("/all")
    public List<WorkerDTO> getAllWorkers() throws FunctionalException {
        List<Worker> workers = workerSvc.findAll();
        return workers.stream().map(worker -> mapper.map(worker, WorkerDTO.class)).toList();
    }

}
