package org.puneeth.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.Address;
import org.puneeth.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First Person");

		Address first = new Address();
		first.setStreet("First Street");
		first.setCity("First City");
		first.setState("First State");
		first.setPincode("1000001");

		Address second = new Address();
		second.setStreet("Second Street");
		second.setCity("Second City");
		second.setState("Second State");
		second.setPincode("1000002");

		user.getListOfAddress().add(first);
		user.getListOfAddress().add(second);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		System.exit(0);
	}

}
