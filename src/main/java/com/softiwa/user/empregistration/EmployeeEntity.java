package com.softiwa.user.empregistration;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empEmailId;
    private Long empMobileNo;
    private String empCurrentAddress;
    private String empPermanentAddress;
    private String role;
}
