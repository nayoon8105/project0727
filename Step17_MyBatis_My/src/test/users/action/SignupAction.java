package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class SignupAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 폼으로 넘어오는 데이터 받아오기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		// DB에 저장
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		boolean isSuccess=UsersDao.getInstance().insert(dto);
		// 회원 가입 결과를 request에 담고
		request.setAttribute("isSuccess", isSuccess);
		return new ActionForward("/views/users/signup.jsp");
	}
}
