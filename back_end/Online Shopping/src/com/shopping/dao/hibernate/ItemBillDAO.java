package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.shopping.model.ItemBill;
import com.shopping.util.HibernateUtil;

//Filter your code

public class ItemBillDAO {
	SessionFactory sessionFactory;
	Criteria criteria = null;

	public ItemBillDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<ItemBill> list() {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(ItemBill.class);
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<ItemBill> listItemBillByIdBill(Long idBill) {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(ItemBill.class);
			criteria.add(Restrictions.eq("idBill", idBill));
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	public void insertItemBill(ItemBill itemBill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(itemBill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public ItemBill findItemBill(Long id) {
		ItemBill bill = null;
		try {
			Session session = sessionFactory.openSession();
			bill = (ItemBill) session.get(ItemBill.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return bill;
	}

	public void updateItemBill(ItemBill itemBill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(itemBill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public void deleteItemBill(ItemBill itemBill) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(itemBill);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}
}
