package com.softiwa.user.empregistration;

import java.util.List;

public interface EmployeeService {
	String saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto>getAllEmployee();
    EmployeeDto getEmployee(int id);
    void deleteEmployee(int id);
}
