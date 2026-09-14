package com.example.hr.service;

import java.util.List;

import com.example.hr.dto.DeptsDto;

public interface DeptsService {

	// default가 기본인 일반 클래스와 달리 인터페이스의 기본은 public
	public int totalCnt();
	
	public List<DeptsDto> selectAll();
	
}
