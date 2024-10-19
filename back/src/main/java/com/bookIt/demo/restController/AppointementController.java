package com.bookIt.demo.restController;

import com.bookIt.demo.dto.AppointementDTO;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.Appointement;
import com.bookIt.demo.service.AppointementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointement")
public class AppointementController {

    @Autowired
    private AppointementService appointementSvc;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{companyId}/{serviceId}/{customerId}")
    public AppointementDTO create(@PathVariable int companyId, @PathVariable int serviceId, @PathVariable int customerId) throws FunctionalException {
        Appointement appointement = appointementSvc.create(companyId, serviceId, customerId);
        return mapper.map(appointement, AppointementDTO.class);
    }

    @GetMapping("/{idCustomer}")
    public List<AppointementDTO> findByCustomerId(@PathVariable int idCustomer) {
        List<Appointement> appointements = appointementSvc.findByCustomerId(idCustomer);
        return appointements
                .stream()
                .map(element -> mapper.map(element, AppointementDTO.class))
                .toList();
    }
}
