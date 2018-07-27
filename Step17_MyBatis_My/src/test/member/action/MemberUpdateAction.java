package test.member.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// post 방식으로 전송되는 폼의 파라미터 추출
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		System.out.println("name : "+name);
		String addr=request.getParameter("addr");
		// MemberDto 객체에 담아서
		MemberDto dto=new MemberDto(num,name,addr); 
		// DB에 반영
		boolean isSuccess=MemberDao.getInstance().update(dto);

		if(isSuccess) {
			request.setAttribute("msg", "수정하였습니다.");
		} else {
			request.setAttribute("msg", "실패하였습니다.");
		}
		request.setAttribute("url","/member/list.do");
		return new ActionForward("/views/member/alert.jsp");
	}

}
