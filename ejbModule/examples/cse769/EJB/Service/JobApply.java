package examples.cse769.EJB.Service;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class JobApply {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public String applyJob( long aid, String user) {
		
		
		String location = "";
		String pay = "";
		String title = "";
		String technology = "";
		//String user = ""; //set user name too later
		List<JobListingEntity> jobList;
		Query query = em.createNativeQuery
				("select * from JOBLISTING where ANNOUNCEMENTID like '" + aid
						+ "'" , JobListingEntity.class);

		jobList = query.getResultList();
		if(!jobList.isEmpty())
		{
			JobListingEntity jle = new JobListingEntity();
			jle = jobList.get(0);//change to take care of multiple jobs
			
			location = jle.getLocation();
			pay = jle.getPay();
			title = jle.getTitle();
			technology = jle.getTechnology();
			//user = jle.getUser();
		}
		
		 
		 	JobApplyEntity newEntity = new JobApplyEntity();
			
			newEntity.setLocation(location);
			newEntity.setPay(pay);
			newEntity.setTitle(title);
			newEntity.setTechnology(technology);
			newEntity.setUser(user);
			
			try
			{
				em.persist(newEntity);		
			}
			
			catch(EntityExistsException e)
			{
				return "no";
			}
			
			return "Success";
	}
}
