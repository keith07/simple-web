package edu.keith.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.keith.mvc.entity.UserInfo;

public interface UserDao extends PagingAndSortingRepository<UserInfo,Integer>,JpaRepository<UserInfo, Integer> {

	@Query(value="select user from UserInfo user where user.userName = :userName" )
	public List<UserInfo> findByName(@Param("userName") String userName);
}
