package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 폼으로 넘어오는 데이터 읽기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		// DB 회원정보 업데이트
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		boolean isSuccess=UsersDao.getInstance().update(dto);
		
		request.setAttribute("isSuccess", isSuccess);
		
		// alert로 forward
		return new ActionForward("/views/users/private/update.jsp");
	}

}
