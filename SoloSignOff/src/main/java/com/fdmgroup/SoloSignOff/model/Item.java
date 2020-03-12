package com.fdmgroup.SoloSignOff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
@NamedQueries({ @NamedQuery(name = "itemFindAll", query = "SELECT u FROM Item u"),
	@NamedQuery(name = "itemFindByName", query = "SELECT u FROM Item u WHERE u.itemName = :itemName"),
 })
public class Item {
	
	@Id
	@Column(name = "ITEM_ID", length = 4, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_gen")
	@SequenceGenerator(name = "item_id_gen", sequenceName = "item_id_seq", allocationSize = 1)
	private int itemId;
	
	@Column(name = "ITEM_NAME", length = 30, nullable = false, unique = true)
	private String itemName;
	
	@Column(name = "DESCRIPTION", length = 100, nullable = false)
	private String description;
	
	@Column(name = "PRICE", length = 10, nullable = false)
	private int price;
	
	@Column(name = "QUANTITY", length = 10, nullable = false)
	private int quantity;

	
	public Item(int itemId, String itemName, String description, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
}
