package com.springzero.springhibernate;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thuat T Nguyen
 * @version 07/13/2017
 */
@Transactional // Transactional nói cho Spring biết về việc quản lý các transaction khi các method này được gọi
public class EmployeeUsingNativeSqlDaoImpl implements EmployeeUsingNativeSqlDao{

	@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Method lấy tất cả giá trị trong table.<br>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from employee where 1=1");
		sqlQuery.addEntity(Employee.class);
		return sqlQuery.list();
	}
	
	/**
	 * Method lấy tất cả giá trị có id lớn hơn hoặc bằng giá trị id truyền vào.<br>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> conditionEqualBiggerId(Integer id){
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from employee where id>= :id");
		sqlQuery.setInteger("id", id);
		sqlQuery.addEntity(Employee.class);
		return sqlQuery.list();
	}
	
	/**
	 * Method lấy giá trị có id bằng giá trị id truyền vào.<br>
	 */
	@Override
	public Employee findId(Integer id){
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from employee where id= :id");
		sqlQuery.setInteger("id", id);
		sqlQuery.addEntity(Employee.class);
		return (Employee)sqlQuery.uniqueResult();
	}
	
	/**
	 * Method save employee xuống database<br>
	 */
	@Override
	public void saveEmployee(Employee e){
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("insert into employee(id,name) VALUES(?,?)");
		sqlQuery.setParameter(0, e.getId()); // vì nullable cho id bằng false nên cần phải khai báo giá trị cho id
		sqlQuery.setParameter(1, e.getName());
		sqlQuery.executeUpdate();
		/* Vì có @Transactional nên ta không cần commit ở đây, spring sẽ tự quản lý các transaction */
	}
	
	/**
	 * Method delete employee trong database<br>
	 */
	@Override
	public void deleteEmployeeById(Integer id){
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("delete from employee where id= ?");
		sqlQuery.setParameter(0, id);
		sqlQuery.executeUpdate();
		/* Vì có @Transactional nên ta không cần commit ở đây, spring sẽ tự quản lý các transaction */
	}
}
