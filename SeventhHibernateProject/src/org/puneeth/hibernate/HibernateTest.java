package org.puneeth.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
//		user1.setUserId(1);
		user1.setUserName("First Person");
		user1.setAddress("First User's Address");
		user1.setJoinedDate(new Date());
		user1.setDescription("Description of the user goes here");
		
		UserDetails user2 = new UserDetails();
//		user2.setUserId(1);
		user2.setUserName("Second Person");
		user2.setAddress("Second User's Address");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of the user goes here");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

//		user1 = null;
//		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		user1 = session.get(UserDetails.class, 1);
//		System.out.println("User Name retrieved: " + user1.getUserName());
		
		System.gc();
		System.exit(0);
	}

}
