package com.tavant.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.tavant.domain.Transaction;

public interface TransactionMapper {
	final String INSERT = "INSERT INTO TRANSACTIONS (DATE, DESCRIPTION, CONTACT_ID, AMOUNT, USER_ID) VALUES (#{date}, #{description},#{contactId},#{amount},#{userId})";
//	final String INSERT = "INSERT INTO `assistmedb`.`transactions` (DATE, DESCRIPTION, CONTACT_ID, AMOUNT, USER_ID) VALUES ('2011-12-30', 'shopping',36,230,3)";

	@Insert(INSERT)
	@Options(useGeneratedKeys=true, keyProperty="transaction_id")
	void insert(Transaction transaction);
	
}
	
