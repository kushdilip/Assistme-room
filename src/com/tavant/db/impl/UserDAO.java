package com.tavant.db.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.tavant.db.MyBatisConnectionFactory;
import com.tavant.db.UserMapper;
import com.tavant.domain.User;

@Service("userMapper")
public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;

	public UserDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void insert(User user) {
		SqlSession session = sqlSessionFactory.openSession();

		try {

			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insert(user);

			session.commit();
		} finally {
			session.close();
		}
	}

	public User selectByEmailId(String emailId) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectByEmailId(emailId);

			return user;
		} finally {
			session.close();
		}

	}
}
