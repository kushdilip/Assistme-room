package com.tavant.db.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tavant.domain.Transaction;

public class TransactionDAOTest {
	private static TransactionDAO traDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		traDAO = new TransactionDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		traDAO = null;
	}

	@Test
	public void testInsert() {
		Transaction transaction = new Transaction("2010-12-12", "shopping", 36, 1200, 3);
		System.out.println(transaction);
		traDAO.insert(transaction);
	}

}
