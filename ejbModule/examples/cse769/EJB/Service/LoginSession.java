package examples.cse769.EJB.Service;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class LoginSession {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public String userName(String name, String password, String type) {	//method called from LoginBean Backing Bean
		
		List<HelloServiceEntity> loginList;		//create list to hold query results
	
		try
		{
			Query query = em.createNativeQuery	//create query using this syntax
			("select * from MESSAGETABLE where USERNAME like '" + name
			+ "'" +  " AND "+ "TYPE like '" + type + "'" + " and PASSWORD like '" + password + "'" 
			, HelloServiceEntity.class);
			
			loginList = query.getResultList();	//gets results from query and puts into a list of that object type
			
			if(!loginList.isEmpty())			//if user actually exists
			{
				return "success";
			}
		}
		
		catch(Exception e)
		{
			return "fail";
		}
		
		return "fail";	//return fail if user not found and handle appropriately in Backing Bean
	}	
	
}
