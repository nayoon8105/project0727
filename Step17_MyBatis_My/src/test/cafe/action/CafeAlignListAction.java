package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class CafeAlignListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 몇 번 정렬인지 받아온다.
		int idx=Integer.parseInt(request.getParameter("idx"));
		// idx 0:최근 순 1:오래된 순 2:조회 순 3:좋아요 순
		return null;
		
	}

}
