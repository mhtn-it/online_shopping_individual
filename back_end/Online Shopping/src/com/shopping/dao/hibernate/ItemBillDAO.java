package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
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

	public ItemBillDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<ItemBill> list() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(ItemBill.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemBill> listItemBillByIdBill(Long id_bill) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(ItemBill.class);
		cr.add(Restrictions.eq("id_bill", id_bill));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}

	public void insertItemBill(ItemBill itemBill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(itemBill);
		transaction.commit();
		session.close();
	}
	
	public ItemBill findItemBill(Long id) {
		Session session = sessionFactory.openSession();
		ItemBill bill = (ItemBill) session.get(ItemBill.class, id);
		session.close();
		return bill;
	}
	
	public void updateItemBill(ItemBill itemBill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(itemBill);
		transaction.commit();
		session.close();
	}

	public void deleteItemBill(ItemBill itemBill) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(itemBill);
		transaction.commit();
		session.close();
	}
}
