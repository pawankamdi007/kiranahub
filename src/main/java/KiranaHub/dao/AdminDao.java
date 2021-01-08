package KiranaHub.dao;

import java.util.List;

import KiranaHub.entity.Cart;
import KiranaHub.entity.Category;
import KiranaHub.entity.Customer;
import KiranaHub.entity.Inventory;
import KiranaHub.entity.Register;

public interface AdminDao {

	void register(Register register);
	
	void addItem(Inventory inventory);
	
	boolean adminlogin(Register register);
	
	void addCategory(Category category);
	
	List<Category> getAllCategory();

	Category getUpdateCategory(int id);

	void deleteCategory(int id);

	List<Inventory> getAllItems();

	Inventory getUpdateItem(int id);

	void deleteItem(int id);

	List<Inventory> searchItemByCategory(String category);

	List<Inventory> searchItemByPrice(String itemPrice);

	List<Inventory> searchItemByCategoryAndPrice(String category, String price);


	void addToCart(Cart cart);

	List<Cart> getAllItemsFromCart();

	void removeItem(int id);

	void addCustomer(Customer theCustomer);

	List<Customer> getAllCustomer();
}
