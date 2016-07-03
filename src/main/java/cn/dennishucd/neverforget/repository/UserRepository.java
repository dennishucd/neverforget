package cn.dennishucd.neverforget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.dennishucd.neverforget.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByLoginName(String name);
}
