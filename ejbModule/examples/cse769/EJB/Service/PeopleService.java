package examples.cse769.EJB.Service;

import java.util.ArrayList;
import java.util.List;

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
	
	public int[] search(String email, String password){
		int[] res=new int[2];
		List<People> peopleList=new ArrayList<People>();
		Query query=null;
		try{
			query=em.createNativeQuery("select * from people where email='"+email+"' and password='"+password+"'", People.class);
		}catch(Exception e){
			res[0]=0;
		}
		if(query.getResultList().isEmpty()){
			res[0]=0;
		}else{
			peopleList=query.getResultList();
			res[0]=peopleList.get(0).getType();
			res[1]=peopleList.get(0).getId();
		}
		return res;
	}

}

