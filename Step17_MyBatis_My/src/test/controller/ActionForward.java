package test.controller;

/*
 * 	비즈니스 로직을 처리한 후 이동 할 경로 정보와
 *  리다이렉트 이동할 지에 대한 여부를 저장 할 객체
 */
public class ActionForward {
	// 이동 경로 
	private String path;
	// 리다이렉트 이동 여부 
	private boolean isRedirect;
	// 생성자
	public ActionForward(String path) {
		this.path = path;
	}
	// 생성자2
	public ActionForward(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
