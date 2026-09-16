package com.example.hr.dto;

import lombok.Data;

@Data
public class DeptsDto {

	// dept테이블
	private String deptId;
	private String deptTitle;
	private String locationId;
	
	// 조인 결과 수집되는 정보
	private String nationalName;
	private int cnt;
	private double avg;
	
}
