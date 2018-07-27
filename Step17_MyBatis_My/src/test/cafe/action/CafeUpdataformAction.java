package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdataformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터로 전달되는 수정 할 글 번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		CafeDto dto=new CafeDto();
		// 2. 수정할 글 정보 얻어오기
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		// 3. request에 담고
		request.setAttribute("dto", resultDto);
		// 4. 응답하기
		return new ActionForward("/views/cafe/private/update_form.jsp");
	}

}
