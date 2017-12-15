package com.lienminh69.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.lienminh69.entity.Employee;

/**
 * @author Thuat T Nguyen
 * @version 2017/12/07
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
		final Session session = this.sessionFactory.getCurrentSession();
		final String sql = "from Employee where 1=1";
		final Query query = session.createQuery(sql);
		final List<Employee> list = (List<Employee>) query.list();
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeeUsingCriteria(){
		final Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		final List<Employee> list = (List<Employee>) criteria.list();
		return list;
	}
	
	@Override
	public Integer getMaxEmployeetId() {
		final Session session = this.sessionFactory.getCurrentSession();
		final String sql = "Select max(e.id) from Employee e where 1=1";
		final Query query = session.createQuery(sql);
		final Integer maxEmployeeId = (Integer) query.uniqueResult();
		if (maxEmployeeId == null) {
			return 0;
		}
		return maxEmployeeId;
	}
	
	/**
	 * Projections is used for: rowCount, min, max, average, sum
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Integer getMaxEmployeeIdUsingCriteria() {
		final Session session = this.sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("id"));
		criteria.setMaxResults(1);
		final List<Integer> list = criteria.list();
		if (list == null) {
			return 0;
		}
		return list.get(0);
	}
	
	@Override
	public Employee findEmployeeByName(final String name) {
		final Session session = this.sessionFactory.getCurrentSession();
		final String sql = "from Employee where name = :name";
		final Query query = session.createQuery(sql);
		query.setParameter("name", name);
		final Employee employee = (Employee) query.uniqueResult();
		return employee;
	}
	
	/**
	 * result = 1 when successful, result = 0 when not successful
	 */
	@Override
	public int deleteEmployeeByName(final String name) {
		final Session session = this.sessionFactory.getCurrentSession();
		final String sql = "delete Employee where name = :name";
		final Query query = session.createQuery(sql);
		query.setParameter("name", name);
		final int result = query.executeUpdate();
		return result;
	}
	
	@Override
	public void saveEmployee(final Employee employee) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
	}
	
	/**
	 * result = 1 when successful, result = 0 when not successful
	 */
	@Override
	public int updateNameEmploye(final String name, final String updatedName) {
		final Session session = this.sessionFactory.getCurrentSession();
		final String sql = "update Employee set name =:updatedName where name = :name";
		final Query query = session.createQuery(sql);
		query.setParameter("updatedName", updatedName);
		query.setParameter("name", name);
		final int result = query.executeUpdate();
		return result;
	}
	
	/**
	 * 
	 * If can not find record, method return null
	 */
	@Override
	public Employee getEmployeeUsingSessionGetViaId(final int id){
		final Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee)session.get(Employee.class, id);
		return employee;
	}
	
	/**
	 * 
	 * If can not find record, method throws an exception
	 */
	@Override
	public Employee getEmployeeUsingSessionLoadViaId(final int id){
		final Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee)session.load(Employee.class, id);
		return employee;
	}
}
