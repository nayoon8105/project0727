package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 폼 전송 파라미터 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		String content=request.getParameter("content");
		
		// 댓글을 DB에 수정 반영
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(num);
		dto.setRef_group(ref_group);
		dto.setContent(content);
		
		CafeCommentDao.getInstance().update(dto);

		//  원글의 detail 페이지로 리아디렉트 이동 응답
		ActionForward af=new ActionForward("/cafe/detail.do?num="+ref_group);
		af.setRedirect(true);
		return af;
	}

}
