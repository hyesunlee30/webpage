package kr.ac.kopo.ctc.spring.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gongji1 {

	@Id
	@GeneratedValue
	@Column
	private Integer id; //게시글 번호

	@Column
	private String author; // 게시글 작성자

	@Column
	private String title; // 게시글 제목 

	@Column
	private String date; // 게시 날짜 
	
	@Column
	private String content; // 게시글 본문
	
	private int startIndex;
	
	private int pageSize;

	public Gongji1() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	public void setStartIndex(int startIndex) {
		// TODO Auto-generated method stub
		
		this.startIndex =startIndex;
	}

	public void setCntPerPage(int pageSize) {
		// TODO Auto-generated method stub
		
		this.pageSize =pageSize;
	}



}
