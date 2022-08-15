package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.shopping.model.Review;
import com.shopping.util.HibernateUtil;

//Filter your code

public class ReviewDAO {
	SessionFactory sessionFactory;

	public ReviewDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Review> list() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Review.class);
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Review> listReviewByIdUser(Long id_user) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Review.class);
		cr.add(Restrictions.eq("id_user", id_user));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Review> listReviewByIdItem(Long id_item) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Review.class);
		cr.add(Restrictions.eq("id_item", id_item));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}

	public void insertReview(Review review) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(review);
		transaction.commit();
		session.close();
	}
	
	public Review findReview(Long id) {
		Session session = sessionFactory.openSession();
		Review review = (Review) session.get(Review.class, id);
		session.close();
		return review;
	}
	
	public void updateReview(Review review) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(review);
		transaction.commit();
		session.close();
	}

	public void deleteReview(Review review) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(review);
		transaction.commit();
		session.close();
	}
}
