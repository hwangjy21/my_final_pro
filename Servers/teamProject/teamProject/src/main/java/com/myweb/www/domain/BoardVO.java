package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor //부서, 동호회 게시판
public class BoardVO {
	private long bno;//글번호
	private String emp_no;//사번
	private String emp_nm;//작성자
	private String title;//제목
	private String contnet;//내용
	private String regDate;//등록일
	private String modDate;//수정일
	private String type;//게시판 종류(익명,보드,동호회)
	private String clubCd;//동호회 코드
	private String depCd;//부서코드
	private int commentCnt;//댓글개수
	private int readCnt;//조회수
	
	//익명게시판용 생성자
	public BoardVO(long bno, String title, String contnet, String regDate, String modDate,
			String type,int commentCnt, int readCnt) {
		this.bno = bno;
		this.title = title;
		this.contnet = contnet;
		this.regDate = regDate;
		this.modDate = modDate;
		this.type = "anonymous";
		this.commentCnt = commentCnt;
		this.readCnt = readCnt;
	}

	//전체공지게시판용 생성자
	public BoardVO(long bno, String emp_no, String emp_nm, String title, String contnet, String regDate, String modDate,
			String type) {
		this.bno = bno;
		this.emp_no = emp_no;
		this.emp_nm = emp_nm;
		this.title = title;
		this.contnet = contnet;
		this.regDate = regDate;
		this.modDate = modDate;
		this.type = type;
	}
	

	

	
	
	


	
	
}


