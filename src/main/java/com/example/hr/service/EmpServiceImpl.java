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

	@Override
	public EmpDto selectById(String empId) {
		return mapper.selectById(empId); // 화면에서 전달받은 empId
	}

	@Override
	public EmpDto login(String id, String pw) throws Exception {
		// 1. 사용자 조회
		EmpDto emp = mapper.selectByUserId(id);
		
		// 2. 아이디가 없는 경우 -> 메세지 처리(예외를 발생시킴 -> 예외메세지를 전달)
		if(emp == null) {
			throw new Exception("존재하지 않는 아이디입니다.");
		}
		
		System.out.println("lock : " + emp.getIsLocked());
		// 3. 잠긴 계정인지 확인 -> 잠겼으면 메세지 처리
		if(emp.getIsLocked() == 1) {
			throw new Exception("잠긴 계정입니다. 관리자에게 문의해주세요.");
		}
		// 4. 비밀번호 일치 확인 -> 일치하지 않으면 실패 카운팅 후 메세지 처리
		// -> 예외가 발생되면 >>롤백<<이 되어버림
		// -> 컨트롤러에서 로그인 실패 시 메서드를 다시 호출하도록 바꾸기 
		if(!emp.getPw().equals(pw)) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}
		
		// 5. 로그인 성공 -> empDto 반환
		// 실패 카운트 초기화
		mapper.resetFailCnt(id);
		
		return emp;
	}
	
	public String failCntUpdate(String id) {
		/*
		if(!emp.getPw().equals(pw)) {
			// 실패 카운트
			mapper.updateFailCnt(id);
			
			// 5회 초과시 계정 잠금
			if(emp.getLoginFailCount()+1 > 5) {
				mapper.lockUserAccount(id);
				throw new Exception("5회 실패로 계정이 잠겼습니다.");
			}

			throw new Exception("비밀번호가 일치하지 않습니다.");
			
		} */
		return "";
	}

	@Override
	public int updateFailCnt(String id) {
		
		return mapper.updateFailCnt(id);
	}
	
}
