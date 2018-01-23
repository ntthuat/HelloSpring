package com.vogella.jersey.first;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;



public class Method {
	SessionFactory sessionFactory = HibernateUltis.getSessionFactory();

	public Method() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateScore(String username, String classPerson, String project, int count, int number){
		System.out.println("Updating Score");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		person per = new person();
		per.setName(username);
		per.setNum_question(number);
		per.setScore(count);
		per.setClassPerson(classPerson);
		per.setType_projectTest(project);
		try{
			session.save(per);
			transaction.commit();
			System.out.println("Adding success");
		}catch(Exception e){
			System.out.println("Adding fail");
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public User addUser(String username, String userpassword, String fullname, String classPerson) {
		System.out.println("ADDING ACCOUNT BY HIBERNATE");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setName(username);
		user.setPassword(userpassword);
		user.setFullname(fullname);
		user.setClassPerson(classPerson);
		user.setType_account("member");
		try {
			session.save(user);
			transaction.commit();
			System.out.println("Them account thanh cong");
		} catch (Exception e) {
			System.out.println("Them khong duoc, trung account");
			user = null;
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return user;
	}


	public User checkLogin(String name, String password) {
		System.out.println("Dang thuc hien dang nhap");
		Session session = sessionFactory.openSession();

		User user = null;
		try {
			Query query = session.createQuery("from User where name = " + "\'" + name + "\'");
			@SuppressWarnings("unchecked")
			List<User> listUser = query.list();
			if (listUser.size() == 1) {
				if (listUser.get(0).getPassword().equals(password)) {
					user = listUser.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> showUser() {
		Session session = sessionFactory.openSession();
		List<User> list = new ArrayList<User>();
		try {
			Query query = session.createQuery("from User");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<person> showPerson() {
		Session session = sessionFactory.openSession();
		List<person> list = new ArrayList<person>();
		try {
			Query query = session.createQuery("from person");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(){
		Session session= sessionFactory.openSession();
		List<User> list= new ArrayList<User>();
		try {
			session.beginTransaction();
			Query query= session.createQuery("From User");
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<question> getAllQuestion(){
		Session session= sessionFactory.openSession();
		List<question> list= new ArrayList<question>();
		try {
			session.beginTransaction();
			Query query= session.createQuery("From question");
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<questionTest> getAllQuestionTest(){
		Session session= sessionFactory.openSession();
		List<questionTest> list= new ArrayList<questionTest>();
		try {
			session.beginTransaction();
			Query query= session.createQuery("From questiontest");
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<person> getAllPerson(){
		Session session= sessionFactory.openSession();
		List<person> list= new ArrayList<person>();
		try {
			session.beginTransaction();
			Query query= session.createQuery("From person");
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return list;
	}
	
}
