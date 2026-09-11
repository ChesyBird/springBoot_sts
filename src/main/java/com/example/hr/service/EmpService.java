package com.example.hr.service;

import org.springframework.ui.Model;

import com.example.hr.dto.EmpDto;

public interface EmpService {
	int totalCnt();
	
	void selectByCond(Model model);
	
	EmpDto selectById(String empId);
}
