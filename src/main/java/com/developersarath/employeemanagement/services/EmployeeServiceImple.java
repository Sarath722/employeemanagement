package com.developersarath.employeemanagement.services;

import com.developersarath.employeemanagement.EmployeeRepository;
import com.developersarath.employeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImple implements EmployeeService {
    @Autowired
    private  EmployeeRepository eRepo;

    @Override
    public String saveEmployee(Employee employee) {
//        Set<Employee> employeeList= (Set<Employee>) eRepo.findAll();
//        if(employeeList.contains(employee)){
//            return "this employee already registered!";
//        }{
            eRepo.save(employee);
            return "new Employee registered successfully!";
       // }

    }

    @Override
    public boolean deleteEmployeeById(Long id) {
            eRepo.deleteById(id);
        return true;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
         eRepo.saveAndFlush(employee);
        return null;
    }

    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee> employeeslist= eRepo.findAll();
        return employeeslist;
    }
    @Override
    public Optional<Employee> getEmployeeById(long id) {
        Employee employee=eRepo.findById(id)
                .orElse(null);
        return Optional.ofNullable(employee);
    }
}
