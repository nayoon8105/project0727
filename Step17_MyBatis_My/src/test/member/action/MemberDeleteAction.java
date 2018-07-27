package test.member.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;

public class MemberDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// get 방식 파라미터로 전달되는 회원번호 추출
		int num=Integer.parseInt(request.getParameter("num"));
		// DB 에서 해당 회원 삭제
		MemberDao.getInstance().delete(num);
		
		// 삭제 후 redirect 시키려면?
		ActionForward af=new ActionForward("/member/list.do");
		af.setRedirect(true);
		
		return af;
	}

}
