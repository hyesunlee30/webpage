package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.User;

//controller, service, repository - component 상속받게 되어 있다. 해당 어플리케이션에서 딱 하나만 생기는 싱글톤!! 
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	//List<Sample> findAllByTitleLike(String title);
	//List<Sample> findAllByLevelGreaterThan(int level);
	//List<Sample> findAllByTitleLikeAndLevelGreaterThan(String string, int Level); 
}

