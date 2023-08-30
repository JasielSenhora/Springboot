package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.model.UserModel;

import jakarta.transaction.Transactional;

public interface UserRepo  extends JpaRepository<UserModel, Long>{
	@Query(value="SELECT * FROM UserDetails where uid=:2 or username=:sraya",nativeQuery=true)
	 public List<UserModel> getAllRows(@Param("2") int uid,@Param("sraya") String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from UserDetails where id=:2",nativeQuery=true)
	public int deleteUserInfo(@Param("2") int uid);
	
	@Modifying
	@Transactional
	@Query(value="update UserDetails set uid=?3 where uid=?4",nativeQuery = true)
	public int updateUserInfo(int newid,int oldid);
}
