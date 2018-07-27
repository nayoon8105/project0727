package test.cafe.dto;

public class CafeDto {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int viewCount;
	private String regdate;
	// 페이징 처리
	private int startRowNum;
	private int endRowNum;
	// 이전 글 다음 글
	private int prevNum;
	private int nextNum;
	private String prevName;
	private String nextName;
	// 좋아요, 싫어요 수
	private int totalLike;
	private int totalDislike;
	
	public CafeDto() {}

	public CafeDto(int num, String writer, String title, String content, int viewCount, String regdate, int startRowNum,
			int endRowNum, int prevNum, int nextNum, String prevName, String nextName, int totalLike,
			int totalDislike) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
		this.prevName = prevName;
		this.nextName = nextName;
		this.totalLike = totalLike;
		this.totalDislike = totalDislike;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public String getPrevName() {
		return prevName;
	}

	public void setPrevName(String prevName) {
		this.prevName = prevName;
	}

	public String getNextName() {
		return nextName;
	}

	public void setNextName(String nextName) {
		this.nextName = nextName;
	}

	public int getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(int totalLike) {
		this.totalLike = totalLike;
	}

	public int getTotalDislike() {
		return totalDislike;
	}

	public void setTotalDislike(int totalDislike) {
		this.totalDislike = totalDislike;
	}
}
