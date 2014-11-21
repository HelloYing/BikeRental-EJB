package examples.cse769.EJB.Entity;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="Rent")
public class RentEntity {
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
	
	@Column(name="datebin")
	private Date datebegin;
	public Date getDatebegin()
	{
		return this.datebegin;
	}
	public void setDatebegin(Date d)
	{
		this.datebegin=d;
	}
	
	@Column(name="dateend")
	private Date dateend;
	public Date getDateend()
	{
		return this.dateend;
	}
	public void setDateend(Date d)
	{
		this.dateend=d;
	}
	
	@Column(name="price")
	private double price;
	public double getPrice()
	{
		return this.price;
	}
	public void setPrice(double p)
	{
		this.price=p;
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
	
	@Column(name="userid")
	private int userid;
	public int getUserid()
	{
		return this.userid;
	}
	public void setUserid(int u)
	{
		this.userid=u;
	}
	
	@Column(name="bikeid")
	private int bikeid;
	public int getBikeid()
	{
		return this.bikeid;
	}
	public void setBikeid(int i)
	{
		this.bikeid=i;
	}
	
	@Column(name="cash")
	private double cash;
	public double getCash()
	{
		return this.cash;
	}
	public void setCash(double c)
	{
		this.cash=c;
	}
	
	@Column(name="point")
	private int point;
	public int getPoint()
	{
		return this.point;
	}
	public void setPoint(int p)
	{
		this.point=p;
	}
	
	@Column(name="createtime")
	private Date createtime;
	public Date getCreateTime()
	{
		return this.createtime;
	}
	public void setCreateTime(Date c)
	{
		this.createtime=c;
	}
	
	@Column(name="confirmnum")
	private String confirmnum;
	public String getConfirmnum()
	{
		return this.confirmnum;
	}
	
	public void setConfirmnum(String c)
	{
		this.confirmnum=c;
	}
}
