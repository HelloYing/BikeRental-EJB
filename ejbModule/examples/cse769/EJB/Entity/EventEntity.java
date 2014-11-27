package examples.cse769.EJB.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "event")
public class EventEntity {

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
	
	@Column(name="address")
	private String address;
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String a)
	{
		this.address=a;
	}
	
}
