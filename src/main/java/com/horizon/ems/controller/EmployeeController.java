package com.horizon.ems.controller;

import com.horizon.ems.dto.EmployeeDto;
import com.horizon.ems.entity.Employee;
import com.horizon.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto empDto = employeeService.updateEmployee(empId, employeeDto);

        return ResponseEntity.ok(empDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }

    /*Pagination with Pageable*/
    /*@GetMapping("/empwithpage")
    public Page<EmployeeDto> getAllEmployeesWithPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getAllEmployeesWithPagination(pageable);
    }*/

}
