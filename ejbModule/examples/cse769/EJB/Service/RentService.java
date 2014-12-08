package examples.cse769.EJB.Service;

import java.sql.Date;
import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import examples.cse769.EJB.Entity.*;;
@Stateless
public class RentService {
@PersistenceContext(unitName="examples-769-EJB")

EntityManager manager;

public RentService(){}

public int updateRent(int id,double latefee,double damagefee)
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
		return -1;
	}
	
	return userid;
}

public RentEntity searchRentById(int id)
{
	RentEntity rent=manager.find(RentEntity.class, id);
	return rent;
}
public ArrayList<RentEntity> searchRentByBikeType(String type)
{
	ArrayList<RentEntity> rents=new ArrayList<RentEntity>();
	String sql="select c from RentEntity c where c.type = '"+type+"'";
	Query query=manager.createQuery(sql);
	List<RentEntity> list=query.getResultList();
	for(int i=0; i<list.size(); i++){
		RentEntity rent=list.get(i);
		rents.add(rent);
	}
	return rents;
}

public ArrayList<RentEntity> searchRentByDate(Date begin,Date end)
{
	ArrayList<RentEntity> rents=new ArrayList<RentEntity>();
	String sql="select c from RentEntity c where c.date between "+begin+" and "+end;
	Query query =manager.createQuery(sql);
	List<RentEntity> list=query.getResultList();
	for(int i=0;i<list.size();i++)
	{
		RentEntity rent=list.get(i);
		rents.add(rent);
	}
	return rents;
}

public ArrayList<RentEntity> searchRentByUser(String email)
{
	ArrayList<RentEntity> rents=new ArrayList<RentEntity>();
	String sql="select * from rent inner join people where people.id=rent.userid and people.email= '"+email+"' order by createtime desc";
	//Query query =manager.createQuery(sql);
	Query query=manager.createNativeQuery(sql, RentEntity.class);
	List<RentEntity> list=query.getResultList();
	for(int i=0;i<list.size();i++)
	{
		RentEntity rent=list.get(i);
		rents.add(rent);
	}
	return rents;
}

public String insert(int peopleId, int bikeId, double price, Date binDate, Date endDate){
	String cn="";
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
	return cn;
}

}
