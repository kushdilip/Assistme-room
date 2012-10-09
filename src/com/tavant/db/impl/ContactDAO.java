package com.tavant.db.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.tavant.db.ContactMapper;
import com.tavant.db.MyBatisConnectionFactory;
import com.tavant.domain.Contact;

@Service("contactMapper")
public class ContactDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ContactDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void insert(Contact contact) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.insert(contact);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void delete(int id) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.delete(id);

			session.commit();
		} finally {
			session.close();
		}
	}
	
public List<Contact> selectAll(int userId){
		
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			List<Contact> list = mapper.selectAll(userId);
			
			return list;
		} finally {
			session.close();
		}
	}

	public Contact selectById(int id) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			ContactMapper mapper = session.getMapper(ContactMapper.class);
			Contact contact = mapper.selectById(id);

			return contact;
		} finally {
			session.close();
		}
	}

	public void update(Contact contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.update(contact);

			session.commit();
		} finally {
			session.close();
		}
	}


}
