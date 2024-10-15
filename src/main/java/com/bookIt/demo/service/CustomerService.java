package com.bookIt.demo.service;

import com.bookIt.demo.entity.Customer;
import com.bookIt.demo.entity.User;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bookIt.demo.enums.code.customer.CustomerError.CUSTOMER_ALREADY_EXIST;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private UserService userSvc;

    public Customer save(Customer customer) throws FunctionalException {
        User userFromDb = userSvc.findByEmail(customer.getUser().getEmail());
        if (userFromDb.getCustomer() != null) throw new FunctionalException(CUSTOMER_ALREADY_EXIST);
        if (userFromDb != null) customer.getUser().setId(userFromDb.getId());
        return customerRepo.save(customer);
    }

}
