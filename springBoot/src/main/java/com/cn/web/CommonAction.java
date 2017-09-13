package com.cn.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@Transactional 
public class CommonAction { 
	@Resource 
	private SessionFactory sessionFactory; 
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("test") 
	public void test(HttpServletResponse response){ 
		Session session = sessionFactory.getCurrentSession(); 
		SQLQuery sqlQuery = session.createSQLQuery("select * from t_users"); 
		List list = sqlQuery.list(); 
		System.out.printf(list.size()+""); 
		try { 
			response.setContentType("application/json"); 
			response.setHeader("Cache-Control", "no-cache"); 
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"msg\":\"调用成功\"}"); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
}

