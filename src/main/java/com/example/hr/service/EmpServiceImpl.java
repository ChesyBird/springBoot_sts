package com.example.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.hr.dto.EmpDto;
import com.example.hr.mapper.EmpMapper;

/*
 * 인터페이스의 구현체
 */
@Service
public class EmpServiceImpl implements EmpService {
	// DI
	// 1. Setter주입
	// 2. 생성자주입
	// 3. @Autowired : 필드 주입
	// 리플렉션으로 필드에 직접 주입
	// 많이 사용됨 : @Autowired
	
	// 스프링 상 권장 : 생성자 주입
	private final EmpMapper mapper;
	
	public EmpServiceImpl(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}

	@Override
	public void selectByCond(Model model) {
		List<EmpDto> list = mapper.selectByCond();
		int totalCnt = mapper.totalCnt();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", totalCnt);
	}
	
}
