package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class LoginformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 후 이동할 url 정보를 읽어온다.
		String url=request.getParameter("url");
		// url이 null이면 index 페이지로 이동
		if(url==null) {
			url=request.getContextPath();
		}
		request.setAttribute("url", url);
		// view 페이지로 forward 이동
		return new ActionForward("/views/users/login_form.jsp");
	}

}
