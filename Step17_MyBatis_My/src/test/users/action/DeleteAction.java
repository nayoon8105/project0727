package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class DeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 세션에서 아이디를 읽어와서
		String id=(String) request.getSession().getAttribute("id");
		// 2. DB에서 삭제하고
		UsersDao.getInstance().delete(id);
		// 3. 로그아웃 처리도 하고
		request.getSession().invalidate();
		// 4. 탈퇴 처리 된 회원의 id를 request에 담기
		request.setAttribute("id", id);
		// 5. view 페이지로 forward 이동해서 응답한다.
		return new ActionForward("/views/users/private/delete.jsp");
	}

}
