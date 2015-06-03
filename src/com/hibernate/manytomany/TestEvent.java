package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.onetomany.College;
import com.hibernate.onetomany.Student;

public class TestEvent {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Delegate.class);
		config.addAnnotatedClass(Event.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Delegate delegate1 = new Delegate();
		delegate1.setDelegateName("Anna Smith");

		Delegate delegate2 = new Delegate();
		delegate2.setDelegateName("Chris Miller");

		Delegate delegate3 = new Delegate();
		delegate3.setDelegateName("Tom Hank");

		Event hibernateEvent = new Event();
		hibernateEvent.setEventName("Hibernate Basics 101");

		Event coreJavaEvent = new Event();
		coreJavaEvent.setEventName("Core Java Interview Practice 101");

		Event springEvent = new Event();
		springEvent.setEventName("Spring event tutorial");

		hibernateEvent.getDelegates().add(delegate1);
		hibernateEvent.getDelegates().add(delegate2);
		hibernateEvent.getDelegates().add(delegate3);

		coreJavaEvent.getDelegates().add(delegate3);

		springEvent.getDelegates().add(delegate1);
		springEvent.getDelegates().add(delegate2);

		session.save(delegate1);
		session.save(delegate2);
		session.save(delegate3);
		session.save(hibernateEvent);
		session.save(coreJavaEvent);
		session.save(springEvent);

		session.getTransaction().commit();
	}
}
