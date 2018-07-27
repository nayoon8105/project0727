package test.filter;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *	중간에 요청을 가로 채서 특정 동작을 하기 위한 클래스
 *	1. javax.servlet.Filter 인터 페이스를 구현한다.
 * 	2. Filter 의 동작을 맵핑한다.
 */

// 이 필터가 필요한 시점에 객체를 생성 돼, doFilter 메소드를 호출되어 동작한다.
// 2. market 하위의 모든 요청에 대해 이 필터를 거치게 한다.
// 필터 자체가 프로젝트 안에서 작동하는 것이므로 context path는 빼고 절대 경로를 작성한다.
@WebFilter({"/users/private/*","/file/private/*","/gallery/private/*","/ajax_practice/*","/cafe/private/*"})
// /users/private 하위의 작업들은 로그인을 해야하지만 할 수 있으므로 로그인 확인을 필터링 해준다.
public class LoginFilter implements Filter{ // 1.
	@Override
	public void destroy() {
		
	}

	@Override	// HttpServletResquest 객체의 부모타입. 원래도 HttpServletResquest 타입으로 매개변수가 전달되나 부모타입으로 받는 것.
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 이 필터에 걸리면 실행 순서가 doFilter 메소드 안으로 들어 옴.
		System.out.println("... doFilter() ...");
		// 원래 type 으로 casting
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res; // 클라이언트에게 직접 응답할 수도 있음.
		// context path
		String cPath=request.getContextPath();
		// 현재 요청 된 url 정보 읽어오기(클라이언트가 원래 이동하려던 목적지)
		String url=request.getRequestURI();
		// 세션 객체를 얻어와서
		HttpSession session=request.getSession();
		// id가 저장되어 있는지 읽어와본다.
		String id=(String) session.getAttribute("id");
		if(id==null) { // 로그인 안 했으면
			// 로그인 페이지로 이동하라고 리 다이렉트 응답을 준다.
			// 로그인 성공 시 원래 클라이언트가 요청했던 경로로 곧바로 이동하게 하기 위해 url 정보를 담아 리 다이렉트 한다.
			response.sendRedirect(cPath+"/users/login_form.jsp?url="+url);
		} else { // 로그인 했으면
			// 요청의 흐름 계속 진행시키기
			chain.doFilter(req, res);	
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
