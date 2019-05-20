package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Member {
	
	//Id primary key 를 가지는 변수에 선언합니다.
	@Id
	@GeneratedValue
	@Column
	private Integer Id;
	@Column
	private String name;
	@Column
	private int age;
	//이게 있으면 member를 지우면 폰도 지워짐 ALL(전파되는 부분) 디테일하게 조절가능
	//회원 하나에 핸드폰을 여러개 가지니 1:N 관계
	//이것을 JPA 어노테이션으로는 @OneToMany라고 표현합니다.
	@OneToMany(cascade=CascadeType.ALL, mappedBy="member")
	private Collection<Phone> phones;

	//기본생성자는 꼭 필요하다. 
	public Member(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Collection<Phone> getPhones() {
		
		if( phones == null ) {
			phones = new ArrayList<Phone>();
		}
		return phones;
	}
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	public void addPhone(Phone p) {
		Collection<Phone> phones = getPhones();
		p.setMember(this);
		phones.add(p);
	}
	//toString 메소드를 재정의 해서 문자열 반환
	//맴버에게 Phone을 입력해준다.
	@Override
	public String toString() {
		String result = "["+Id+"]" + name;
		for ( Phone p : getPhones()) {
			result += "\n" + p.toString();
		}
		return result;
	}
}
