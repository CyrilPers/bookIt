package com.bookIt.demo.restController;

import com.bookIt.demo.dto.WorkerDto;
import com.bookIt.demo.service.WorkerService;
import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.exception.FunctionalException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerSvc;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/create")
    public WorkerDto createWorker(@RequestBody Worker worker) throws FunctionalException {
        Worker savedWorker = workerSvc.createWorker(worker);
        return mapper.map(savedWorker, WorkerDto.class);
    }

    @PostMapping("/update")
    public WorkerDto updateWorker(@RequestBody Worker worker) throws FunctionalException {
        Worker updatedWorker = workerSvc.update(worker);
        return mapper.map(updatedWorker, WorkerDto.class);
    }

}
