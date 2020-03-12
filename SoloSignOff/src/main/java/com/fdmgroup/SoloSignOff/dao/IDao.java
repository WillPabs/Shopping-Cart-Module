package com.fdmgroup.SoloSignOff.dao;

import java.util.List;

public interface IDao<T> {

	boolean add(T t);
	T get(int id);
	boolean update(T t);
	boolean remove(int id);
	public List<T> list();

}
