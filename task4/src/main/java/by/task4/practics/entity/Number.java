package by.task4.practics.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "t_number")
public class Number implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "number_id")
	private int id;
	
	@Column(name = "place_count")
	private int placeCount;
	
	@Column(name = "apartament_class")
	private ApartamentClass apartamentClass;
	
	@Column(name = "number_status")
	private Status numberStatus;
	
	@Column(name = "number_cost_by_day")
	private double numberCostByDay;
	
	public Number() {
		
	}
	

	public Number(int id, int placeCount, ApartamentClass apartamentClass, Status numberStatus,
			double numberCostByDay) {
		this.id = id;
		this.placeCount = placeCount;
		this.apartamentClass = apartamentClass;
		this.numberStatus = numberStatus;
		this.numberCostByDay = numberCostByDay;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlaceCount() {
		return placeCount;
	}

	public void setPlaceCount(int placeCount) {
		this.placeCount = placeCount;
	}

	public ApartamentClass getApartamentClass() {
		return apartamentClass;
	}

	public void setApartamentClass(ApartamentClass apartamentClass) {
		this.apartamentClass = apartamentClass;
	}

	public Status getNumberStatus() {
		return numberStatus;
	}

	public void setNumberStatus(Status numberStatus) {
		this.numberStatus = numberStatus;
	}

	public double getNumberCostByDay() {
		return numberCostByDay;
	}

	public void setNumberCostByDay(double numberCostByDay) {
		this.numberCostByDay = numberCostByDay;
	}


	@Override
	public String toString() {
		return "Number [id=" + id + ", placeCount=" + placeCount + ", apartamentClass=" + apartamentClass
				+ ", numberStatus=" + numberStatus + ", numberCostByDay=" + numberCostByDay + "]";
	}
	
	
	
	
}
