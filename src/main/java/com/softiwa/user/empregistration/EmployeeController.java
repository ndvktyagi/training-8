package com.softiwa.user.empregistration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam String password) {
        return employeeService.saveEmployee(employeeDto);
    }
}
