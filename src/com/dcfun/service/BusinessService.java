package com.dcfun.service;

import java.util.List;

import com.dcfun.domain.Category;

public interface BusinessService {

	/**添加分类**/
	public abstract void addCategory(Category category);

	/**查找分类**/
	public abstract Category findCategory(String id);

	/**得到所有分类**/
	public abstract List<Category> getAllCategory();

}