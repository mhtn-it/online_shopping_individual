package com.shopping.util;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shopping.model.Bill;
import com.shopping.model.Review;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	static {
		try {
			Logger log = Logger.getLogger("org.hibernate");
			log.setLevel(Level.OFF);
			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
			ResourceBundle rb = ResourceBundle.getBundle("oracle");
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.configuration.xml");
			configuration.setProperty("hibernate.connection.url", rb.getString("db.url"));
			configuration.setProperty("hibernate.connection.username", rb.getString("db.username"));
			configuration.setProperty("hibernate.connection.password", rb.getString("db.password"));
			// fill your code here
			sessionFactory = configuration.buildSessionFactory();
			configuration.addPackage("com.shopping.model");
			configuration.addAnnotatedClass(Bill.class);
			configuration.addAnnotatedClass(Review.class);
		} catch (Throwable ex) {
			System.err.println("SessionFactory initial creation error." + ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		// fill your code here
		return sessionFactory;
	}
}