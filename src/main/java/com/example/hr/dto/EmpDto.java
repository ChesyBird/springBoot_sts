package com.example.hr.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmpDto {
	private int empId;
	private String empName;
	private String email;
	private String empNo;
	private LocalDate hireDate;
	private String phone;
	private int salary;
	private float bonus;
	
	// entYn : 퇴직여부(N: 재직 / Y: 퇴사)
	private String entYn;
	// entYn=Y : active = false
	// entYn=N : active = true
	private boolean active;
	
	public void setEntYn(String entYn) {
		this.entYn = entYn;
		active = entYn.equalsIgnoreCase("Y") ? false : true;

	}
	
	
}
