package examples.cse769.EJB.Service;

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
		people.setPoint(1000);

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
	
	public People searchUserByEmail(String email)
	{
		Query query=em.createNativeQuery("select * from people where email= '"+email+"'", People.class);
		List<People> list=query.getResultList();
		//will only get one people result for one email
		People p=list.get(0);
		return p;
	}
	
	public boolean updatePoint(int id, int point)
	{
		People people=em.find(People.class, id);
		int ori=people.getPoint();
		people.setPoint(ori-point);	
		try{
		em.merge(people);
		em.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int[] search(String email, String password){
		int[] res=new int[3];
		Query query=null;
		try{
			query=em.createNativeQuery("select * from people where email='"+email+"' and password='"+password+"'", People.class);
		}catch(Exception e){
			res[0]=0;
		}
		if(query.getResultList().isEmpty()){
			res[0]=0;
		}else{
			List<People> peopleList=query.getResultList();
			People people=peopleList.get(0);
			res[0]=people.getType();
			res[1]=people.getId();
			res[2]=people.getPoint();
		}
		return res;
	}

}

