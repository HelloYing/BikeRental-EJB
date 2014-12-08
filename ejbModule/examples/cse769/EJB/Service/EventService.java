package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

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
	activity.setDate(e.getDate());
	
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

public boolean updateEvent(EventEntity event)
{
	int id=event.getId();
	EventEntity e=manager.find(EventEntity.class, id);
	
	e.setName(event.getName());
	e.setType(event.getType());
	e.setDescription(event.getDescription());
	e.setDate(event.getDate());
	e.setAddress(event.getAddress());
	
	try{
		manager.merge(e);
		manager.flush();
	}catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	return true;
}

public boolean deleteEvent(int id)
{
	EventEntity event=manager.find(EventEntity.class,id);
	try{
		manager.remove(event);
		manager.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
}

public ArrayList<EventEntity> searchAllEvents()
{
	ArrayList<EventEntity> events=new ArrayList<EventEntity>();
	String sql="select c from EventEntity c order by c.date desc";
	Query query=manager.createQuery(sql);
	List<EventEntity> list=query.getResultList();
	for(int i=0; i<list.size(); i++){
		EventEntity event=list.get(i);
		events.add(event);
	}
	return events;
}

public ArrayList<EventEntity> searchEventByType(String type)
{
	ArrayList<EventEntity> events=new ArrayList<EventEntity>();
	String sql="select c from EventEntity c where c.type = '"+type+"' order by c.date desc";
	Query query=manager.createQuery(sql);
	List<EventEntity> list=query.getResultList();
	for(int i=0; i<list.size(); i++){
		EventEntity event=list.get(i);
		events.add(event);
	}
	return events;
}

public ArrayList<EventEntity> searchEventByDate(Date a,Date b)
{
	ArrayList<EventEntity> events=new ArrayList<EventEntity>();
	String sql="select c from EventEntity c where c.date between '"+a+"' and '"+b+"' order by c.date desc";
	Query query=manager.createQuery(sql);
	List<EventEntity> list=query.getResultList();
	for(int i=0; i<list.size(); i++){
		EventEntity event=list.get(i);
		events.add(event);
	}
	
	return events;
}
}
