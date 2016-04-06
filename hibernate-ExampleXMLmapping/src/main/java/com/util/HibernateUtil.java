package com.util;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			
			/**
			 * This is configuration using for Hibernate 3
			 */
//			return new Configuration().configure().buildSessionFactory();
			
			/**
			 * This is configuration using for Hibernate 4
			 */
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			return configuration.buildSessionFactory(serviceRegistry);
			
			
			/**
			 * This is configuration using for Hibernate 5
			 */
//			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//	        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//	        return metadata.getSessionFactoryBuilder().build();
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
