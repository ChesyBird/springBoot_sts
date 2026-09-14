package com.example.hr.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hr.dto.DeptsDto;

@SpringBootTest
public class DeptsMapperTest {

	@Autowired
	DeptsMapper mapper;
	
	@Test
	public void totalCnt() {
		int totalCnt = mapper.totalCnt();
		System.out.println(totalCnt);
		
		// 검증
		assertEquals(9, totalCnt);
		
	}
	
	@Test
	public void selectAll() {
		List<DeptsDto> list = mapper.selectAll();
		
		assertEquals(9, list.size());
	}
	
}
