package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.onetoonemapping.Person;
import com.hibernate.onetoonemapping.PersonDetail;

public class TestStudent {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		College college = new College();
		college.setCollegeName("Cameron University");

		Student nijjwal = new Student();
		nijjwal.setStudentName("Nijjwal Shrestha");
		nijjwal.setCollege(college);

		Student anna = new Student();
		anna.setStudentName("Anna");
		anna.setCollege(college);

		session.save(college);
		session.save(nijjwal);
		session.save(anna);

		session.getTransaction().commit();

	}
}
