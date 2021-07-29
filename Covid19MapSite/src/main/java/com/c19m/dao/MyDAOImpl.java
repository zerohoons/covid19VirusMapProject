package com.c19m.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MyDAOImpl implements MyDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
}
