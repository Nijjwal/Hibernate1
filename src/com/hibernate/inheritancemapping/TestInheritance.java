package com.hibernate.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.compoundkeytest.Account;

public class TestInheritance {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		Project p = new Project();
		p.setProjectName("Hibernate Lessons");
		
		Module m = new Module();
		m.setProjectName("Spring Lessons");
		m.setModuleName("AOP");
		
		
		Task t = new Task();
		t.setProjectName("Java Lesons");
		t.setModuleName("Collections");
		t.setTaskName("ArrayList");
		
		session.save(p);
		session.save(m);
		session.save(t);
		
		session.getTransaction().commit();
		
	}

}
