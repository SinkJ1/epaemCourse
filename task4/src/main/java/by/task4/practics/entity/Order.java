package by.task4.practics.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "sDate")
	private String startDate;
	
	@Column(name = "fDate")
	private String finishDate;
	
	@Column(name = "apartament_class")
	private ApartamentClass apartamentClass;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "number_id")
	private Number number;
	
	@Column(name = "place_count")
	private PlaceCount desiredPlaceCount;
	
	@Column(name = "order_status")
	private Status status;
	
	@Column(name = "cost")
	private double cost;
	

	public Order() {
	}

	
	public Order(int id, User user, String startDate, String finishDate, ApartamentClass apartamentClass, Number number,
			Status status,PlaceCount desiredPlaceCount, double cost) {
		this.id = id;
		this.user = user;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.apartamentClass = apartamentClass;
		this.number = number;
		this.status = status;
		this.cost = cost;
		this.desiredPlaceCount = desiredPlaceCount;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
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


	public PlaceCount getDesiredPlaceCount() {
		return desiredPlaceCount;
	}


	public void setDesiredPlaceCount(PlaceCount desiredPlaceCount) {
		this.desiredPlaceCount = desiredPlaceCount;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", startDate=" + startDate + ", finishDate=" + finishDate
				+ ", apartamentClass=" + apartamentClass + ", number=" + number + ", desiredPlaceCount="
				+ desiredPlaceCount + ", status=" + status + ", cost=" + cost + "]";
	}

	
}
