package com.example.hr.service;

import org.springframework.ui.Model;

public interface EmpService {
	int totalCnt();
	void selectByCond(Model model);
}
