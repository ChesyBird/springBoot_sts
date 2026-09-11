package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hr.dto.EmpDto;
import com.example.hr.service.EmpService;

// templates : 경로의 파일은 컨트롤러를 통해서만
// static : 요청하면 바로 서비스
@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	// 여러개의 주소를 매핑: 배열을 사용
	@GetMapping({"/", "/emps"})
	public String getEmpIndx(Model model) {
		// model.addAttribute("totalCnt", service.totalCnt());
		service.selectByCond(model);
		return "/index";
	}
	
	/*
	 * 사원 상세화면
	 * 사번을 이용해서 사원정보를 조회 후 화면에 전달
	 */
	@GetMapping("/emp-detail")
	public void empDetail(@RequestParam(value = "empId", defaultValue = "") String empId
							, Model model) {
		System.out.println("empId : " + empId);
		// log.info("empId" + empId)
		
		EmpDto emp = service.selectById(empId);
		model.addAttribute("emp", emp);
				
	}
	
	
	
}
