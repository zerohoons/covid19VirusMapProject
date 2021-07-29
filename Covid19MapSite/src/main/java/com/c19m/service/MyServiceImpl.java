package com.c19m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c19m.dao.MyDAO;

@Service
public class MyServiceImpl implements MyService{
	
	@Autowired
	private MyDAO myDAO;
}
