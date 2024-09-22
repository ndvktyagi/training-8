package com.softiwa.user.empregistration;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //EmployeeRepository employeeRepository = new EmployeeRepository();

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDto,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Data has been saved successfully using JPA";
    }

}
