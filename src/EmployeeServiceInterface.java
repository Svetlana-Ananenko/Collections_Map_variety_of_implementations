package com.ollection.hw;

import java.util.Collection;

public interface EmployeeServiceInterface {
    com.ollection.hw.Employee add (String firstName, String lastName);
    com.ollection.hw.Employee remove(String firstName, String lastName);
    com.ollection.hw.Employee find(String firstName, String lastName);

    Collection<com.ollection.hw.Employee> findAll();
}
