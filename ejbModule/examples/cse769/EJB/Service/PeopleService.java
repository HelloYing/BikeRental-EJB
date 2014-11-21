package examples.cse769.EJB.Service;

import javax.persistence.*;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class PeopleService {
	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	public String insert(String email, String password){
		if(!this.searchByEmail(email)){
			return "This emali has been used, please change a new one.";
		}
		
		People people=new People();
		people.setEmail(email);
		people.setPassword(password);
		people.setType(1);

		try{
			em.persist(people);
			em.flush();
		}catch(Exception e){
			return "Database can't access.";
		}
		return "Register success.";
	}
	
	public boolean searchByEmail(String email){
		Query query=null;
		try{
			query=em.createNativeQuery("select * from people where email='"+email+"'");
		}catch(Exception e){
			return false;
		}
		if(query.getResultList().isEmpty()){
			return true;
		}else{
			return false;
		}
	}

}

