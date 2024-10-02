package com.softiwa.user.empregistration;

import com.softiwa.user.emprole.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee") //  employee_entity
// default employee_entity
public class EmployeeEntity {
    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID empId;

    private String empName;

    @Column(name="emp_email")
    private String empEmailId;

    @Column(name="emp_mob")
    private Long empMobileNo;

    @Column(name="emp_curr_add")
    private String empCurrentAddress;

    @Column(name="emp_per_add")
    private String empPermanentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private RoleEntity roleEntity;

    //field name:- role_entity_role_id

}
