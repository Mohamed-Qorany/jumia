package com.jumia.exercise.services.repositories;

import com.jumia.exercise.persistence.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerServiceRepository {
    Page<Customer> listAllCustomers(Pageable paging);
}
