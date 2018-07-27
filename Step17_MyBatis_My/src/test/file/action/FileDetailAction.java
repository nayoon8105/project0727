package test.file.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 정보를 가져올 파일의 번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		// db에서 해당 번호의 글 정보를 가져온다.
		FileDto dto=FileDao.getInstance().getData(num);
		// request에 담는다.
		request.setAttribute("dto", dto);

		// /views/file/detail.jsp로 forward
		return new ActionForward("/views/file/detail.jsp");
		
		
	}

}
