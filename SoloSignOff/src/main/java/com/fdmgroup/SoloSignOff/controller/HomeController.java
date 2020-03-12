package com.fdmgroup.SoloSignOff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.SoloSignOff.dao.ItemDao;
import com.fdmgroup.SoloSignOff.dao.ShoppingCartDao;
import com.fdmgroup.SoloSignOff.dao.UserDao;
import com.fdmgroup.SoloSignOff.model.Item;
import com.fdmgroup.SoloSignOff.model.ShoppingCart;
import com.fdmgroup.SoloSignOff.model.User;

/**
 *	HomeController: Default controller to handle request through out whole application 
 * 
 *
 */
@Controller
public class HomeController implements ApplicationContextAware{
	
	private ApplicationContext context;
	private static Logger logger = LogManager.getLogger();
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	@RequestMapping(value = { "/", "/index", "/home" })
	public String goToHome(HttpServletRequest req) {
		logger.info("Attempting to go home");
		HttpSession session = req.getSession();
		ItemDao itemDao = context.getBean("itemDao", ItemDao.class);
		List<Item> itemList = itemDao.list();
		session.setAttribute("itemList", itemList);
		
		return "index";
	}

	@RequestMapping(value = "/reviewSelection")
	public String selectQuantity(HttpServletRequest req) {
		logger.info("Attempting to add quantity");
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		ItemDao itemDao = context.getBean("itemDao", ItemDao.class);
		itemDao.get(itemId);
		
		req.setAttribute("selectedItem", itemDao.get(itemId));
		
		return "viewSelectedItem";
		
	}
	
	@RequestMapping(value = "/processPurchase")
	public String addItemToCart(HttpServletRequest req) {
		logger.info("Attempting to add item to cart");
		ShoppingCartDao cartDao = context.getBean("cartDao", ShoppingCartDao.class);
//		UserDao userDao = context.getBean("userDao", UserDao.class);
		ShoppingCart emptyCart = new ShoppingCart(new User("Mark", "Adams", 4000));
		int errorCheck = 0;
		
		ItemDao itemDao = context.getBean("itemDao", ItemDao.class);
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		Item item = itemDao.get(itemId);
		
		int itemQuantity = Integer.parseInt(req.getParameter("itemQuantity"));
		
		req.setAttribute("requestQuantity", itemQuantity);
		if(item.getQuantity() < itemQuantity || item.getQuantity() <= 0){
			errorCheck = 1;
			req.setAttribute("errorCheck", errorCheck);
			return "viewSelectedItem";
		} else {
			emptyCart.addItemToCart(item);
			cartDao.add(emptyCart);
			errorCheck = 0;
			req.setAttribute("errorCheck", errorCheck);
			List<Item> cart = emptyCart.getCart();
	
			int newItemQuantity = item.getQuantity() - itemQuantity;
			item.setQuantity(newItemQuantity);
			itemDao.update(item);
			req.setAttribute("cart", cart);
		}
		
		return "Cart";
	}
}