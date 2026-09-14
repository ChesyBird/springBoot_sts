package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hr.service.DeptsService;

import lombok.RequiredArgsConstructor;

@Controller
// 생성자 주입
@RequiredArgsConstructor
public class DeptsController {

	private final DeptsService service;
	
	@GetMapping("/depts")
	public void depts(Model model) {
		service.totalCnt();
		model.addAttribute("totalCnt", service.totalCnt());
		model.addAttribute("list", service.selectAll());
	}
	
}
