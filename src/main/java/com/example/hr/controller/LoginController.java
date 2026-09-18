package com.example.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hr.dto.EmpDto;
import com.example.hr.service.EmpService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	// @RequiredArgsConstructor를 이용한 생성자 주입	
	private final EmpService service;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	// login -> post방식
	// id, pw 수집
	// 로그인 -> 회원 목록 페이지로 이동
	
	//postman 사이트에서 테스트 가능
	@PostMapping("/login")
	public String loginAction(@RequestParam(name="id") String id, @RequestParam(name="pw") String pw, HttpSession session, Model model) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		/* 
		 * 1. 아이디 비밀번호 검증
		 *	입력된 아이디로 사용자 조회
		 *  비밀번호 일치하면 로그인 성공 -> 세션에 사용자 정보 저장 및 암호화
		 *  -> 사원 목록 페이지로 이동
		 * 2. 비밀번호가 일치하지 않음
		 * 	-> 실패 카운팅(5회 초과실패시 계정 잠금)
		 *  -> 메세지 처리 후 뒤로가기 
		 */
		try {
			EmpDto emp = service.login(id, pw);
			// 인증된 사용자의 정보를 세션 영역에 저장
			session.setAttribute("user", emp);
			// 사원 목록 페이지로 이동하기
			return "redirect:emps";
		} catch (Exception e) {
			// failCnt업데이트
			// e.printStackTrace();
			// 로그인 실패 카운팅, 계정잠금처리
			service.updateFailCnt(id);
			
			// 오류 메세지 내용을 화면에 전달
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// 세션 초기화
		session.invalidate();
		
		return "/login";
	}

}
