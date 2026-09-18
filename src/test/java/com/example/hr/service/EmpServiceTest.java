package com.example.hr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpServiceTest {

	@Autowired
	EmpService service;
	
	@Test
	public void test() {
		int totalCnt = service.totalCnt();
		System.out.println(totalCnt);
		
		assertEquals(21, totalCnt);
	}
	
	@Test
	public void selectByCond() {
		service.selectByCond(null);
	}
	
	@Test
	public void login_없는아이디() {
		try {
			service.login("id1234", "1234");
		} catch (Exception e) {
			// TODO 사용자 정의 예외처리로 변경하기
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
	
	@Test
	public void login_계정잠김() {
		// 잠긴 계정을 이용해서 테스트
		try {
			service.login("210", "1234");
		} catch (Exception e) {
			// TODO 사용자 정의 예외처리로 변경하기
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
	
	@Test
	public void login_정상처리() {
		// 잠긴 계정을 이용해서 테스트
		try {
			service.login("201", "1234");
		} catch (Exception e) {
			// TODO 사용자 정의 예외처리로 변경하기
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
	
}
