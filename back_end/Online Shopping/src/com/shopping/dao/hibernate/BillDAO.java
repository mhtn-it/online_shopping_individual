package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.shopping.model.Bill;
import com.shopping.util.HibernateUtil;

//Filter your code

public class BillDAO {
	SessionFactory sessionFactory;

	public BillDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Bill> list() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Bill.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bill> listBillByIdUser(Long id_user) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Bill.class);
		cr.add(Restrictions.eq("id_user", id_user));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}

	public void insertBill(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bill);
		transaction.commit();
		session.close();
	}
	
	public Bill findBill(Long id) {
		Session session = sessionFactory.openSession();
		Bill bill = (Bill) session.get(Bill.class, id);
		session.close();
		return bill;
	}
	
	public void updateBill(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(bill);
		transaction.commit();
		session.close();
	}

	public void deleteBill(Bill bill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(bill);
		transaction.commit();
		session.close();
	}
}
