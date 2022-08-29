package com.shopping.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
	Criteria criteria = null;

	public ReviewDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Review> list() {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(Review.class);
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Review> listReviewByIdUser(Long idUser) {
		try {
			Session session = sessionFactory.openSession();
			criteria = session.createCriteria(Review.class);
			criteria.add(Restrictions.eq("idUser", idUser));
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Review> listReviewByIdItem(Long idItem) {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Review.class);
			criteria.add(Restrictions.eq("idItem", idItem));
			criteria.addOrder(Order.asc("id"));
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return criteria.list();
	}

	public void insertReview(Review review) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(review);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}

	}

	public Review findReview(Long id) {
		Review review = null;
		try {
			Session session = sessionFactory.openSession();
			review = (Review) session.get(Review.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
		return review;
	}

	public void updateReview(Review review) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(review);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}

	public void deleteReview(Review review) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(review);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			System.out.println(e.toString());
		}
	}
}
