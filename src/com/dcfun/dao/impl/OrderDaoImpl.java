package com.dcfun.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dcfun.dao.OrderDao;
import com.dcfun.domain.Book;
import com.dcfun.domain.Order;
import com.dcfun.domain.OrderItem;
import com.dcfun.domain.User;
import com.dcfun.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.OrderDao#add(com.dcfun.domain.Order)
	 */
	public void add(Order order){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			//1����order�Ļ�����Ϣ���浽order��
			String sql = "insert into orders(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
			Object params[] = {order.getId(), order.getOrdertime(),order.getPrice(), order.isState(), order.getUser().getId()};
			runner.update(sql, params);
			
			//2����order�еĶ�����浽orderitem��
			Set<OrderItem> set = order.getOrderitems();
			for (OrderItem item : set) {
				sql = "insert into orderitem(id,quantity,price,book_id,order_id) values(?,?,?,?,?)";
				params = new Object[]{item.getId(), item.getQuantity(), item.getPrice(), item.getBook().getId(), order.getId()};
				runner.update(sql, params);				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.OrderDao#find(java.lang.String)
	 */
	public Order find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			//1���ҳ������Ļ�����Ϣ
			String sql = "select * from orders where orders.id=?";
			Order order = (Order) runner.query(sql, id, new BeanHandler(Order.class));
			
			//2���ҳ������е����ж�����
			sql = "select * from orderitem where order_id=?";
			List<OrderItem> list = (List<OrderItem>) runner.query(sql, id, new BeanListHandler(OrderItem.class));
			for (OrderItem orderItem : list) {
				sql = "select book.* from orderitem,book where orderitem.id=? and orderitem.book_id=book.id";
				Book book = (Book) runner.query(sql, orderItem.getId(), new BeanHandler(Book.class));
				orderItem.setBook(book);
			}
			order.getOrderitems().addAll(list);			//���ҳ��Ķ�����Ž�order
			
			//3�����������ĸ��û�
			sql = "select * from orders,user where orders.id=? and orders.user_id=user.id";
			User user = (User) runner.query(sql, id, new BeanHandler(User.class));
			order.setUser(user);
			
			return order;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.OrderDao#getAll(boolean)
	 */
	public List<Order> getAll(boolean state){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=?";
			List<Order> list = (List<Order>) runner.query(sql, state, new BeanListHandler(Order.class));
			for (Order order : list) {
				sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
				User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);					
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.dcfun.dao.impl.OrderDao#update(com.dcfun.domain.Order)
	 */
	public void update(Order order){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set state=? where id=?";
			Object params[] = {order.isState(), order.getId()};
			runner.update(sql, params);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
