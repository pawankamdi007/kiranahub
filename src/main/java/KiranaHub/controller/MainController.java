package KiranaHub.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import KiranaHub.dao.AdminDao;
import KiranaHub.entity.Cart;
import KiranaHub.entity.Category;
import KiranaHub.entity.Customer;
import KiranaHub.entity.Inventory;
import KiranaHub.entity.Register;
import KiranaHub.entity.Transaction;


@Controller
public class MainController {

	@Autowired
	private AdminDao adminDao;

	@GetMapping("index")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("homepage");
		Register register = new Register();
		modelAndView.addObject("register", register);
		return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		Register register = new Register();
		modelAndView.addObject("register", register);
		return modelAndView;
	}

	@PostMapping("adminlogin")
	public ModelAndView adminlogin(@ModelAttribute("register") Register register) {

		ModelAndView modelAndView = new ModelAndView("login");
		boolean status = adminDao.adminlogin(register);

		if (status) {
			modelAndView.setViewName("index");

		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("msg", "Email and Password are invalid");
		}

		return modelAndView;
	}

	@GetMapping("goToRegister")
	public ModelAndView goToRegister() {
		ModelAndView modelAndView = new ModelAndView("register");
		Register register = new Register();
		modelAndView.addObject("register", register);
		return modelAndView;
	}

	@PostMapping("register")
	public ModelAndView register(@ModelAttribute("register") Register register) {
		ModelAndView modelAndView = new ModelAndView("index");
		adminDao.register(register);
		modelAndView.addObject("register", register);
		return modelAndView;
	}

	@GetMapping("goToAddItem")
	public ModelAndView goToAddItem() {
		ModelAndView modelAndView = new ModelAndView("additem");
		Inventory inventory = new Inventory();
		modelAndView.addObject("inventory", inventory);

		List<Category> addCategories = adminDao.getAllCategory();
		modelAndView.addObject("addCategories", addCategories);
		return modelAndView;
	}

	@GetMapping("goToAllItem")
	public ModelAndView goToAllItem() {
		Inventory inventory = new Inventory();
		ModelAndView modelAndView = new ModelAndView("allitems");
		List<Inventory> allItems = adminDao.getAllItems();
		modelAndView.addObject("allItems", allItems);
		for (Inventory a : allItems) {
			System.out.println(a.getItemName());
		}
		return modelAndView;
	}

	@GetMapping("goToStock")
	public ModelAndView goToStock() {
		Inventory inventory = new Inventory();
		ModelAndView modelAndView = new ModelAndView("stock");
		List<Inventory> allItems = adminDao.getAllItems();
		modelAndView.addObject("allItems", allItems);

		return modelAndView;
	}

	@PostMapping("addItem")
	public String addItem(@ModelAttribute("inventory") Inventory inventory) {
		ModelAndView modelAndView = new ModelAndView();
		adminDao.addItem(inventory);
		modelAndView.addObject("inventory", inventory);
		return "redirect:/goToAllItem";
	}

	@GetMapping("category")
	public ModelAndView category() {
		ModelAndView modelAndView = new ModelAndView("category");
		Category category = new Category();
		modelAndView.addObject("category", category);
		return modelAndView;
	}

	@GetMapping("goToAllCategory")
	public ModelAndView goToAllCategory() {
		ModelAndView modelAndView = new ModelAndView("allcategory");
		List<Category> allCategory = adminDao.getAllCategory();
		modelAndView.addObject("allCategory", allCategory);
		return modelAndView;
	}

	@PostMapping("addcategory")
	public String addCategory(@ModelAttribute("category") Category category) {

		adminDao.addCategory(category);

		return "redirect:/goToAllCategory";
	}

	@GetMapping("goToUpdateCategory")
	public ModelAndView goToUpdateCategory(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("updatecategory");
		Category mycategory = adminDao.getUpdateCategory(id);
		modelAndView.addObject("mycategory", mycategory);
		System.out.println(mycategory.getCategory());
		return modelAndView;
	}

	@GetMapping("deleteCategory")
	public String deleteCategory(@RequestParam("id") int id) {

		adminDao.deleteCategory(id);
		return "redirect:/goToAllCategory";
	}

	@GetMapping("goToUpdateItem")
	public ModelAndView goToUpdateItem(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("updateItem");
		Inventory myItems = adminDao.getUpdateItem(id);
		modelAndView.addObject("myItems", myItems);
		System.out.println(myItems.getItemName());
		return modelAndView;
	}

	@GetMapping("deleteItem")
	public String deleteItem(@RequestParam("id") int id) {

		adminDao.deleteItem(id);
		return "redirect:/goToAllItem";
	}

	@GetMapping("logout")
	public ModelAndView logout() {

		Register register = new Register();
		ModelAndView modelAndView = new ModelAndView("login");

		modelAndView.addObject("register", register);

		return modelAndView;
	}

	@PostMapping("goToSearchItems")
	public ModelAndView goToSearchItems(@RequestParam("category") String category,
			@RequestParam("price") String price) {

		ModelAndView modelAndView = new ModelAndView("allitems");
		// yep age konsa hai?

		if(category.length()>0 && price.length()>0) {
			List<Inventory> allItems = adminDao.searchItemByCategoryAndPrice(category,price);
			modelAndView.addObject("allItems", allItems);
			
		}
		else if (category.length() > 0) {

			List<Inventory> allItems = adminDao.searchItemByCategory(category);
			modelAndView.addObject("allItems", allItems);

		}

		  else if (price.length()>0) {
		  
		  List<Inventory> allItems = adminDao.searchItemByPrice(price);
		  modelAndView.addObject("allItems",allItems);
		  
		  }
		  
		  else {
		  
		  List<Inventory> allItems = adminDao.getAllItems();
		  modelAndView.addObject("allItems", allItems); }
		  
		 

		System.out.println(category);

		return modelAndView;

	}
	
	@GetMapping("goToAddToCart")
	public String goToAddToCart(@RequestParam("id")int id) {
		
		Inventory myItems = adminDao.getUpdateItem(id);
		Cart cart=new Cart();
		cart.setItemName(myItems.getItemName());
		cart.setBrandName(myItems.getBrandName());
		cart.setCategory(myItems.getCategory());
		cart.setQuantity(myItems.getQuantity());
		cart.setPrice(myItems.getPrice());
		
		
		System.out.println(cart.getItemName());
		
		adminDao.addToCart(cart);
		
		return "redirect:/goToAllItem";
	}
	
	
	@GetMapping("goToCart")
	public ModelAndView goToCart() {
		Cart cart = new Cart();
		ModelAndView modelAndView = new ModelAndView("cart");
		List<Cart> allItems = adminDao.getAllItemsFromCart();
		modelAndView.addObject("allItems", allItems);
		for (Cart a : allItems) {
			System.out.println(a.getItemName());
		}
		return modelAndView;
	}
	
	
	@GetMapping("deleteCartItem")
	public String deleteCartItem(@RequestParam("id")int id) {
		adminDao.removeItem(id);
		
		return "redirect:/goToCart";
	}
	
	@GetMapping("goToAddCustomer")
	public ModelAndView goToAddCustomer() {
		ModelAndView modelAndView =new ModelAndView("addcustomer");
		Customer customer=new Customer();
		modelAndView.addObject("customer",customer);
		
		return modelAndView;	
	}
	
	@PostMapping("addCustomer")
	public String addCustomer(@ModelAttribute("customer")Customer theCustomer) {
		
		adminDao.addCustomer(theCustomer);
			
		return "homepage";
	}
	
	@GetMapping("goToAllCustomer")
	public ModelAndView goToAllCustomer() {
		ModelAndView modelAndView =new ModelAndView("allcustomers");
		
		List<Customer> allcustomer=adminDao.getAllCustomer();
		
		modelAndView.addObject("allcustomer",allcustomer);
		
		return modelAndView;	
	}
	
	@GetMapping("goToPay")
	public ModelAndView goToPay(@RequestParam("id") int id) {
		ModelAndView modelAndView=new ModelAndView("pay");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@PostMapping("pay")
	public ModelAndView pay(@RequestParam("id") int id,
			@RequestParam("totalAmount") String totalAmount, 
			@RequestParam("paidAmount") String paidAmount, 
			@RequestParam("balanceAmount") int balanceAmount ) {
		
		ModelAndView modelAndView=new ModelAndView("index");
		Register register=new Register();
		modelAndView.addObject("register", register);
		
		
		
		adminDao.pay(id, totalAmount, paidAmount, balanceAmount);
		
		System.out.println("hello");
		return modelAndView;
	}
	
	@GetMapping("goToAllTrasaction")
	public ModelAndView allTransaction() {
		ModelAndView modelAndView=new ModelAndView("alltransaction");
		List<Transaction> transaction=adminDao.getAllTransaction();
		
		for(Transaction a:transaction) {
			System.out.println(a.getTid());
		}
		modelAndView.addObject("transaction", transaction);
		return modelAndView;
	}
	
	@GetMapping("downloadPDF")
	public ModelAndView downloadExcel(@RequestParam("id") int id) {
		
		Transaction transaction = adminDao.getTransaction(id);
		
		return new ModelAndView("pdfView","transaction",transaction);
		
	}

	

}
