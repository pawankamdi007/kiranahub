package KiranaHub.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import KiranaHub.entity.Cart;
import KiranaHub.entity.Category;
import KiranaHub.entity.Customer;
import KiranaHub.entity.Inventory;
import KiranaHub.entity.Register;
import KiranaHub.entity.Transaction;

@Repository	
public class AdminDaoImp implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void register(Register register) {
		
			Session session =sessionFactory.getCurrentSession();
			
			session.save(register);
			
	}

	@Transactional
	public void addItem(Inventory inventory) {
		Session session =sessionFactory.getCurrentSession();	
		session.saveOrUpdate(inventory);
		
	}
	
	@Transactional
	public boolean adminlogin(Register register) {
		Session session=sessionFactory.getCurrentSession();
		boolean userFound=false;
		String sql="from Register rg where rg.email=? and rg.password=?";
		
		Query query=session.createQuery(sql,Register.class);
		query.setParameter(0, register.getEmail());
		query.setParameter(1, register.getPassword());
		
		List list=query.list();
		
		if ((list!=null) && (list.size()>0)) {
			userFound=true;
		}
		
		return userFound;
	}
	
	@Transactional
	public void addCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		
	}
	
	@Transactional
	public List<Category> getAllCategory() {
		Session session= sessionFactory.getCurrentSession();
		Query query=sessionFactory.getCurrentSession().createQuery("from Category");
		List<Category> addCategories=query.list();
		return addCategories;

	}
		
	@Transactional
	public Category getUpdateCategory(int id) {
		Session session= sessionFactory.getCurrentSession();
		Category updatecategory=session.byId(Category.class).load(id);
		return updatecategory;
	}
	
	@Transactional
	public void deleteCategory(int id) {
		Session session= sessionFactory.getCurrentSession();
		Category updatecategory=session.byId(Category.class).load(id);
		session.delete(updatecategory);
	}

	@Transactional
	public List<Inventory> getAllItems() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Inventory", Inventory.class);
		List<Inventory> inventory=query.getResultList();
		return inventory;
	}
	
	@Transactional
	public Inventory getUpdateItem(int id) {
		Session session=sessionFactory.getCurrentSession();
		Inventory updateItem=session.byId(Inventory.class).load(id);
		return updateItem;
	}
	
	@Transactional
	public void deleteItem(int id) {
		Session session= sessionFactory.getCurrentSession();
		Inventory inventory=session.byId(Inventory.class).load(id);
		session.delete(inventory);
		
	}
	
	@Transactional
	public List<Inventory> searchItemByCategory(String category) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Inventory i where i.category=?");
		query.setParameter(0, category);
		
		List<Inventory> allItemsBySearch=query.getResultList();
		System.out.println(allItemsBySearch);
		return allItemsBySearch;
	}
	
	@Transactional
	public List<Inventory> searchItemByPrice(String itemPrice) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Inventory i where i.price=?");
		query.setParameter(0, itemPrice);
		
		List<Inventory> allItemsByPrice=query.getResultList();
		
		return allItemsByPrice;
		
	}

	@Transactional
	public List<Inventory> searchItemByCategoryAndPrice(String category, String price) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Inventory i where i.category=? and i.price=?");
		query.setParameter(0, category);
		query.setParameter(1, price);
		
		List<Inventory> allItemsByPrice=query.getResultList();
		
		return allItemsByPrice;
		
	}

	
	@Transactional
	public void addToCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		
		session.save(cart);
		
	}

	@Transactional
	public List<Cart> getAllItemsFromCart() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cart", Cart.class);
		List<Cart> cartItems=query.getResultList();
		
		return cartItems;
	}

	@Transactional
	public void removeItem(int id) {
		Session session=sessionFactory.getCurrentSession();
		Cart item=session.byId(Cart.class).load(id);
		session.delete(item);
		
	}
	
	@Transactional
	public void addCustomer(Customer theCustomer) {
		Session session=sessionFactory.getCurrentSession();	
		session.saveOrUpdate(theCustomer);
		
	}
	
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer",Customer.class);
		List<Customer> theCustomer=query.getResultList();

		return theCustomer;
	}
	
	@Transactional
	public void pay(int id, String totalAmount, String paidAmount, int balanceAmount) {
		
		Session session= sessionFactory.getCurrentSession();
		
		String status;
		
		Transaction transaction=new Transaction();
		transaction.setTotalAmount(totalAmount);
		transaction.setPaidAmount(paidAmount);
		transaction.setBalanceAmount(balanceAmount);
		
		if (balanceAmount == 0) {
			status = "paid";
		}
		else {
			status="pending";
		}
		
		transaction.setStatus(status);
		
		Customer customer=session.get(Customer.class, id);
	
		
		  customer.getTransaction().add(transaction);
		  
		  transaction.setCustomer(customer);
		  
		  session.save(transaction);
		 
		}
	
	@Transactional
	public List<Transaction> getAllTransaction() {
		
		Session session=sessionFactory.getCurrentSession();
		Query<Transaction> query=session.createQuery("from Transaction",Transaction.class);
		List<Transaction> transaction=query.getResultList();
		
		return transaction;
	}

	@Transactional
	public Transaction getTransaction(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Transaction transaction=session.byId(Transaction.class).load(id);
		
		return transaction;
	}

		



}
