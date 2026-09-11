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
	
}
