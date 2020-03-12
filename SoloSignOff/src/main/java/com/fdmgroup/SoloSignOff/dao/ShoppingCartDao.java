package com.fdmgroup.SoloSignOff.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.SoloSignOff.model.ShoppingCart;

/**
 * UserDao: Dao object to access the ShoppingCart table in the database
 *
 * @version 1.0
 */
public class ShoppingCartDao extends GenericDao<ShoppingCart> {

	private static Logger logger = LogManager.getLogger();

	private EntityManager em;

	public ShoppingCartDao(EntityManagerFactory emf) {
		super(emf);
		logger.info("ShoppingCartDao created");
	}

	@Override
	public boolean add(ShoppingCart t) {
		logger.info("Attempting to add new ShoppingCart");
		em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			logger.error("Error: Unable to add new ShoppingCart", e);
		} finally {
			em.close();
		}
		logger.info("New ShoppingCart has been added");
		return true;
	}

	@Override
	public ShoppingCart get(int id) {
		logger.info("Attempting to retrieve ShoppingCart");
		em = getEmf().createEntityManager();
		ShoppingCart cart = null;
		try {
			cart = em.find(ShoppingCart.class, id);
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve ShoppingCart", e);
		} finally {
			em.close();
		}
		logger.info("ShoppingCart has been retrieved");
		return cart;
	}

	@Override
	public boolean update(ShoppingCart t) {
		logger.info("Attempting to update ShoppingCart");
		em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			logger.error("Error: Unable to update ShoppingCart", e);
		} finally {
			em.close();
		}
		logger.info("ShoppingCart has been updated");
		return true;
	}

	@Override
	public boolean remove(int id) {
		logger.info("Attempting to remove ShoppingCart");
		em = getEmf().createEntityManager();
		ShoppingCart cart = em.find(ShoppingCart.class, id);
		try {
			em.getTransaction().begin();
			em.remove(cart);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			logger.error("Error: Unable to remove ShoppingCart", e);
		} finally {
			em.close();
		}
		logger.info("ShoppingCart has been removed");
		return true;
	}

	@Override
	public List<ShoppingCart> list() {
		logger.info("Attempting to retrieve list of Item");
		List<ShoppingCart> list = null;
		em = getEmf().createEntityManager();
		try {
			TypedQuery<ShoppingCart> query = em.createNamedQuery("cartFindAll", ShoppingCart.class);
			list = query.getResultList();
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve list of Shopping Carts");
			e.printStackTrace();
		} finally {
			em.close();
		}
		logger.info("ShoppingCart List has been retrieved");
		return list;
	}

}

