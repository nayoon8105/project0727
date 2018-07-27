package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int replyNum=Integer.parseInt(request.getParameter("replyNum"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		// DB에서 해당 댓글 삭제
		CafeCommentDao.getInstance().delete(replyNum);
		// detail.jsp로 redirect 응답
		ActionForward af=new ActionForward("/cafe/detail.do?num="+pageNum);
		af.setRedirect(true);
		return af;
	}

}
