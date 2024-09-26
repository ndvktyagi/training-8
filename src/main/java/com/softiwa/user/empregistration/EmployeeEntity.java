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
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getEmpEmailId() {
			return empEmailId;
		}
		public void setEmpEmailId(String empEmailId) {
			this.empEmailId = empEmailId;
		}
		public Long getEmpMobileNo() {
			return empMobileNo;
		}
		public void setEmpMobileNo(Long empMobileNo) {
			this.empMobileNo = empMobileNo;
		}
		public String getEmpCurrentAddress() {
			return empCurrentAddress;
		}
		public void setEmpCurrentAddress(String empCurrentAddress) {
			this.empCurrentAddress = empCurrentAddress;
		}
		public String getEmpPermanentAddress() {
			return empPermanentAddress;
		}
		public void setEmpPermanentAddress(String empPermanentAddress) {
			this.empPermanentAddress = empPermanentAddress;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public EmployeeEntity(int empId, String empName, String empEmailId, Long empMobileNo, String empCurrentAddress,
				String empPermanentAddress, String role) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empEmailId = empEmailId;
			this.empMobileNo = empMobileNo;
			this.empCurrentAddress = empCurrentAddress;
			this.empPermanentAddress = empPermanentAddress;
			this.role = role;
		}
		public EmployeeEntity() {
			
		}
		@Override
		public String toString() {
			return "EmployeeEntity [empId=" + empId + ", empName=" + empName + ", empEmailId=" + empEmailId
					+ ", empMobileNo=" + empMobileNo + ", empCurrentAddress=" + empCurrentAddress + ", empPermanentAddress="
					+ empPermanentAddress + ", role=" + role + "]";
		}
}
