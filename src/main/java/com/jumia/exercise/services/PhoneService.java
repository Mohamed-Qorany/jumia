package com.jumia.exercise.services;


import com.jumia.exercise.persistence.Customer;
import com.jumia.exercise.services.repositories.PhoneServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements PhoneServiceRepository {

    /**
     * filter customer
     * @param customer customer
     * @param state state
     * @param country country
     * @return Customer
     */
    @Override
    public Customer filter(Customer customer, String state, String country){
        return customer.getState().equalsIgnoreCase(state) &&
                customer.getCountry().equalsIgnoreCase(country) ? customer : null;
    }
}
