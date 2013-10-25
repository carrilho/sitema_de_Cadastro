package br.com.estudos.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() {
		super();
	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				sessionFactory = cfg.configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("erro ao iniciar SessioFactory" + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		}
		return sessionFactory;
	}

}
