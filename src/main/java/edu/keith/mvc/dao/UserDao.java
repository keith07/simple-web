package edu.keith.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.keith.mvc.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, Integer> {

}
