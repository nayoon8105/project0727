package test.cafe.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dao.CafeLikeDislikeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class CafeListAction extends Action{
	// 한 페이지에 나타 낼 row의 갯수
	private static final int PAGE_ROW_COUNT=5;
	// 하단 디스플레이 페이지의 갯수
	private static final int PAGE_DISPLAY_COUNT=3;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 *	request 에 검색 keyword 가 전달 될수도 있고 안 될 수도 있다.
		 *	1. 전달 안 되는 경우 : home에서 목록보기를 누른 경우
		 *	2. 전달 되는 경우 : list.do 에서 검색어를 입력 후  form 전송한 경우
		 *	3. 전달 되는경우 : 이미 검색을 한 상태에서 페이지 링크를 누른 경우
		 */
		// 검색과 관련 된 파라미터를 읽어와 본다.
		String condition=request.getParameter("condition");
		String keyword=request.getParameter("keyword");
		// CafeDto 객체를 생성해서 검색 조건을 dto에 표시한다.
		CafeDto dto=new CafeDto();
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
		
		// 보여줄 페이지의 번호
		int pageNum=1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){ // 페이지 번호가 파라미터로 넘어온다면
			// 페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		// 전체 row의 갯수를 읽어온다
		int totalRow=CafeDao.getInstance().getCount(dto);
		// 전체 페이지의 갯수 구하기(총 row 갯수를 한 페이지에 나타낼 row 갯수를 나누어 올림)
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
				
		// 시작 페이지 번호
		int startPageNum=1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		// 1. FileDto 객체를 전달해서 파일 목록을 불러온다.
		List<CafeDto> list=CafeDao.getInstance().getList(dto);
		for(CafeDto tmp:list) {
			// 해당 글의 좋아요, 싫어요 수를 넣어준다.
			tmp.setTotalLike(CafeLikeDislikeDao.getInstance().totalLike(tmp.getNum()));
			tmp.setTotalDislike(CafeLikeDislikeDao.getInstance().totalDislike(tmp.getNum()));
		}
		
		// 2. request에 담고
		request.setAttribute("list", list);
		// 페이징 처리에 관련된 값도 request에 담기
		request.setAttribute("pageNum", pageNum); // 현재 페이지를 ui로 보여주기 위한 attribute
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
	
		// 전체 row의 갯수 전달하기
		request.setAttribute("totalRow", totalRow);
		
		// 좋아요 싫어요 값 불러오기
		
		
		// /views/file/list.jsp로 forward 이동
		return new ActionForward("/views/cafe/list.jsp");
	}

}
