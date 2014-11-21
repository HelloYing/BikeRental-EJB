package examples.cse769.EJB.Service;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;
import java.util.logging.*;


@Stateless
public class ProfileEmployer {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    

	public String profile(String company, String location, 
			String domain, String technology, String user) {
	   	
		ProfileEmployerEntity newEntity = new ProfileEmployerEntity();

		List<ProfileEmployerEntity> pee;
		Query query = em.createNativeQuery
				("select * from PROFILEEMPLOYER where USER like '" + user + "'" , 
						ProfileEmployerEntity.class);
		pee = query.getResultList();
		if(!pee.isEmpty())
		{
			
			Query query1 = em.createNativeQuery
					("update PROFILEEMPLOYER set company = " + "'" + company + "'" + " ," +
										 " location = " + "'" + location + "'" + " ," + 
										 " domain = " + "'" + domain + "'" + " ," + 
										 " technology = " + "'" + technology + "'" +
										 " where user like "  + "'" + user + "'"
							, ProfileEmployerEntity.class);
			
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
		else
		{
		

		newEntity.setCompany(company);
		newEntity.setLocation(location);
		newEntity.setDomain(domain);
		newEntity.setTechnology(technology);
		newEntity.setUser(user);
		
		try
		{
		em.persist(newEntity);
		em.flush();
		}
		catch(EntityExistsException e)
		{
			return "Exists";
		}
		
		catch(ConstraintViolationException e)
		{
			return "Exists";
		}
		
		catch(Exception e)
		{
			return "Exists";
		}
		}
		return "true";
	}
	
	
	
	public String[] firstProfile(String user)
	{
		 String[] results = new String[4];

		 String company = "";
		 String domain = "";
		 String location = "";
		 String technology = "";
		 
		List<ProfileEmployerEntity> pee;
		Query query = em.createNativeQuery
				("select * from PROFILEEMPLOYER where USER like '" + user + "'" , 
						ProfileEmployerEntity.class);
		pee = query.getResultList();
		if(!pee.isEmpty())
		{
			ProfileEmployerEntity hse = new ProfileEmployerEntity();
		hse = pee.get(0);
		
		 company = hse.getCompany();
		 domain = hse.getDomain();
		 location = hse.getLocation();
		 technology= hse.getTechnology();
		
		results[0] = company;
		results[1] = location;
		results[2] = technology;
		results[3] = domain;

		return results;

		
		}
		
		else 
			{
			results[0] = "no";
			return results;

			}
	
	}
}
