package com.dcfun.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dcfun.dao.BookDao;
import com.dcfun.dao.CategoryDao;
import com.dcfun.dao.OrderDao;
import com.dcfun.dao.UserDao;
import com.dcfun.domain.Book;
import com.dcfun.domain.Cart;
import com.dcfun.domain.CartItem;
import com.dcfun.domain.Category;
import com.dcfun.domain.Order;
import com.dcfun.domain.OrderItem;
import com.dcfun.domain.Page;
import com.dcfun.domain.User;
import com.dcfun.service.BusinessService;
import com.dcfun.utils.DaoFactory;
import com.dcfun.utils.WebUtils;

public class BusinessServiceImpl implements BusinessService {
	
	private CategoryDao dao = DaoFactory.getInstance().CreateDao("com.dcfun.dao.impl.CategoryDaoImpl", CategoryDao.class);
	private BookDao bdao = DaoFactory.getInstance().CreateDao("com.dcfun.dao.impl.BookDaoImpl", BookDao.class);
	private UserDao udao = DaoFactory.getInstance().CreateDao("com.dcfun.dao.impl.UserDaoImpl", UserDao.class);
	private OrderDao odao = DaoFactory.getInstance().CreateDao("com.dcfun.dao.impl.OrderDaoImpl", OrderDao.class);
	
	/*添加分类*/
	public void addCategory(Category category){
		dao.add(category);
	}
	
	/*查找分类*/
	public Category findCategory(String id){
		return dao.find(id);
	}
	
	/*得到所有分类*/
	public List<Category> getAllCategory(){
		return dao.getAll();
	}
	
	/*添加图书*/
	public void addBook(Book book){
		bdao.add(book);
	}

	/*查找图书*/
	public Book findBook(String id ){
		return bdao.find(id);
	}
	
	/*获取书的分页数据*/
	public Page getBookPageData(String pagenum){
		
		int totalrecord = bdao.getTotalRecord();
		Page page = null;
		
		if (pagenum == null) {
			page = new Page(1,totalrecord);
		}else {
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List list = bdao.getPageData(page.getStartindex(), page.getPagesize());
		page.setList(list);
		return page;
	}
	
	/*获取分类下面的分页数据*/
	public Page getBookPageData(String pagenum, String category_id){
		int totalrecord = bdao.getTotalRecord(category_id);
		Page page = null;
		
		if (pagenum == null) {
			page = new Page(1,totalrecord);
		}else {
			page = new Page(Integer.parseInt(pagenum), totalrecord);
		}
		List list = bdao.getPageData(page.getStartindex(), page.getPagesize(), category_id);
		page.setList(list);
		return page;		
		
		
	}

	public void buybook(Cart cart, Book book) {
		// TODO Auto-generated method stub
		cart.add(book);
	}
	
	//注册用户
	public void registerUser(User user){
		udao.add(user);
	}
	
	public User findUser(String id){
		return udao.find(id);
	}
	
	public User userLogin(String username, String password){
		return udao.find(username, password);
	}
	
	//生成订单
	public void createOrder(Cart cart, User user){
		if (cart==null) {
			throw new RuntimeException("对不起，您还没有购买商品");
		}

		Order order = new Order();
		order.setId(WebUtils.makeID());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		for(Map.Entry<String, CartItem> me : cart.getMap().entrySet()){
			CartItem citem = me.getValue();
			OrderItem oitem = new OrderItem();
			oitem.setBook(citem.getBook());
			oitem.setId(WebUtils.makeID());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			order.getOrderitems().add(oitem);
		}

		odao.add(order);
	}

	public List<Order> listOrder(String state) {

		return odao.getAll(Boolean.parseBoolean(state));
	}

	//列出订单明细
	public Order findOrder(String orderid) {

		return odao.find(orderid);
	}

	//管理员将订单置为发货状态
	public void confirmOrder(String orderid) {
		
		Order order = odao.find(orderid);
		order.setState(true);
		odao.update(order);		
	}
	
	
}
