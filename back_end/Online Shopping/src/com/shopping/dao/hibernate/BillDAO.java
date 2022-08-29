package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	Criteria criteria = null;

	public BillDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Bill> list() {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(Bill.class);
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Bill> listBillByIdUser(Long idUser) {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(Bill.class);
			criteria.add(Restrictions.eq("idUser", idUser));
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	public void insertBill(Bill bill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(bill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public Bill findBill(Long id) {
		Bill bill = null;
		try {
			Session session = sessionFactory.openSession();
			bill = (Bill) session.get(Bill.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return bill;
	}

	public void updateBill(Bill bill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(bill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public void deleteBill(Bill bill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(bill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public Long getSumAmount() {
		long sum = -1;
		try {
			Session session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getSum");
			sum = (Long) query.uniqueResult();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return sum;
	}

	public Long getSumAmountOfUser(Long idUser) {
		long sum = -1;
		try {
			Session session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getSumOfUser");
			query.setParameter(0, idUser);
			sum = (Long) query.uniqueResult();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return sum;
	}
}
