package com.hibernate.class3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.class1.Employee;
 
public class TestCustomer {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Customer alex = new Customer();
		alex.setCustomerName("Alex Dangol");
		alex.setCustomerAddress("613 Humbert Street");
		alex.setCreditScore(630);
		alex.setRewardPoints(400);
		
		session.save(alex);
		session.getTransaction().commit();
		
	}
	
	

}
