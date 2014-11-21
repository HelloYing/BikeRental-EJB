package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class HelloService {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public String userName(String name, String password, String type) {
		HelloServiceEntity newEntity = new HelloServiceEntity();
		

		newEntity.setUserName(name);
		newEntity.setPassword(password);
		newEntity.setType(type);
		newEntity.setTitle("");
		newEntity.setLocation("");
		newEntity.setPay("");
		newEntity.setTechnology("");


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
		String UserName = newEntity.getUserName();
		return "JobPortal" + "Name =" + UserName;
	}
	
	
	public String[] search(String userName) {	//change	
		 String[] results = new String[4];

		 String pay = "";
		 String title = "";
		 String location = "";
		 String technology = "";
		 
		List<HelloServiceEntity> ann;
		Query query = em.createNativeQuery
				("select * from MessageTable where USERNAME like '" + userName + "'" , 
						HelloServiceEntity.class);
		ann = query.getResultList();
		if(!ann.isEmpty())
		{
		HelloServiceEntity hse = new HelloServiceEntity();
		hse = ann.get(0);
		
		 pay = hse.getPay();
		 title = hse.getTitle();
		 location = hse.getLocation();
		 technology= hse.getTechnology();
		 //return un;

		
		results[0] = title;
		results[1] = location;
		results[2] = technology;
		results[3] = pay;

		return results;

		
		}
		
		else 
			{
			results[0] = "no";//change
			return results;

			}
	}
	
	
	
	public String update(String user, String title, String location, String pay, String technology) {
		
		
		List<HelloServiceEntity> ann;
		Query query = em.createNativeQuery
				("update MessageTable set title = " + "'" + title + "'" + " ," +
									 " location = " + "'" + location + "'" + " ," + 
									 " pay = " + "'" + pay + "'" + " ," + 
									 " technology = " + "'" + technology + "'" +
									 " where username like "  + "'" + user + "'"
						, HelloServiceEntity.class);
		
		try
		{
		query.executeUpdate();
		em.flush();

		}
		catch(Exception e)
		{
			return "fail";
		}
		
		return "success";
	
	}
	
	public List<List<String>> findCandidates(String title, String location, String pay, String technology) 	
	{
		 List<List<String>> candidates = new ArrayList<List<String>>();
		 String user = "";
		 String queryString = "select * from MessageTable where title like '" + title + "'" + " or " +
					"  location like "  + " '" + location + "' " + " or " + " pay like " + " '" + pay + "' "
					+ " or " + " technology like " + " '" + technology + "' ";
		 
		List<HelloServiceEntity> candidateList;
		Query query = em.createNativeQuery(queryString	, HelloServiceEntity.class);
		candidateList = query.getResultList();
		if(!candidateList.isEmpty())
		{
			int size = candidateList.size();
			
			for(int i = 0; i< size ; i++)
			{
				HelloServiceEntity hse = new HelloServiceEntity();
				hse = candidateList.get(i);
			
			title = hse.getTitle();
			location = hse.getLocation();
			pay = hse.getPay();
			technology = hse.getTechnology();
			user = hse.getUserName();
			List<String> candidate = new ArrayList<String>();

			candidate.add(title);
			candidate.add(location);
			candidate.add(pay);
			candidate.add(technology);
			candidate.add(user);
			
			candidates.add(candidate);
			}
			
			return candidates;
		
		}
		else return candidates;
	}
	
	
}
