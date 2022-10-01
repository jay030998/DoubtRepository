package com.greatlearning.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.crm.model.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

private SessionFactory sessionFactory;
	
	//create session
	private  Session session;
	
	@Autowired
	CustomerServiceImpl (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		try {
			session=sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session=sessionFactory.openSession();
		}
	}
	
	@Override
	@Transactional
	public List<Customer> findAll(){
		
		Transaction tx = session.beginTransaction();
		
		List<Customer> customers = session.createQuery("from customer").list();
		
		tx.commit();
		
		return customers;
		
	}
	
	@Override
	@Transactional 
	public Customer findById(int id) {
		
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		
		customer = session.get(Customer.class, id);
		 tx.commit();
		 
		 return customer;
	}
	
	@Override
	@Transactional
	public void save(Customer theCustomer) {

		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theCustomer);
		
		tx.commit();
	}
	
	@Override
	@Transactional
	public void deleteById(int theId) {
		
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, theId);
		
		session.delete(customer);
		tx.commit();
	}

}
