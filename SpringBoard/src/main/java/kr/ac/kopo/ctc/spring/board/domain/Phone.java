package kr.ac.kopo.ctc.spring.board.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//객체생성
@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String no;
	
	//이게 있으면 member를 지우면 폰도 지워짐 ALL(전파되는 부분) 디테일하게 조절가능
	//이것을 JPA 어노테이션으로는 @OneToMany라고 표현합니다.
	@ManyToOne(optional=false)
	@JoinColumn(name="member_id")
	private Member member;

	public Phone(String no) {
		this.no = no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		String result = "[phone_"+id+"]"+no;
		return result;
	}
}

