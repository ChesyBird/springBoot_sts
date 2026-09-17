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
	
	@Test
	public void saveDept() {
		DeptsDto dto = new DeptsDto();
		dto.setDeptId("A4");
		dto.setDeptTitle("신규사업부");
		dto.setLocationId("L2");
		
		int res = mapper.saveDept(dto);
		assertEquals(1, res);
		
		if(res > 0) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
		
	}
	
	@Test
	public void deleteDept() {
		int res = mapper.deleteDept("A1");
		assertEquals(1, res);
		
		if(res > 0) {
			System.out.println("삭제 되었습니다.");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
}
