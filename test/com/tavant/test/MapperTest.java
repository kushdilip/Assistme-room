package com.tavant.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tavant.db.impl.AnniversaryDAO;
import com.tavant.db.impl.UserDAO;
import com.tavant.domain.Anniversary;
import com.tavant.domain.User;

public class MapperTest {
	private static UserDAO userDAO;
	private static AnniversaryDAO anniversaryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO();
		anniversaryDAO = new AnniversaryDAO();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO = null;
		anniversaryDAO = null;
	}

	// @Test
	public void testAdd() {
		User user = new User();
		user.setEmailId("abc@gmail.com");
		user.setFirstName("firstname");
		user.setLastName("lastName");
		user.setPassword("password");
		userDAO.insert(user);
	}

//	@Test
	public void testLogin() {
		String emailId = "kush.dilip@gmail.com";
		User user = userDAO.selectByEmailId(emailId);
		System.out.println(user);
	}

//	@Test
	public void testAnniversary() {
		Anniversary anniversary = new Anniversary();
		anniversary.setDate("2011-04-05");
		anniversary.setTitle("birthday");
		anniversary.setPeople("dilip");
		anniversary.setRepeatCycle("y");
		anniversaryDAO.insert(anniversary);
	}

	@Test
	public void deleteAnniversary() {
//		anniversaryDAO.delete(2, 2);
		Anniversary anniversary = new Anniversary();
		anniversary.setAnniversaryId(5);
		anniversary.setUserId(1);
		System.out.println(anniversaryDAO.selectById(anniversary));

	}
}
