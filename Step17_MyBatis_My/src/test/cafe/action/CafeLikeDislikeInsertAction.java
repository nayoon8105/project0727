package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeLikeDislikeDao;
import test.cafe.dto.CafeLikeDislikeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeLikeDislikeInsertAction extends Action{
	final int like=1;
	final int disLike=2;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		int num=Integer.parseInt(request.getParameter("num"));
		int isLike=Integer.parseInt(request.getParameter("isLike"));
		
		CafeLikeDislikeDto dto=new CafeLikeDislikeDto();
		dto.setNum(num);
		dto.setId(id);
		dto.setIsLike(isLike);
		
		// 좋아요나 싫어요를 취소한 건지 확인
		int isCliked=CafeLikeDislikeDao.getInstance().isClicked(dto);
		if(isCliked!=0) { // 취소하는 경우
			CafeLikeDislikeDao.getInstance().cancel(dto);
		} else { 
			// DB에 해당 글에 좋아요 싫어요 반영		
			CafeLikeDislikeDao.getInstance().Insert(dto);
		}
	
		// 원글의 detail 페이지로 리아디렉트 이동 응답
		ActionForward af=new ActionForward("/cafe/detail.do?num="+num);
		af.setRedirect(true);
		return af;
	}

}
