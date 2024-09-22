package com.softiwa.user.empregistration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class EmployeeDto {
    @Id
    private int empId;
    private String empName;
    private String empEmailId;
    private Long empMobileNo;
    private String empCurrentAddress;
    private String empPermanentAddress;
    private String role;

}


