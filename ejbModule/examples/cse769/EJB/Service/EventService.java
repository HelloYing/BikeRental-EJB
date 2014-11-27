package examples.cse769.EJB.Service;
import javax.ejb.Stateless;
import javax.persistence.*;
import examples.cse769.EJB.Entity.*;
@Stateless
public class EventService {
@PersistenceContext(unitName="examples-769-EJB")
EntityManager manager;

public boolean insertEvent(EventEntity e)
{
	EventEntity activity=new EventEntity();
	activity.setName(e.getName());
	activity.setType(e.getType());
	activity.setDescription(e.getDescription());
	activity.setAddress(e.getAddress());
	
	try{
		manager.persist(activity);
		manager.flush();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
		return false;
	}
	return true;
}
}
