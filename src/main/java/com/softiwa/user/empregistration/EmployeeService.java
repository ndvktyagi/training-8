package com.softiwa.user.empregistration;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    String saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(UUID empId);
    List<EmployeeDto> getAllEmployee();
    String deleteEmployee(UUID empId);
    String updateEmployee(EmployeeDto employeeDto);
}
