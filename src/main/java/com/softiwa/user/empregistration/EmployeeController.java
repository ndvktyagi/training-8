package com.softiwa.user.empregistration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }
    @GetMapping("/getAll")
    public List<EmployeeDto> getAllEmployees()
    {
    	return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable int id) {
    	return employeeService.getEmployee(id);
    }
    @DeleteMapping("/{id}")
    public String deleteEmpById(@PathVariable int id)
    {
    	employeeService.deleteEmployee(id);
    	
    	return "Deleted successfully";
    }
    
    @PostMapping("/updateEmp")
    public String updateEmp(EmployeeDto emp)
    {
    	employeeService.saveEmployee(emp);
    	
    	return "updated Successfully";
    }
}
