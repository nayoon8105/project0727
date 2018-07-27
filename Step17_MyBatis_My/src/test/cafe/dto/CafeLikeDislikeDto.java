package test.cafe.dto;

public class CafeLikeDislikeDto {
	private int num; // 글 번호
	private String id; // 유저의 아이디
	private int isLike; // like는 1, dislike는 2
	private int totalLike; // 총 좋아요 수
	private int totalDislike; // 총 싫어요 수
		
	public CafeLikeDislikeDto() {}

	public CafeLikeDislikeDto(int num, String id, int isLike, int totalLike, int totalDislike) {
		super();
		this.num = num;
		this.id = id;
		this.isLike = isLike;
		this.totalLike = totalLike;
		this.totalDislike = totalDislike;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getIsLike() {
		return isLike;
	}


	public void setIsLike(int isLike) {
		this.isLike = isLike;
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
