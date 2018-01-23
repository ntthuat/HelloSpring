package vn.com.tma.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import vn.com.tma.entity.Employee;
import vn.com.tma.hibernate.ultis.HibernateUltis;

public class EmployeeDAO {
	SessionFactory sessionFactory =HibernateUltis.getSessionFactory();
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEngineer(){
		Session session= sessionFactory.openSession();
		List<Employee> employees=null;
		try {
			session.beginTransaction();
			String hsl = "From Employee Where admin='0'";
			Query query= session.createQuery(hsl);
			employees= query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return employees;
	}
	public Employee checkLogin(String username, String password){
		Session session= sessionFactory.openSession();
		Employee employee=null;
		try {
			session.beginTransaction();
			String hsl = "From Employee Where username= :username and password= :password";
			Query query= session.createQuery(hsl);
			query.setParameter("username", username);
			query.setParameter("password", password);
			employee= (Employee) query.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return employee;

	
	}
	public int getLeave(String username){
		Session session= sessionFactory.openSession();
		int sum_leave=0;
		try {
			session.beginTransaction();
			String hql= "select sum(leave_days) from Application where username='"+username+"' and status=1";
			Query query= session.createQuery(hql);
			@SuppressWarnings("rawtypes")
			List result= query.list();
			if(result.get(0)!=null){
				sum_leave=Integer.parseInt(result.get(0).toString());
			}else{
				sum_leave=0;
				
			}
			 
			 session.getTransaction().commit();
		
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
		return sum_leave;
	}
	
	public boolean checkAdmin(String username){
		
		Session session= sessionFactory.openSession();
		Employee employee=null;
		try {
			session.beginTransaction();
			String hsl = "from Employee Where username= :username";
			Query query= session.createQuery(hsl);
			employee= (Employee) query.uniqueResult();
			if(employee.getAdmin()==1)
				return true;
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}
}
