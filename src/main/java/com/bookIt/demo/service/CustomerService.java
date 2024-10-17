package com.bookIt.demo.service;

import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.UserAccount;
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
    private UserAccountService userSvc;

    public Customer save(Customer customer) throws FunctionalException {
        UserAccount userFromDb = userSvc.findByEmail(customer.getUser().getEmail());
        if (userFromDb.getCustomer() != null) throw new FunctionalException(CUSTOMER_ALREADY_EXIST);
        if (userFromDb != null) customer.getUser().setId(userFromDb.getId());
        return customerRepo.save(customer);
    }

    public Customer findByEmail(String username) {
        return customerRepo.findByEmail(username);
    }
}
