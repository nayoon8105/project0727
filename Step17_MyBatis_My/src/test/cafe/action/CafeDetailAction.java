package test.cafe.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dao.CafeDao;
import test.cafe.dao.CafeLikeDislikeDao;
import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.cafe.dto.CafeLikeDislikeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터로 전달되는 글 번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		
		// 검색과 관련 된 파라미터를 읽어와 본다.
		String condition=request.getParameter("condition");
		String keyword=request.getParameter("keyword");
		// CafeDto 객체를 생성해서 검색 조건을 dto에 표시한다.
		CafeDto dto=new CafeDto();
		
		dto.setNum(num);
		
		if(keyword!=null) { // 검색어가 전달 된 경우
			if(condition.equals("titleContent")) { // 제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			} else if(condition.equals("title")) { // 제목 검색
				dto.setTitle(keyword);
			} else if(condition.equals("writer")) { // 작성자 검색
				dto.setWriter(keyword);
			}
		}
		// list.jsp 에서 필요한 내용 담기
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		// 2. cafeDao를 이용해서 글 정보를 읽어와서
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		
		// viewCount 증가
		CafeDao.getInstance().addViewCount(num);
		
		// 3. request에 담고
		request.setAttribute("dto", resultDto);
		
		// 해당 글의 댓글 목록 request에 담기
		List<CafeCommentDto> commentList=CafeCommentDao.getInstance().getList(num);
		request.setAttribute("commentList", commentList);
		
		// 로그인 여부 확인해서 request에 담기
		boolean isLogin=false;
		String id=(String)request.getSession().getAttribute("id");
		if(id!=null) { 
			isLogin=true;
		}
		request.setAttribute("isLogin", isLogin);
		
		// 총 좋아요 수 싫어요 수 request에 담기
		int totalLike=CafeLikeDislikeDao.getInstance().totalLike(num);
		int totalDislike=CafeLikeDislikeDao.getInstance().totalDislike(num);
		request.setAttribute("totalLike", totalLike);
		request.setAttribute("totalDislike", totalDislike);
		int isClicked=0;
		if(id!=null) {
			// 사용자가 좋아요나 싫어요를 누른 적이 있는지를 request에 담기
			CafeLikeDislikeDto likeInfoDto=new CafeLikeDislikeDto();
			likeInfoDto.setNum(num);
			likeInfoDto.setId(id);
			isClicked=CafeLikeDislikeDao.getInstance().isClicked(likeInfoDto);
		} 
		request.setAttribute("isClicked", isClicked);
		System.out.println("isClicked 넘어갈 때 : " + isClicked);
		// 4. view 페이지로 forward 이동해서 응답하기
		return new ActionForward("/views/cafe/detail.jsp");
	}

}
