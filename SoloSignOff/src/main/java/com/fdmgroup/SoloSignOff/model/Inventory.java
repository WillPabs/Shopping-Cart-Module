package com.fdmgroup.SoloSignOff.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	
	private Map<Item, Integer> inventory = new HashMap<Item,Integer>();

	public Inventory(Map<Item, Integer> inventory) {
		super();
		this.inventory = inventory;
	}

	public Map<Item, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(Map<Item, Integer> inventory) {
		this.inventory = inventory;
	}

	
}
