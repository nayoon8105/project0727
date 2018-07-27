package test.file.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 삭제 할 파일 번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		
		// 파일 시스템에서 삭제하기 위해서는 저장 된 파일명을 알아야 한다.
		FileDto dto=FileDao.getInstance().getData(num);
		String saveFileName=dto.getSaveFileName();
		// 세션의 아이디와 삭제할 글의 작성자가 같은지 한번 더 확인
		String writer=dto.getWriter();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		if(!id.equals(writer)){
			// 금지 된 요청이라고 에러를 응답한다.
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN,"삭제 할 권리가 없습니다!");
			} catch(Exception e) {
				e.printStackTrace();
			}
		
			// 서비스 메소드 종료
			return null;
		}
		// 1. DB에서 파일 정보 삭제
		boolean isSuccess=FileDao.getInstance().delete(num);
		// 2. WebContent/upload 폴더에서 실제 파일 삭제 - 파일 삭제를 위해선 saveFileName을 알아야 함

		// 삭제 할 파일의 전체 경로 구성
		ServletContext application=request.getServletContext();
		String path=application.getRealPath("/upload")+File.separator+saveFileName;
		
		// File 객체를 생성해서 삭제
		new File(path).delete();

		// 리다이렉트 응답하기
		ActionForward af=new ActionForward("/views/file/private/delete.jsp");
		af.setRedirect(true);
		return af;
	}

}
