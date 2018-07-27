CREATE TABLE board_cafe(
num NUMBER PRIMARY KEY,
writer VARCHAR2(100) NOT NULL,
title VARCHAR2(100) NOT NULL,
content CLOB,
viewCount NUMBER,
totalLike NUMBER,
totalDislike NUMBER,
regdate DATE,
);

CREATE SEQUENCE board_cafe_seq;

SELECT *
FROM board_cafe;

SELECT result1.*
FROM (SELECT num, writer, title,
		LAG(num, 1, 0) OVER(ORDER BY num DESC) prevNum,
		LEAD(num,1 ,0) OVER(ORDER BY num DESC) nextNum
		FROM board_cafe
		ORDER BY num DESC) result1
WHERE num=2;

-- 댓글 정보를 저장 할 테이블
CREATE TABLE board_cafe_comment(
	num NUMBER PRIMARY KEY, -- 댓글의 글 번호
	writer VARCHAR2(100), -- 댓글 작성자
	content VARCHAR2(500), -- 댓글 내용
	target_id VARCHAR2(100), -- 댓글의 대상이 되는 아이디(글 작성자)
	ref_group NUMBER, -- 댓글의 그룹 번호. 원글의 글 번호
	comment_group NUMBER, -- 원글에 달린 댓글 내에서의 그룹 번호. 댓글과 대댓글의 그룹 번호는 같고 그룹 번호는 댓글의 글 번호.
	regdate DATE -- 댓글 등록일
)

-- 글 좋아요 정보를 저장 할 테이블
CREATE TABLE board_cafe_likeDislike(
	num NUMBER, -- 글의 글 번호
	id VARCHAR2(100), -- 사용자의 아이디
	isLike NUMBER -- 좋아요 싫어요 유무. 좋아요는 1, 싫어요는 2 
)