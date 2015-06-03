package com.hibernate.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.inheritancemapping.Module;
import com.hibernate.inheritancemapping.Project;
import com.hibernate.inheritancemapping.Task;

public class TestPerson {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		PersonDetail personDetail = new PersonDetail();
		personDetail.setIncome(65.00);
		personDetail.setJob("JEE Developer");
		personDetail.setZipCode("82742");
		
		
		Person nijjwal = new Person();
		nijjwal.setpDetail(personDetail);
		nijjwal.setPersonName("Nijjwal Shrestha");
		
		//session.save(personDetail); NOT required if we set cascadeType
		session.save(nijjwal);
		
		session.getTransaction().commit();
	}
}
