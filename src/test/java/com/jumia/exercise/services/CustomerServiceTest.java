package com.jumia.exercise.services;

import com.jumia.exercise.persistence.Customer;
import com.jumia.exercise.services.repositories.PhoneServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void listAllCustomers() {
        Page<Customer> page = customerService.listAllCustomers(PageRequest.of(1, 5));
        assertNotNull(page);
        page.get().forEach(customer -> {
            if(customer.getState().equalsIgnoreCase("valid")){
                PhoneServiceRepository.categorize(customer);
                assertEquals("valid", customer.getState());
            }
        });
    }

    @Test
    void listFilteredCustomers() {
       List<Customer> filteredCustomers = customerService.listFilteredCustomers("valid", "Morocco");
       assertTrue(!filteredCustomers.isEmpty());
       filteredCustomers.forEach(customer -> assertEquals(customer.getState(), "valid"));
       assertTrue(customerService.listFilteredCustomers("valid", "uu").isEmpty());
    }
}