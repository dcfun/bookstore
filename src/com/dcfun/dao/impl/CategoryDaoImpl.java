package com.dcfun.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dcfun.dao.CategoryDao;
import com.dcfun.domain.Category;
import com.dcfun.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.CategoryDao#add(com.dcfun.domain.Category)
	 */
	public void add(Category category){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into category(id,name,description) values(?,?,?)";
			Object params[] = {category.getId(), category.getName(), category.getDescription()};
			runner.update(sql, params);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.CategoryDao#find(java.lang.String)
	 */
	public Category find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category where id=?";
			return (Category) runner.query(sql, id, new BeanHandler(Category.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.CategoryDao#getAll()
	 */
	public List<Category> getAll(){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category";
			return (List<Category>) runner.query(sql, new BeanListHandler(Category.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
