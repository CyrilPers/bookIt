package com.bookIt.demo.restController;

import com.bookIt.demo.model.Address;
import com.bookIt.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressSvc;

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address) {
        return addressSvc.createAddress(address);
    }
}
