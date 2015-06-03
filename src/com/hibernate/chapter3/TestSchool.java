package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.class1.Employee;

public class TestSchool {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		SchoolDetail annaSchoolDetail = new SchoolDetail();
		annaSchoolDetail.setSchoolAddress("2800 W Gore Blvd");
		annaSchoolDetail.setStudentCount(300);
		annaSchoolDetail.setPublicSchool(true);
		
		School cameron = new School();
		cameron.setSchoolDetail(annaSchoolDetail);
		cameron.setSchoolName("Cameron University");
		
		session.save(cameron);
		session.getTransaction().commit();
		

	}

}
