package com.bookIt.demo.mapper;

import com.bookIt.demo.dto.WorkerDTO;
import com.bookIt.demo.model.Worker;

public class WorkerMapper {

    public static WorkerDTO toDto(Worker worker) {
        WorkerDTO dto = new WorkerDTO();
//        dto.setWorkerId(worker.getId());
//        dto.setWorkerEmail(worker.getUser().getEmail());
//        dto.setWorkerFirstName(worker.getUser().getFirstName());
//        dto.setWorkerLastName(worker.getUser().getLastName());
//        dto.setWorkerPhoneNumber(worker.getUser().getPhoneNumber());
        return dto;
    }
}
