package tech.getarrays.employeemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    private final EmployeeService employeeService;

    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<employee>> getAllEmployee(){
        List<employee> employees=employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<employee> getEmployById(@PathVariable("id") Long id){
        employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<employee> addEmployee(@RequestBody employee employee){
        employee newemployee= employeeService.addEmployee(employee);
        return new ResponseEntity<>(newemployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<employee> updateEmployee(@RequestBody employee employee){
        employee updateEmployee= employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
