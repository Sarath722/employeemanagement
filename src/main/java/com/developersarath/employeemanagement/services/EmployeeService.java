package com.developersarath.employeemanagement.services;

import com.developersarath.employeemanagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    Optional<Employee> getEmployeeById(long id);
    String saveEmployee(Employee employee);

    boolean deleteEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
