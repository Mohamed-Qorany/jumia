package com.jumia.exercise;

import com.jumia.exercise.persistence.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TestDataBuilder {

    public static Page<Customer> buildCustomerPage(int page, int size){
       return new Page<Customer>() {
            @Override
            public int getTotalPages() {
                return 2;
            }

            @Override
            public long getTotalElements() {
                return 50;
            }

            @Override
            public <U> Page<U> map(Function<? super Customer, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return size;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<Customer> getContent() {
                return Arrays.asList(new Customer((long) 1, "Mohamed", "(212) 6007989253", "not valid", ""));
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<Customer> iterator() {
                return null;
            }
        };
    }


}
