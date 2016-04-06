package com;

import java.util.Date;
import java.util.List;

import oracle.jdbc.proxy.annotation.Pre;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.user.DBUser;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(101);
		user.setUsername("batman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
//		session.getTransaction().commit();
		tx.commit();
		
		
//		tx = session.beginTransaction();
//		@SuppressWarnings("unchecked")
//			
//		List<DBUser> dbUserList = (List<DBUser>)session.createQuery("FROM DBUser").list();
//		for(DBUser dbUser : dbUserList) {
//			System.out.print("UserID: " + dbUser.getUserId());
//			System.out.print(", Username: " + dbUser.getUsername());
//			System.out.print(", CreatedBy: " + dbUser.getCreatedBy());
//			System.out.println(", CreatedDate: " + dbUser.getCreatedDate());
//		}
//		tx.commit();
	}
}
