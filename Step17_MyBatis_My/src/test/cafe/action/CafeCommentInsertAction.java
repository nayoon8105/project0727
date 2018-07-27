package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dto.CafeCommentDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeCommentInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 폼 전송 파라미터 읽어오기
		String writer=request.getParameter("writer");
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		String target_id=request.getParameter("target_id");
		String content=request.getParameter("content");
		// comment_group 값이 파라미터 값으로 넘어오지 않으면(null 이면) 원글에 단 댓글이다.
		String comment_group=request.getParameter("comment_group");
		// 저장 할 댓글의 번호를 미리 얻어낸다.
		int num=CafeCommentDao.getInstance().getSequence();
		// 댓글을 DB에 저장
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setRef_group(ref_group);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		if(comment_group==null) { // 원글의 댓글인 경우
			dto.setComment_group(num);
		} else {
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		CafeCommentDao.getInstance().insert(dto);

		// 댓글을 단 원글의 detail 페이지로 리아디렉트 이동 응답
		ActionForward af=new ActionForward("/cafe/detail.do?num="+ref_group);
		af.setRedirect(true);
		return af;
	}

}
