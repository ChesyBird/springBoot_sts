package com.example.hr.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hr.dto.EmpDto;

/*
 * 스프링컨테이너로부터 객체를 주입받기 위해서
 * @SpringBootTest 어노테이션 필수
 */
@SpringBootTest
public class EmpMapperTest {
	
	/*
	 * DI(의존성주입)
	 * 객체를 직접 생성하지 않고 프레임 워크로부터 주입받아 사용
	 */
	@Autowired
	EmpMapper mapper;
	/*
	 * 테스트를 하기 위해서는
	 * @Test 어노테이션 붙여줘야함 
	 */
	@Test
	public void test1() {
		int totalCnt = mapper.totalCnt();
		System.out.println(totalCnt);
		
		// 검증
		assertEquals(21, totalCnt);
		
	}
	
	@Test
	public void selectByCond() {
		List<EmpDto> list = mapper.selectByCond();
		System.out.println(list);
	}
	
	@Test
	public void selectById() {
		EmpDto emp = mapper.selectById("200");
		System.out.println(emp);
		
		assertNull(emp);
	}
	
	@Test
	public void selectByUserId() { 
		EmpDto emp = mapper.selectByUserId("200");
		System.out.println(emp);
		
		assertNull(emp);
	}
	
}
