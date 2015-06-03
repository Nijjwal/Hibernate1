package com.hibernate.class1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");
		//new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		{
			Employee alex = new Employee();
			// alex.setEmpId(100);
			alex.setEmpName("Alex Dangol");
			alex.setEmpEmailAddress("alex@gmail.com");
			alex.setEmpPassword("alexcha");
			alex.setPermanent(true);
			alex.setEmpJoinDate(new GregorianCalendar(2010, 03, 22));
			alex.setEmpLoginTime(Date.valueOf("2009-06-02"));
			session.save(alex);
		}
		
		
		{
			Employee alex = new Employee();
			// alex.setEmpId(100);
			alex.setEmpName("Anna Smith");
			alex.setEmpEmailAddress("asmith@gmail.com");
			alex.setEmpPassword("anna");
			alex.setPermanent(false);
			alex.setEmpJoinDate(new GregorianCalendar(2010, 03, 22));
			alex.setEmpLoginTime(Date.valueOf("2015-06-02"));
			session.save(alex);
		}

		session.getTransaction().commit();

	}
}
