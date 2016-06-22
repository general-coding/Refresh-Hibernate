package org.puneeth.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.Address;
import org.puneeth.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		Address homeAddr = new Address();
		homeAddr.setStreet("Home Street Name");
		homeAddr.setCity("Home City Name");
		
		Address officeAddr = new Address();
		officeAddr.setStreet("Office Street Name");
		officeAddr.setCity("Office City Name");
		
		user.setUserName("First Person");
		user.setHomeAddress(homeAddr);
		user.setJoinedDate(new Date());
		user.setDescription("Description");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		System.exit(0);
	}

}
