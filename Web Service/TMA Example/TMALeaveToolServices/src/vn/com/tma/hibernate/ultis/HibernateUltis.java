package vn.com.tma.hibernate.ultis;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUltis {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	   @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
	       
	       Configuration configuration = new Configuration();
	       
	      return  (SessionFactory) configuration.configure().buildSessionFactory();
	   }
	 
	   public static SessionFactory getSessionFactory() {
	       return sessionFactory;
	   }
	 
	   public static void shutdown() {
	       
	       getSessionFactory().close();
	   }

}
