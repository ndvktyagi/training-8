package com.softiwa.user.empregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepository1 {

    String URL = "jdbc:postgresql://localhost:5432/user-mgr";
    String USER = "postgres";
    String PASSWORD = "root";

    public String saveEmployee(EmployeeDto employeeDto) {

        // JDBC code to insert data
        String insertSQL = "INSERT INTO Employee (empId, empName, empEmailId, empMobileNo, empCurrentAddress, empPermanentAddress) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

           // preparedStatement.setUUID(1, employeeDto.getEmpId());
            preparedStatement.setString(2, employeeDto.getEmpName());
            preparedStatement.setString(3, employeeDto.getEmpEmailId());
            preparedStatement.setLong(4, employeeDto.getEmpMobileNo());
            preparedStatement.setString(5, employeeDto.getEmpCurrentAddress());
            preparedStatement.setString(6, employeeDto.getEmpPermanentAddress());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Data has been saved successfully";
    }
}

