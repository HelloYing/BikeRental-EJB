package examples.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.*;
import examples.cse769.EJB.Entity.*;;
@Stateless
public class RentService {
@PersistenceContext(unitName="examples-769-EJB")

EntityManager manager;

public boolean updateRent(int id,double latefee,double damagefee)
{
	RentEntity rent=manager.find(RentEntity.class, id);
	rent.setDamagefee(damagefee);
	rent.setLatefee(latefee);
	
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


}
