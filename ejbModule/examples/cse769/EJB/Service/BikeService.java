package examples.cse769.EJB.Service;

import javax.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.Entity.*;

@Stateless
public class BikeService {
@PersistenceContext(unitName="examples-769-EJB")

EntityManager manager;

public boolean insertBike(BikeEntity b )
{
	BikeEntity bike=new BikeEntity();
	bike.setName(b.getName());
	bike.setDescription(b.getDescription());
	bike.setCondition(b.getCondition());
	bike.setDailyprice(b.getDailyprice());
	bike.setDamagefee(b.getDamagefee());
	bike.setLatefee(b.getLatefee());
	
	try{
	manager.persist(bike);
	manager.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true; //success
}

public boolean updateBikePrice(int id,double daily)
{
	BikeEntity bike=manager.find(BikeEntity.class, id);
	bike.setDailyprice(daily);
	
	try{
	manager.merge(bike);
	manager.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true;
}

public boolean updateBikeCondition(int id, int condition)
{
	BikeEntity bike=manager.find(BikeEntity.class, id);
	bike.setCondition(condition);
	try{
	manager.merge(bike);
	manager.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true;
}

public boolean deleteBike(int id)
{
	BikeEntity bike=manager.find(BikeEntity.class, id);
	try{
	manager.remove(bike);
	manager.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true;
}

public BikeEntity serachBikeById(int id)
{
	BikeEntity bike=manager.find(BikeEntity.class, id);
	return bike;
}

public ArrayList<BikeEntity> searchBikeByCondition(int condition)
{
	ArrayList<BikeEntity> bikes=new ArrayList<BikeEntity>();
	String sql="select * from bike where condition='"+condition+"'";
	Query query=manager.createQuery(sql);
	List<BikeEntity> list=query.getResultList();
	
	for(int i=0;i<list.size();i++)
	{
		BikeEntity bike=list.get(i);
		
		bikes.add(bike);
	}
	return bikes;	
}

/*public ArrayList<BikeEntity> searchBike(String name, double price)
{
	ArrayList<BikeEntity> bikes=new ArrayList<BikeEntity>();
	//if(name.isEmpty())
}
*/

}
