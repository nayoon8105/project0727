package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 * 	개인 정보를 출력해주는 액션
 */
public class InfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디에 해당하는 개인 정보를 가져옴
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		UsersDto dto=UsersDao.getInstance().getData(id);
		// request에 담는다
		request.setAttribute("dto", dto);
		// info.jsp로 forward
		return new ActionForward("/views/users/private/info.jsp");
	}

}
