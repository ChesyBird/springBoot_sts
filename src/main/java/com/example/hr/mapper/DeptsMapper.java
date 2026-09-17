package com.example.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.hr.dto.DeptsDto;

@Mapper
public interface DeptsMapper {

	@Select("select count(*) from dept")
	public int totalCnt();
	
	public List<DeptsDto> selectAll();
	
	@Insert("insert into dept values (#{deptId}, #{deptTitle}, #{locationId})")
	public int saveDept(DeptsDto dept);
	
	@Insert("delete from dept where dept_id={deptId}")
	public int deleteDept(String deptId);
}
