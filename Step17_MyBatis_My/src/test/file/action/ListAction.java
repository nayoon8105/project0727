package test.file.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class ListAction extends Action{
	// 한 페이지에 나타 낼 row의 갯수
	private static final int PAGE_ROW_COUNT=5;
	// 하단 디스플레이 페이지의 갯수
	private static final int PAGE_DISPLAY_COUNT=3;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 페이징 처리를 위해선 DB의 총 row 갯수를 알아야 한다!
		
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
		int totalRow=FileDao.getInstance().getCount();
		// 전체 페이지의 갯수 구하기(총 row 갯수를 한 페이지에 나타낼 row 갯수를 나누어 올림)
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
				
		// 시작 페이지 번호
		int startPageNum=1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		
		FileDto dto=new FileDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		// 1. FileDto 객체를 전달해서 파일 목록을 불러온다.
		List<FileDto> list=FileDao.getInstance().getList(dto);
		// 2. request에 담고
		request.setAttribute("list", list);
		// 페이징 처리에 관련된 값도 request에 담기
		request.setAttribute("pageNum", pageNum); // 현재 페이지를 ui로 보여주기 위한 attribute
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		System.out.println("totalRow : " + totalRow);
		System.out.println("totalPageCount : " + totalPageCount);
		// /views/file/list.jsp로 forward 이동
		return new ActionForward("/views/file/list.jsp");
	}	
}
