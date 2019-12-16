package by.task4.practics.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@Column(name = "user_id")
	private User user;
	
	@Column(name = "sDate")
	private Date startDate;
	
	@Column(name = "fDate")
	private Date finishDate;
	
	@Column(name = "apartament_class")
	private ApartamentClass apartamentClass;
	
	@Column(name = "number_id")
	private Number number;
	
	@Column(name = "order_status")
	private Status status;
	
	@Column(name = "cost")
	private double cost;
	

	public Order() {
	}

	
	public Order(int id, User user, Date startDate, Date finishDate, ApartamentClass apartamentClass, Number number,
			Status status, double cost) {
		this.id = id;
		this.user = user;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.apartamentClass = apartamentClass;
		this.number = number;
		this.status = status;
		this.cost = cost;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public ApartamentClass getApartamentClass() {
		return apartamentClass;
	}

	public void setApartamentClass(ApartamentClass apartamentClass) {
		this.apartamentClass = apartamentClass;
	}

	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", startDate=" + startDate + ", finishDate=" + finishDate
				+ ", apartamentClass=" + apartamentClass + ", number=" + number + ", status=" + status + ", cost="
				+ cost + "]";
	}

	
}
