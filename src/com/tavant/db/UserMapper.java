package com.tavant.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.tavant.domain.User;

public interface UserMapper {
	final String INSERT = "INSERT INTO USERS (FIRST_NAME,LAST_NAME,EMAIL_ID,PASSWORD) VALUES (#{firstName},#{lastName},#{emailId},#{password})";
	final String SELECT_BY_EMAIL_ID = "SELECT * FROM USERS WHERE EMAIL_ID = #{emailId}";

	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "user_id")
	void insert(User user);

	@Select(SELECT_BY_EMAIL_ID)
	@Results(value = { @Result(property = "userId", column = "USER_ID"),
			@Result(property = "firstName", column = "FIRST_NAME"),
			@Result(property = "lastName", column = "LAST_NAME"),
			@Result(property = "emailId", column = "EMAIL_ID"),
			@Result(property = "password", column = "PASSWORD") 
	})
	User selectByEmailId(String emailId);

}
