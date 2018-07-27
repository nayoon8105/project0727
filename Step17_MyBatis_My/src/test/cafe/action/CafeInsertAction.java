package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 작성자
		String writer=request.getParameter("writer");
		// 글 제목
		String title=request.getParameter("title");
		// 컨텐츠
		String content=request.getParameter("content");
		// CafeDto에 담기
		CafeDto dto=new CafeDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		// Db에 저장
		boolean isSuccess=CafeDao.getInstance().insert(dto);
		// request 에 성공여부 담기
		request.setAttribute("isSuccess", isSuccess);
		
		return new ActionForward("/views/cafe/private/insert.jsp");
	}

}
