package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

/*
 * 	회원 추가 폼을 출력해주는 액션
 */
public class MemberInsertformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 수행 할 비지니스 로직은 없음...
		ActionForward af=new ActionForward("/views/member/insertform.jsp");
		return af;
	}

}
