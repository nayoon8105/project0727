package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 폼으로 전송되는 아이디, 비밀번호 읽어오기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		// 파라미터로 전송 된 url 읽어오기
		String url=request.getParameter("url");
		// DB 정보와 일치하는지 확인해서
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		// 로그인 성공 여부
		boolean isLoginSuccess=UsersDao.getInstance().isValid(dto);
		
		if(isLoginSuccess) {
			// 세션 객체를 이용해서 로그인 처리하기
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
		} 
		
		// model을 request에 담기
		request.setAttribute("isLoginSuccess", isLoginSuccess);
		request.setAttribute("url", url);
		
		// views/users/alert.jsp 로 forward
		return new ActionForward("/views/users/login.jsp");
	} 

}
