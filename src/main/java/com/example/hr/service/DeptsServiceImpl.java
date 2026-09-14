package com.example.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hr.dto.DeptsDto;
import com.example.hr.mapper.DeptsMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptsServiceImpl implements DeptsService {

	private final DeptsMapper mapper;
	
	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}

	@Override
	public List<DeptsDto> selectAll() {
		return mapper.selectAll();
		
		
	}

}
