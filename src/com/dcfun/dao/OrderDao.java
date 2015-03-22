package com.dcfun.dao;

import java.util.List;

import com.dcfun.domain.Order;

public interface OrderDao {

	public abstract void add(Order order);

	public abstract Order find(String id);

	public abstract List<Order> getAll(boolean state);

	public abstract void update(Order order);

}