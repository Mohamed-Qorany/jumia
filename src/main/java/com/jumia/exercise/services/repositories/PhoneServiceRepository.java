package com.jumia.exercise.services.repositories;

import com.jumia.exercise.persistence.Customer;

import java.util.AbstractMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PhoneServiceRepository {

    // just for exercise purposes (in real case will be a db table)
    Map<String, String> countries = Stream.of(
                    new AbstractMap.SimpleEntry<>("Cameroon",  "\\(237\\)\\ ?[2368]\\d{7,8}$"),
                    new AbstractMap.SimpleEntry<>("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$"),
                    new AbstractMap.SimpleEntry<>("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$"),
                    new AbstractMap.SimpleEntry<>("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$"),
                    new AbstractMap.SimpleEntry<>("Uganda", "\\(256\\)\\ ?\\d{9}$"))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Customer filter(Customer customer, String state, String country);
    static void categorize (Customer customer){
        countries.forEach((country, regex) -> {
            if(Pattern.matches(regex, customer.getPhone())){
                customer.setState("valid");
                customer.setCountry(country);
            }
        });
    }
}
