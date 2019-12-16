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
	
	@Column
	private User user;
	
	@Column
	private Date startDate;
	
	@Column
	private Date finishDate;
	
	@Column
	private ApartamentClass apartamentClass;
	
	@Column
	private Number number;
	
	@Column
	private Status status;
	

	public Order() {
	}

	public Order(int id, User user, Date startDate, Date finishDate, ApartamentClass apartamentClass, Number number,
			Status status) {
		this.id = id;
		this.user = user;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.apartamentClass = apartamentClass;
		this.number = number;
		this.status = status;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", startDate=" + startDate + ", finishDate=" + finishDate
				+ ", apartamentClass=" + apartamentClass + ", number=" + number + ", status=" + status + "]";
	}
	
	
	
}
