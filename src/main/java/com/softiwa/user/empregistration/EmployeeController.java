package com.softiwa.user.empregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    EmployeeService employeeService1 = new EmployeeServiceImpl();

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam String userName, @RequestHeader(required = false) String Password) {
        //duplicate records validation
        //null validation
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/employee")
    public EmployeeDto getEmployee(@RequestParam UUID empId) {
        System.out.println("Here is the UUID : " + empId);
        return employeeService.getEmployee(empId);
    }

    @GetMapping("/all-employee")
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(UUID empId) {
       return employeeService.deleteEmployee(empId);
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }
}


// http://127.0.0.1:8080/emp/save
// http://localhost:8080/emp/save

// http://localhost:8080/emp/save?userName=admin