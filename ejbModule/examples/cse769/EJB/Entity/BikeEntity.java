package examples.cse769.EJB.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Bike")
public class BikeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	public int getId(){
		return this.id;
	}
	public void setId(int annId){
		this.id = annId;
	}
	
	@Column(name="priceid")
	private int priceid;
	
	public int getPriceid()
	{
		return this.priceid;
	}
	public void setPriceid(int price)
	{
		this.priceid=price;
	}
	
	@Column(name="condition")
	private int condition;
	public int getCondition()
	{
		return this.condition;
	}
	public void setCondition(int condition)
	{
		this.condition=condition;
	}
	
	
}
