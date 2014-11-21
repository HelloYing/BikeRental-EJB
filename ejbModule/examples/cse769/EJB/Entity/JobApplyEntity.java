package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "JOBAPPLY")
public class JobApplyEntity implements Serializable{
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
	
	
	@Column(name="LOCATION")
	private String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Column(name="PAY")
	private String pay;
	
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}


	@Column(name="TITLE")
	private String title;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
	
	@Column(name="USER")
	private String user;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	
}
