package com.bookIt.demo.service;

import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.UserAccount;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bookIt.demo.enums.code.customer.CustomerError.CUSTOMER_ALREADY_EXIST;
import static com.bookIt.demo.enums.code.customer.CustomerError.CUSTOMER_NOT_FOUND;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private UserAccountService userSvc;

    public Customer save(Customer customer) throws FunctionalException {
        UserAccount userFromDb = userSvc.findByEmail(customer.getUser().getEmail());
        if (userFromDb != null) {
            if (userFromDb.getCustomer() != null) throw new FunctionalException(CUSTOMER_ALREADY_EXIST);
            customer.getUser().setId(userFromDb.getId());
        }
        return customerRepo.save(customer);
    }

    public Customer findByEmail(String username) {
        return customerRepo.findByEmail(username);
    }

    public Customer findById(int customerId) throws FunctionalException {
        Customer customer = customerRepo.findById(customerId).get();
        if (customer == null) {
            throw new FunctionalException(CUSTOMER_NOT_FOUND);
        }
        return customer;
    }
}
