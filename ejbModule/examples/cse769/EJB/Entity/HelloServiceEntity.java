package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "MessageTable")
public class HelloServiceEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ANNOUNCEMENTID")
	private long announcementId;
	
	public long getAnnouncementId(){
		return this.announcementId;
	}
	public void setAnnouncementId(long annId){
		this.announcementId = annId;
	}
	
	
	@Column(name="USERNAME")
	private String userName;
	public String getUserName() {return userName;}

	public void setUserName(String userName) { this.userName = userName;}
	
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}
	
	@Column(name="TYPE")
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="TITLE")
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="LOCATION")
	private String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}


	@Column(name="TECHNOLOGY")
	private String technology;
	
	@Column(name="PAY")
	private String pay;

	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	
}
