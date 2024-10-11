package com.bookIt.demo.restController;

import com.bookIt.demo.dto.WorkerDto;
import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")

public class WorkerController {

    @Autowired
    private WorkerService workerSvc;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/create")
    public WorkerDto createCity(@RequestBody Worker worker) {
        Worker savedWorker = workerSvc.createWorker(worker);
        return mapper.map(savedWorker, WorkerDto.class);
    }

}
