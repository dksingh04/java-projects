package com.dk.array;

import java.util.Comparator;

public class EmployeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
