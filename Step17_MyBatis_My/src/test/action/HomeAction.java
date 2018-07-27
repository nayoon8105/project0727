package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 * 	/home.do 요청을 처리할 액션
 */
public class HomeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항을 Dao를 이용해서 읽어온다.
		List<String> msgs=new ArrayList();
		msgs.add("졸려요");
		msgs.add("너무 졸리네 오늘");
		msgs.add("그럴만두 하지");
		msgs.add("내가 무쇠도 아니고");
		msgs.add("오늘은 일찍 자야겠다!!");
		
		// 모델을 request에 담는다
		request.setAttribute("msgs", msgs);
		
		// view 페이지로 forward 이동
		return new ActionForward("/views/home.jsp");
	}

}
