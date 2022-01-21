package com.jumia.exercise.inbounds;


import com.jumia.exercise.persistence.Customer;
import com.jumia.exercise.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerResource {

    private CustomerService customerService;

    @Autowired
    public CustomerResource( CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public Page<Customer> list( @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size) {
        return customerService.listAllCustomers(PageRequest.of(page, size));
    }

    @GetMapping("/filter")
    public List<Customer> list(@RequestParam("state") String state,
                               @RequestParam(value = "country", required = false, defaultValue = "") String country) {
        return customerService.listFilteredCustomers(state, country);
    }
}
