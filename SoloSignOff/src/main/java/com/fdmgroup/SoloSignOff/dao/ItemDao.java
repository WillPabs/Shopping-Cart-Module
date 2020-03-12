package com.fdmgroup.SoloSignOff.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.SoloSignOff.model.Item;

/**
 * UserDao: Dao object to access the Item table in the database
 *
 * @version 1.0
 */
public class ItemDao extends GenericDao<Item> {

	private static Logger logger = LogManager.getLogger();

	private EntityManager em;

	public ItemDao(EntityManagerFactory emf) {
		super(emf);
		logger.info("ItemDao created");
	}

	@Override
	public boolean add(Item t) {
		logger.info("Attempting to add new Item");
		em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			logger.error("Error: Unable to add new Item", e);
		} finally {
			em.close();
		}
		logger.info("New Item has been added");
		return true;
	}

	@Override
	public Item get(int id) {
		logger.info("Attempting to retrieve Item");
		em = getEmf().createEntityManager();
		Item item = null;
		try {
			item = em.find(Item.class, id);
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve Item", e);
		} finally {
			em.close();
		}
		logger.info("Item has been retrieved");
		return item;
	}

	@Override
	public boolean update(Item t) {
		logger.info("Attempting to update Item");
		em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			logger.error("Error: Unable to update Item", e);
		} finally {
			em.close();
		}
		logger.info("Item has been updated");
		return true;
	}

	@Override
	public boolean remove(int id) {
		logger.info("Attempting to remove Item");
		em = getEmf().createEntityManager();
		Item item = em.find(Item.class, id);
		try {
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			logger.error("Error: Unable to remove Item", e);
		} finally {
			em.close();
		}
		logger.info("Item has been removed");
		return true;
	}

	@Override
	public List<Item> list() {
		logger.info("Attempting to retrieve list of Item");
		List<Item> list = null;
		em = getEmf().createEntityManager();
		try {
			TypedQuery<Item> query = em.createNamedQuery("itemFindAll", Item.class);
			list = query.getResultList();
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve list of items");
			e.printStackTrace();
		} finally {
			em.close();
		}
		logger.info("Item List has been retrieved");
		return list;
	}

	public List<Item> listOfItems() {
		logger.info("Attempting to get Item list");
		List<Item> list = null;
		em = getEmf().createEntityManager();
		try {
			TypedQuery<Item> query = em.createNamedQuery("itemFindByName", Item.class);
			list = query.getResultList();
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve list of item names");
			e.printStackTrace();
		} finally {
			em.close();
		}
		logger.info("Item List of item names has been retrieved");
		return list;
	}

	public Item getItemByName(String itemName) {
		logger.info("Attempting to get User by username");
		em = getEmf().createEntityManager();
		Item item = null;
		try {
			TypedQuery<Item> query = em.createNamedQuery("itemFindByName", Item.class);
			query.setParameter("itemName", itemName);
			item = query.getSingleResult();
		} catch (NoResultException e) {
			logger.error("Error: Unable to retrieve item by name");
			e.printStackTrace();
		} finally {
			em.close();
		}
		logger.info("Item has been retrieved");
		return item;
	}

}

