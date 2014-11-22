package examples.cse769.EJB.Entity;

import javax.persistence.*;

@Entity
@Table(name = "price")

public class Price {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="daily")
	private double daily;
	public double getDaily() {return daily;}

	public void setDaily(double daily) { this.daily = daily;}
	
	
	@Column(name="monthly")
	private double monthly;
	public double getMonthly() {return monthly;}

	public void setMonthly(double monthly) { this.monthly = monthly;}
	
	@Column(name="annual")
	private double annual;
	public double getAnnual() {return annual;}

	public void setAnnual(double annual) { this.annual = annual;}
	
	@Column(name="fine")
	private double fine;
	public double getFine() {return fine;}

	public void setFine(double fine) { this.fine = fine;}

}
