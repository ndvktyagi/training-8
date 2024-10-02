package com.softiwa.user.empregistration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID empId;
    private String empName;
    private String empEmailId;
    private Long empMobileNo;
    private String empCurrentAddress;
    private String empPermanentAddress;
    private String role;

}


