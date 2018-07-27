package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 수정 할 글 정보 얻어오기
		int num=Integer.parseInt(request.getParameter("num"));
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		boolean isSuccess=CafeDao.getInstance().update(dto);
		
		request.setAttribute("isSuccess", isSuccess);
		return new ActionForward("/views/cafe/private/update.jsp");
	}

}
