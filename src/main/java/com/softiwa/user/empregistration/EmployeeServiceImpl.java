package com.softiwa.user.empregistration;

import com.softiwa.user.emprole.RoleEntity;
import com.softiwa.user.emprole.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public String saveEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDto,employeeEntity);

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName((employeeDto.getRole()));
        roleEntity.setEmployeeEntity(employeeEntity);

        employeeEntity.setRoleEntity(roleEntity);

        employeeRepository.save(employeeEntity);
        return "Data has been saved successfully using JPA";
    }

    @Override
    public EmployeeDto getEmployee(UUID empId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeEntity,employeeDto);
        employeeDto.setRole(employeeEntity.getRoleEntity().getRoleName());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for(EmployeeEntity employeeEntity : employeeEntityList){
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employeeEntity,employeeDto);
            employeeDto.setRole(employeeEntity.getRoleEntity().getRoleName());
            employeeDtoList.add(employeeDto);
        }

        return employeeDtoList;
    }

    @Override
    public String deleteEmployee(UUID empId) {
        employeeRepository.deleteById(empId);
        return "Employee has been deleted successfully";
    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDto.getEmpId()).get();
        if(employeeDto.getEmpName()!=null){
            employeeEntity.setEmpName(employeeDto.getEmpName());
        }
        if(employeeDto.getEmpEmailId()!=null){
            employeeEntity.setEmpEmailId(employeeDto.getEmpEmailId());
        }
        if(employeeDto.getEmpMobileNo()!=null){
            employeeEntity.setEmpMobileNo(employeeDto.getEmpMobileNo());
        }
        if(employeeDto.getEmpCurrentAddress()!=null){
            employeeEntity.setEmpCurrentAddress(employeeDto.getEmpCurrentAddress());
        }
        if(employeeDto.getEmpPermanentAddress()!=null){
            employeeEntity.setEmpPermanentAddress(employeeDto.getEmpPermanentAddress());
        }
        employeeRepository.save(employeeEntity);
        return "Employee has been updated successfully";
    }


}
