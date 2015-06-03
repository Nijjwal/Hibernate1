package com.hibernate.compoundkeytest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.class3.Customer;

public class TestAccount {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Account.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		CompoundKey key1 = new CompoundKey();
		key1.setUserId(100);
		key1.setAccountId(142900);
		
		Account myAccount = new Account();
		myAccount.setCompoundKey(key1);
		myAccount.setAccountBalance(160);
		
		session.save(myAccount);
		session.getTransaction().commit();
	}

}
