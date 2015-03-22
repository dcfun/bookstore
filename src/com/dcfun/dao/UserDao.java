package com.dcfun.dao;

import com.dcfun.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User find(String id);

	public abstract User find(String username, String password);

}