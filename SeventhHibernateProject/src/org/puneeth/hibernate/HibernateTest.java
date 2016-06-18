package org.puneeth.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		user.setUserName("First Person");
		user.setAddress("First User's Address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved: " + user.getUserName());
		
		System.gc();
		System.exit(0);
	}

}
