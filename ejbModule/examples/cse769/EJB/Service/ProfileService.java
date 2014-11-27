package examples.cse769.EJB.Service;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

import java.util.logging.*;


@Stateless
public class ProfileService {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    

	public String profile(int peopleId, String firstname, String lastname, 
			String phone, Date birthday, String address) {
			Query query1 = em.createNativeQuery
					("update PROFILE set firstname = " + "'" + firstname + "'" + " ," +
										 " lastname = " + "'" + lastname + "'" + " ," + 
										 " phone = " + "'" + phone + "'" + " ," + 
										 " birthday = " + birthday + "," +
										 " address = " + "'" + address + "'" + " ," +
										 " where peopleid= " + peopleId 
							, Profile.class);
			
			try
			{
			query1.executeUpdate();
			em.flush();

			}
			catch(Exception e)
			{
				return "fail";
			}
			
			return "true";		
	}
	
	public Profile search(int peopleId){
		Query query=em.createNativeQuery("select * from profile where peopleid="+peopleId, Profile.class);
		List<Profile> profiles=query.getResultList();
		Profile profile=profiles.get(0);
		return profile;
	}
	
	public boolean insert(int peopleId, String email){
		Profile profile=new Profile();
		profile.setPeopleId(peopleId);
		profile.setEmail(email);
		profile.setAddress("");
		profile.setFirstname("");
		profile.setLastname("");
		profile.setPhone("");
		@SuppressWarnings("deprecation")
		Date date=new Date(1985,6,20);
		profile.setBirthday(date);
		try{
			em.persist(profile);
			em.flush();
		}catch(Exception e){
			System.out.println("profile insert failed");
			return false;
		}
		System.out.println("profile insert success");
		return true;
	}
}
