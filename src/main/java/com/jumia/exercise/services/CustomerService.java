package com.jumia.exercise.services;

import com.jumia.exercise.persistence.Customer;
import com.jumia.exercise.persistence.repositories.CustomerRepository;
import com.jumia.exercise.services.repositories.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService implements CustomerServiceRepository {

    private CustomerRepository customerRepository;
    private PhoneService phoneService;


    @Autowired
    public CustomerService( CustomerRepository customerRepository,
                            PhoneService phoneService) {
        this.customerRepository = customerRepository;
        this.phoneService = phoneService;
    }


    /**
     *
     * @param paging options
     * @return Page<Customer> page of customers
     */
    @Override
    public Page<Customer> listAllCustomers(Pageable paging){
        return customerRepository.findAll(paging);
    }


    /**
     *
     * @param state customer state
     * @param country customer country
     * @return List<Customer> filtered
     */
    public List<Customer> listFilteredCustomers(String state, String country){
        List<Customer> result =  customerRepository.findAll();
        return result.stream().filter(customer -> phoneService.filter(customer, state, country) != null)
                .collect(Collectors.toList());
    }
}
