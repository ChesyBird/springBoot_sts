package com.example.hr.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpDtoTest {

	@Test
	public void test() {
		EmpDto emp = new EmpDto();
		emp.getEmail();
	}
	
}
