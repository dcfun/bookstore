package com.dcfun.service;

import java.util.List;

import com.dcfun.domain.Category;

public interface BusinessService {

	/**��ӷ���**/
	public abstract void addCategory(Category category);

	/**���ҷ���**/
	public abstract Category findCategory(String id);

	/**�õ����з���**/
	public abstract List<Category> getAllCategory();

}