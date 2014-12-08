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
	public void setId(int Id){
		this.id = Id;
	}
	
	@Column(name="type")
	private String type;
	public String getType()
	{
		return this.type;
	}
	public void setType(String t)
	{
		this.type=t;
	}
	
	@Column(name="name")
	private String name;
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	
	@Column(name="description")
	private String description;
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String d)
	{
		this.description=d;
	}
	
	@Column(name="dailyprice")
	private double dailyprice;
	
	public double getDailyprice()
	{
		return this.dailyprice;
	}
	public void setDailyprice(double price)
	{
		this.dailyprice=price;
	}
	
	@Column(name="damagefee")
	private double damagefee;
	public double getDamagefee()
	{
		return this.damagefee;
	}
	public void setDamagefee(double d)
	{
		this.damagefee=d;
	}
	
	@Column(name="latefee")
	private double latefee;
	public double getLatefee()
	{
		return this.latefee;
	}
	public void setLatefee(double l)
	{
		this.latefee=l;
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
	
	@Column(name="editable")
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	private boolean editable;
	
	
	
	
}
