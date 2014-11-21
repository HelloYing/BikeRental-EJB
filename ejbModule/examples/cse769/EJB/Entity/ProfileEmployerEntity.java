package examples.cse769.EJB.Entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "PROFILEEMPLOYER")
public class ProfileEmployerEntity implements Serializable{
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
	


	@Column(name="DOMAIN")
	private String domain;


	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}


	@Column(name="COMPANY")
	private String company;
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}


	@Column(name="TECHNOLOGY")
	private String technology;
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	@Column(name="USER")
	private String user;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	
}
