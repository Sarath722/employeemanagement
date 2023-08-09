package com.developersarath.employeemanagement.controller;

import com.developersarath.employeemanagement.entity.Employee;
import com.developersarath.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService eService;
    // Get all the employee list
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> listEmployees=eService.getAllEmployee();
        return new ResponseEntity<>(listEmployees,HttpStatus.OK);
    }
    // Get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
       Optional<Employee> employee=eService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Save new employee
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){

       return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
    }

    // update employee by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = eService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }
    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
       boolean deleted= eService.deleteEmployeeById(id);
       if (deleted){
           return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully!");
       }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No employee found in this id: "+id);
    }

}
