package com.example.hr.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hr.dto.DeptsDto;
import com.example.hr.service.DeptsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
// 생성자 주입
@RequiredArgsConstructor
@Slf4j
public class DeptsController {

	private final DeptsService service;
	
	@GetMapping("/depts")
	public void depts(Model model) {
		service.totalCnt();
		model.addAttribute("totalCnt", service.totalCnt());
		model.addAttribute("list", service.selectAll());
	}
	
	/*
	 * 부서 등록 -> 리스트 페이지 -> 메세지 출력 
	 */
	@PostMapping("/saveDept")
	public String depts(@ModelAttribute DeptsDto dept, Model model) {
		log.info("dept : " + dept);
		// 데이터베이스에 저장
		try {
			int res = service.saveDept(dept);
			if(res > 0) {
				model.addAttribute("msg", "등록 되었습니다.");
			}
		} catch (Exception e) {
			model.addAttribute("error", "등록 실패 되었습니다.");
		}
		//리스트가 안 보이는 이유 -> 모델에 저장을 안해서
		model.addAttribute("list", service.selectAll());
		return "depts";
	}
	
}
