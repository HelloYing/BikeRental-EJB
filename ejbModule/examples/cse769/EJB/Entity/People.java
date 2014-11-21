package examples.cse769.EJB.Entity;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="email")
	private String email;
	public String getEmail() {return email;}

	public void setEmail(String email) { this.email = email;}
	
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}
	
	@Column(name="type")
	private int type;

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
