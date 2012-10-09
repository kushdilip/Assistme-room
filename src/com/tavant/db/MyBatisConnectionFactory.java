package com.tavant.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader);
				sqlSessionFactory.getConfiguration().addMapper(
						ContactMapper.class);
				sqlSessionFactory.getConfiguration()
						.addMapper(UserMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(
						AnniversaryMapper.class);
				sqlSessionFactory.getConfiguration().addMapper(
						TransactionMapper.class);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {

		return sqlSessionFactory;
	}
}
