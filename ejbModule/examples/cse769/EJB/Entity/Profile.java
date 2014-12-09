package examples.cse769.EJB.Entity;
import java.io.*;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "PROFILE")
public class Profile{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	
	@Column(name="PEOPLEID")
	private int peopleId;
	
	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}
	
	@Column(name="EMAIL")
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="FIRSTNAME")
	private String firstname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="LASTNAME")
	private String lastname;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name="GENDER")
	private int gender;	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}


	@Column(name="PHONE")
	private String phone;	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="BIRTHDAY")
	private Date birthday;	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Column(name="ADDRESS")
	private String address;	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="TYPE")
	private String type;	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
}
