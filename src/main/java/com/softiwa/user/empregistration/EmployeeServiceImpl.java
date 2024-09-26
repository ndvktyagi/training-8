package com.softiwa.user.empregistration;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
    

	public String saveEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDto,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Data has been saved successfully using JPA";
    }
	
	
	
	
	
	   @Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}





	@Override
	public EmployeeDto getEmployee(int id) {
		  Optional<EmployeeEntity> emp = employeeRepository.findById(id);

		    // If the employee is present, convert it to EmployeeDto
		    if (emp.isPresent()) {
		        EmployeeEntity employeeEntity = emp.get();
		        return convertToDto(employeeEntity);
		    } 

		    // If employee is not found, return null (or an empty DTO)
		    return null;
	   }




	public List<EmployeeDto> getAllEmployee() {
	        // Fetch all Employee entities
	        List<EmployeeEntity> employees = (List<EmployeeEntity>) employeeRepository.findAll();

	        // Convert Employee entities to EmployeeDto
	        return employees.stream()
	                .map(this::convertToDto) // Mapping Employee to EmployeeDto
	                .collect(Collectors.toList());
	    }
	
	private EmployeeDto convertToDto(EmployeeEntity employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(employee.getEmpId());
        employeeDto.setEmpName(employee.getEmpName());
        employeeDto.setEmpCurrentAddress(employee.getEmpCurrentAddress());
        employeeDto.setEmpEmailId(employee.getEmpEmailId());
        employeeDto.setEmpMobileNo(employee.getEmpMobileNo());
        employeeDto.setEmpPermanentAddress(employee.getEmpPermanentAddress());
        employeeDto.setRole(employee.getRole());
        
        return employeeDto;
    }

}
