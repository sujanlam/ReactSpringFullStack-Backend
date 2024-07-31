package com.horizon.ems.service.impl;

import com.horizon.ems.dto.EmployeeDto;
import com.horizon.ems.entity.Employee;
import com.horizon.ems.mapper.EmployeeMapper;
import com.horizon.ems.exceptions.ResourceNotFoundException;
import com.horizon.ems.mapper.EmployeeMapper;
import com.horizon.ems.repository.EmployeeRepository;
import com.horizon.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + employeeId + " not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    /*Pagination with Pageable*/
    /*@Override
    public Page<EmployeeDto> getAllEmployeesWithPagination(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        return employeePage.map(EmployeeMapper::mapToEmployeeDto);
    }*/


    @Override
    public EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + empId + " not found")
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setClub(updatedEmployee.getClub());

        Employee emp = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + empId + " not found")
        );
        employeeRepository.deleteById(empId);
    }
}
