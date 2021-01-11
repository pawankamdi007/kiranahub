package KiranaHub.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transaction")
public class Transaction{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String totalAmount;
	private String status;
	private int balanceAmount;
	private String paidAmount;
	private String currentBalanceAmount;
	@CreationTimestamp
	private LocalDateTime created;
	
	
	
	  @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,
	  CascadeType.REFRESH})
	  
	  @JoinColumn(name="customer_id")
	  private Customer customer;
	 	 
	
	public Transaction() {
		super();
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getCurrentBalanceAmount() {
		return currentBalanceAmount;
	}

	public void setCurrentBalanceAmount(String currentBalanceAmount) {
		this.currentBalanceAmount = currentBalanceAmount;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	
	  public Customer getCustomer() { 
		  return customer; 
		  }
	  
	  public void setCustomer(Customer customer) {
		  this.customer = customer; 
		  }
	 

	

	
}
