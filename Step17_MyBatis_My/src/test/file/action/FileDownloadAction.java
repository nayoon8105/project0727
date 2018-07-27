package test.file.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileDownloadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 다운로드 시켜줄 파일의 번호를 읽어와서
	    int num=Integer.parseInt(request.getParameter("num"));
	    // DB에서 해당 파일의 정보를 얻어온 다음
	    FileDto dto=FileDao.getInstance().getData(num);
	    // 파일 정보와 실제 파일을 응답해서 클라이언트가 파일을 다운받을 수 있도록 한다.
	    request.setAttribute("dto", dto);
	   return new ActionForward("/views/file/download.jsp");
	}

}
