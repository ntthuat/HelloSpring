package vn.com.tma.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.com.tma.entity.Paramater;
import vn.com.tma.hibernate.ultis.HibernateUltis;

public class ParamaterDAO {
	private static SessionFactory factory = HibernateUltis.getSessionFactory();
	public static int getDayParamater(){
		
		Session session= factory.openSession();
		int day=0;
		try {
			session.beginTransaction();
			Paramater paramater=(Paramater) session.createQuery("From Paramater").uniqueResult();
			day= paramater.getDay();
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return day;
		
	}

}
