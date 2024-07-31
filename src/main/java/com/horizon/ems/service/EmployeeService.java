package com.horizon.ems.service;

import com.horizon.ems.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    /*Pagination with Pageable*/
    /*Page<EmployeeDto> getAllEmployeesWithPagination(Pageable pageable);*/

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

}
