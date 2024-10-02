package com.softiwa.user.emprole;

import com.softiwa.user.empregistration.EmployeeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleId;
    private String roleName;

    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeEntity employeeEntity;
    // employee_entity.emp_id

}
