package com.example.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.hr.dto.EmpDto;

/*
* 1. 쿼리는 잘 실행되는지 확인을 위해 클라이언트 도구(MySQL워크벤치)에서 확인
* 2. ;은 제거해야함
* 3. 테스트 진행
*/
@Mapper
public interface EmpMapper {
	// 전체 사원의 수를 카운트
	@Select("select count(*) from emp")
	public int totalCnt();
	
	public List<EmpDto> selectByCond();

	@Select("select * from emp where emp_id=#{id}")
	public EmpDto selectById(String id);
	
	
	
}
