package test.controller;

import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	
	//인자로 전달되는 command 를 수행할 Action type 객체를 리턴해주는 
	//메소드
	public Action action(String command){
		//Action 추상클래스 type 을 담을 지역변수 만들기 
		Action action=null;
		if(command.equals("/member/list")) {
			//회원 목록 요청 처리 
			action=new MemberListAction();
		}else if(command.equals("/member/insertform")) {
			//회원 추가 폼 요청 처리 
			action=new MemberInsertformAction();
		}else if(command.equals("/member/insert")) {
			//회원 추가 요청 처리 
			action=new MemberInsertAction();
		}
		
		return action;
	}
}







