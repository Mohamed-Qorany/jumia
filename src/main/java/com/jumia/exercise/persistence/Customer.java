package com.jumia.exercise.persistence;


import com.jumia.exercise.services.repositories.PhoneServiceRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Transient
    private String state="not valid";

    @Transient
    private String country = "";

    public String getState() {
        PhoneServiceRepository.categorize(this);
        return state;
    }
}
