package examples.cse769.EJB.Service;

import java.sql.Date;
import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

import examples.cse769.EJB.Entity.*;;
@Stateless
public class RentService {
@PersistenceContext(unitName="examples-769-EJB")

EntityManager manager;

public RentService(){}

public boolean updateRent(int id,double latefee,double damagefee)
{
	RentEntity rent=manager.find(RentEntity.class, id);
	rent.setDamagefee(damagefee);
	rent.setLatefee(latefee);
	int userid=rent.getUserid();
	try{
	manager.merge(rent);
	manager.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	return true;
}

public boolean searchAvailableBike(int id, Date binDate, Date endDate){

	//String sql="select * from bike";
	//Query query=manager.createNativeQuery(sql, BikeEntity.class);	
	return true;
/*	Query query=manager.createNativeQuery("select * from rent where bikeid="+id, RentEntity.class);
		if(query==null || query.getResultList().isEmpty()){
		return true;
	}
	List<RentEntity> list=query.getResultList();
	for(RentEntity rent: list){
		if(!(rent.getDatebegin().after(endDate) || rent.getDateend().before(binDate))){
			return false;
		}
	}
	return true;*/
}

public String insert(int peopleId, int bikeId, double price, Date binDate, Date endDate){
	PeopleService peopleService=new PeopleService();
	String cn="";
	if(peopleService.updatePoint(peopleId, (int)price)){
		RentEntity rentEntity=new RentEntity();
		rentEntity.setBikeid(bikeId);
		rentEntity.setCash(0);
		rentEntity.setPrice(price);
		rentEntity.setDatebegin(binDate);
		rentEntity.setDateend(endDate);
		rentEntity.setLatefee(0);
		rentEntity.setDamagefee(0);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		rentEntity.setCreateTime(d);
		cn="U"+peopleId+"B"+bikeId+d.toString();
		rentEntity.setConfirmnum(cn);
		rentEntity.setUserid(peopleId);
		rentEntity.setPoint((int) price);
		try{
			manager.persist(rentEntity);
			manager.flush();
		}catch(Exception e){
			return "Database access failed.";
		}
	}else{
		cn="Database access failed.";
	}	
	return cn;
}

}
