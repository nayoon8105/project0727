package test.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

// 요청 종류별로 Action 클래스를 상속받은 Action 타입의 클래스를 추가 함. jsp 위에서 하던 작업을 한다.

// 회원 목록 보기 요청을 처리할 액션 클래스
public class MemberListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 회원 목록을 얻어온다.
		List<MemberDto> list=MemberDao.getInstance().getList();
		// 2. model을 request에 담는다.
		request.setAttribute("list", list);
		// 3. view 페이지로 forward 이동 되도록 ActionForward 객체 생성
		ActionForward af=new ActionForward("/views/member/list.jsp");
		// ActionForward 객체 리턴해주기
		return af;
	}
	
}
