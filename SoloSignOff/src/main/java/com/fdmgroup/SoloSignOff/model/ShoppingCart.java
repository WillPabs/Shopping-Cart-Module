package com.fdmgroup.SoloSignOff.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="SHOPPING_CART")
@NamedQueries({ @NamedQuery(name = "cartFindAll", query = "SELECT u FROM ShoppingCart u"),
	@NamedQuery(name = "cartFindById", query = "SELECT u FROM ShoppingCart u WHERE u.cartId = :cartId"),
	@NamedQuery(name = "cartFindByUserIdFK", query = "SELECT u FROM ShoppingCart u WHERE u.user = :user")
 })
public class ShoppingCart{

	@Id
	@Column(name = "CART_ID", length = 4, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_gen")
	@SequenceGenerator(name = "cart_id_gen", sequenceName = "cart_id_seq", allocationSize = 1)
	private int cartId;
	
	@OneToOne
	@JoinColumn(name="USER_ID_FK")
	private User user;
	
	@Transient
	private List<Item> cart = new ArrayList<Item>();
	
	public ShoppingCart(User user) {
		super();
		this.user = user;
	}
	
	public ShoppingCart(){
		super();
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + cartId + ", cart=" + cart + "]";
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getCart() {
		return cart;
	}

	public void setCart(List<Item> cart) {
		this.cart = cart;
	}
	
	public void addItemToCart(Item item) {
		this.cart.add(item);
	}
}
