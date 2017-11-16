package com.springzero.springhibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thuat T Nguyen
 * @version 06/02/2017
 */
@Transactional // Transactional nói cho Spring biết về việc quản lý các transaction khi các method này được gọi
public class EmployeeUsingHqlDaoImpl implements EmployeeUsingHqlDao {
	
	@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> list = (List<Employee>)session.createQuery("from Employee").list();
		return list;
	}
	
	@Override
	public Integer getMaxDeptId() {
	      Session session = this.sessionFactory.getCurrentSession();
	      String sql = "Select max(e.id) from Employee e";
	      Query query = session.createQuery(sql);
	      Integer maxDeptId = (Integer) query.uniqueResult();
	      if (maxDeptId == null) {
	          return 0;
	      }
	      return maxDeptId;
	  }
}
