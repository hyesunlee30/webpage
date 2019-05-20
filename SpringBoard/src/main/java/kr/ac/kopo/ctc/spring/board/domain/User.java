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
public class User {
	
	//유일성과 복합성을 위한 키 = primary key
	@Id
	//GeneratedValue data가 중복되지않게 관리해주는 것! 
	@GeneratedValue
	@Column
	private Integer Id;
	
	@Column
	private String name;
	
	//이게 있으면 member를 지우면 폰도 지워짐 ALL(전파되는 부분) 디테일하게 조절가능
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Collection<Gongji1> gongji;
	
	
	public User() {
		
	}
	public User(String name) {

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

	
	public Collection<Gongji1> getGongjis() {
		
		if( gongji == null ) {
			gongji = new ArrayList<Gongji1>();
		}
		return gongji;
	}

	public void setGongjis(Collection<Gongji1> gongji) {
		this.gongji = gongji;
	}
	
	public void addGongjis(Gongji1 b) {
		Collection<Gongji1> gongji = getGongjis();
		b.setUser(this);
		gongji.add(b);
	}
	

	@Override
	public String toString() {
		String result = "["+Id+"]" + name;
		for ( Gongji1 b : getGongjis()) {
			result += "\n" + b.toString();
		}
		return result;
		
	}


}




