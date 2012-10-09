package com.tavant.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tavant.domain.Anniversary;

public interface AnniversaryMapper {
	final String INSERT = "INSERT INTO ANNIVERSARIES (TITLE,DATE,PEOPLE,REPEAT_CYCLE,USER_ID) VALUES(#{title},#{date},#{people},#{repeatCycle},#{userId})";
	final String SELECT_ALL_BY_USER_ID = "SELECT * FROM ANNIVERSARIES WHERE USER_ID=#{userId}";
	final String DELETE = "DELETE FROM ANNIVERSARIES WHERE ANNIVERSARY_ID = #{anniversaryId} AND USER_ID=#{userId}";
	final String UPDATE = "UPDATE ANNIVERSARY SET DATE=#{date}, PEOPLE=#{people}, REPEAT_CYCLE=#{repeatCycle}, TITLE=#{title},USER_ID={userId} WHERE ANNIVERSARY_ID = #{anniversaryId} AND USER_ID=#{user_id}";
	final String SELECT_BY_ANNIVERSARY_ID = "SELECT * FROM ANNIVERSARIES WHERE USER_ID = #{userId} AND ANNIVERSARY_ID = #{anniversaryId}";
//	final String TEMP_SELECT = "SELECT * FROM ANNIVERSARIES WHERE USER_ID = #{userId} AND ANNIVERSARY_ID = #{anniversaryId}";
	
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "anniversary_id")
	void insert(Anniversary anniversary);

	@Select(SELECT_ALL_BY_USER_ID)
	@Results(value = {
			@Result(property = "anniversaryId", column = "ANNIVERSARY_ID"),
			@Result(property = "date", column = "DATE"),
			@Result(property = "people", column = "PEOPLE"),
			@Result(property = "repeatCycle", column = "REPEAT_CYCLE"),
			@Result(property = "title", column = "TITLE"),
			@Result(property = "userId", column = "USER_ID")

	})
	List<Anniversary> selectAllByUserId(int userId);

	@Delete(DELETE)
	void delete(Anniversary anniversary);

	@Update(UPDATE)
	void update(Anniversary anniversary);

	@Select(SELECT_BY_ANNIVERSARY_ID)
	@Results(value = {
			@Result(property = "anniversaryId", column = "ANNIVERSARY_ID"),
			@Result(property = "date", column = "DATE"),
			@Result(property = "people", column = "PEOPLE"),
			@Result(property = "repeatCycle", column = "REPEAT_CYCLE"),
			@Result(property = "title", column = "TITLE"),
			@Result(property = "userId", column = "USER_ID")

	})
	Anniversary selectById(Anniversary anniversary);

	
}
