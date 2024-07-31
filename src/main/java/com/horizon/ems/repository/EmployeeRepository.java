package com.horizon.ems.repository;

import com.horizon.ems.dto.EmployeeDto;
import com.horizon.ems.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
