package com.tavant.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Update;

import com.tavant.domain.Contact;

public interface ContactMapper {
	final String DELETE = "DELETE FROM CONTACTS WHERE CONTACTS_PK = #{id}";
	final String INSERT = "INSERT INTO CONTACTS (NAME, MOBILE, EMAIL_ID,USER_ID) VALUES (#{name}, #{phoneNumber}, #{emailId},#{userId})";
	final String SELECT_ALL = "SELECT * FROM CONTACTS WHERE USER_ID = #{userId}";
	final String SELECT_BY_ID = "SELECT * FROM CONTACTS WHERE CONTACTS_PK = #{id}";
	final String UPDATE = "UPDATE CONTACTS SET EMAIL_ID = #{emailId}, NAME = #{name}, MOBILE = #{phoneNumber} WHERE CONTACTS_PK = #{id}";
	
	@Insert(INSERT)
	@Options(useGeneratedKeys=true, keyProperty="contacts_pk")
	void insert(Contact contact);
	
	@Delete(DELETE)
	void delete(int id);
	

	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="CONTACTS_PK"),
		@Result(property="name", column="NAME"),
		@Result(property="phoneNumber", column="MOBILE"),
		@Result(property="emailId", column="EMAIL_ID")
	})
	List<Contact> selectAll(int userId);
	
	
	@Select(SELECT_BY_ID)
	@Results(value = {
		@Result(property="id", column="CONTACTS_PK" ),
		@Result(property="name", column="NAME"),
		@Result(property="phoneNumber", column="MOBILE"),
		@Result(property="emailId", column="EMAIL_ID")
	})
	Contact selectById(int id);
	
	@Update(UPDATE)
	void update(Contact contact);
	
	
	
	
}
