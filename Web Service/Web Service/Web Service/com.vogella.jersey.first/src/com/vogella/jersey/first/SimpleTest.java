package com.vogella.jersey.first;



import java.sql.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.hibernate.HibernateException;

public class SimpleTest {
	private SessionFactory factory;

	public SimpleTest(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public static void main(String[] args){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Cau hinh thanh cong");	
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		SimpleTest simpleTest = new SimpleTest(factory);
		
//		account acc1 = new account(105,"TMA_User", new Date(115, 02, 02), 3500000);
//		System.out.println(acc1);
//		
//		Transaction transaction = session.beginTransaction();
//		try{
//			session.save(acc1);
//			transaction.commit();
//		}catch(Exception e){
//			System.out.println("Tai khoan da ton tai");
//		}
//		
//		System.out.println("Account saved succesfully....");
		
		account acc2 = new account(107, "TMA_Admin", new Date(114, 11, 01), 15000000);
		simpleTest.AddAccount(acc2);
		
		acc2.setBalance(200000);
		simpleTest.Update(acc2);
		acc2.setBalance(100000);
		simpleTest.Update(acc2);		
		
		simpleTest.LoadDanhSach();
		simpleTest.Delete(acc2);
		simpleTest.LoadDanhSach();
		
		simpleTest.searchID(105);
		simpleTest.searchAccountType("TMA_User");
		
		if(session != null ){
			session.close();
			System.out.println("Dong ket noi");
		}		
		
		factory.close();
	}
	
	public void AddAccount(account acc){
		System.out.println("ADDING ACCOUNT BY HIBERNATE");
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(acc);
			transaction.commit();
			System.out.println("Them account thanh cong");
		}catch(Exception e){
			System.out.println("Them khong duoc, trung account");
		} finally{
			session.close();
		}
	}
	
	public void Update(account acc){
		System.out.println("Updating account: " + acc);
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			account accountUpdate = (account)session.get(account.class, acc.getAccountID());
			
			accountUpdate.setAccountID(acc.getAccountID());
			accountUpdate.setAccountType(acc.getAccountType());
			accountUpdate.setCreationDate(acc.getCreationDate());
			accountUpdate.setBalance(acc.getBalance());
			
			session.update(accountUpdate);
			transaction.commit();
			System.out.println("Update thanh cong");
		}catch(Exception e){
			if(transaction != null){transaction.rollback();}
			e.printStackTrace();
			System.out.println("Update that bai");
		} finally{
			session.close();
		}
		System.out.println("After updating: " + acc);
	}
	
	public void Delete(account acc){
		System.out.println("Deleting account: " + acc);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(acc);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("Delete thanh cong");
	}
	
	public void LoadDanhSach(){
		System.out.println("Danh sach account trong Database ");
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<account> list = null;
			list=(List<account>) session.createQuery("FROM account").list();
			System.out.println("Danh sach la: " + list.size());
			for(account acc:list){
				System.out.println(acc);
			}
		} catch(HibernateException he){
			he.printStackTrace();
		} finally{
			session.close();
		}
		System.out.println("--------------------------The End----------------");
	}
	
	public void searchID(int id){
		System.out.println("Tim kiem account theo accountID: " + id);
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			
			Query query = session.createQuery("from account where accountID = " + id + " ");
			List<account> list = query.list();
			if(list.size()!=0){
				System.out.println("Tong account: " + list.size());
				for(account acc:list){
					System.out.println(acc);
				}
			} else {
				System.out.println("Khong ton tai account can tim");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void searchAccountType(String type){
		System.out.println("Tim kiem theo TYPE: " + type);
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			
			Query query = session.createQuery("FROM account WHERE accountType = " + "\'" + type + "\'");
			List<account> list = query.list();
			if(list.size()!=0){
				System.out.println("Tong account: " + list.size());
				for(account acc:list){
					System.out.println(acc);
				}
			}else{
				System.out.println("Khong ton tai account can tim");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
}
