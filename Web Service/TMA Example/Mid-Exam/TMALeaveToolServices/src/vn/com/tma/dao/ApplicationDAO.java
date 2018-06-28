package vn.com.tma.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.com.tma.entity.Application;
import vn.com.tma.hibernate.ultis.HibernateUltis;

public class ApplicationDAO {
	SessionFactory sessionFactory = HibernateUltis.getSessionFactory();

	public boolean insertApplication(Application app) {
		Session session = sessionFactory.openSession();
		try {
			if (checkAddApplication(app.getUsername(), app.getLeave_days())) {
				session.beginTransaction();
				session.save(app);
				session.getTransaction().commit();
				return true;

			} else {
				return false;

			}

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;

	}

	public boolean checkAddApplication(String username, int leave) {
		Session session = sessionFactory.openSession();
		int sum_leave = 0;
		int limit_day = 0;
		try {
			session.beginTransaction();
			String hql = "select sum(leave_days) from Application where username='" + username + "' and (status=1 or status=0)";
			Query query = session.createQuery(hql);
			@SuppressWarnings("rawtypes")
			List result = query.list();
			System.out.println("day leave: " + result.get(0));
			if (result.get(0) != null) {
				sum_leave = Integer.parseInt(result.get(0).toString());
			} else {
				sum_leave = 0;

			}

			limit_day = ParamaterDAO.getDayParamater();
			session.getTransaction().commit();
			System.out.println("limitday"+limit_day);
			System.out.println("sumday"+sum_leave);
			System.out.println("leaveday"+leave);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		if ((sum_leave + leave) <= limit_day)
			return true;
		return false;

	}

	@SuppressWarnings("unchecked")
	public List<Application> getApplicationByUser(String username) {
		Session session = sessionFactory.openSession();

		List<Application> applications = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Application where username='" + username + "'");
			applications = query.list();
			session.getTransaction().rollback();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return applications;

	}

	public boolean updateApplication(String id, int status) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			if(status==1){
				String hql2="from Application where id="+id;
				Query query=session.createQuery(hql2);
				Application app= (Application) query.uniqueResult();
				String username=app.getUsername();
				int leave= app.getLeave_days();
				if(!checkAddApplication(username, leave))
					return false;
			
			}
			String hql="UPDATE Application set status ="+status+" WHERE id ="+id;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			System.out.println("thanh cong");
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}
}
