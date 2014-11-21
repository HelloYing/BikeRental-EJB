package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class JobsAdded {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<List<String>> jobsAdded(String user1) {
		
		
		List<List<String>> jobs = new ArrayList<List<String>>();
		
		String location = "";
		String pay = "";
		String title = "";
		String technology = "";

		List<JobListingEntity> jobListing;
		Query query = em.createNativeQuery
				("select * from JOBLISTING where USER like '" + user1//modify change temp
						+ "'" , JobListingEntity.class);

		jobListing = query.getResultList();
		if(!jobListing.isEmpty())
		{
			int size = jobListing.size();
			
			for(int i = 0; i< size ; i++)
			{
			JobListingEntity jle = new JobListingEntity();
			jle = jobListing.get(i);
			
			title = jle.getTitle();
			location = jle.getLocation();
			pay = jle.getPay();
			technology = jle.getTechnology();
			List<String> job = new ArrayList<String>();

			job.add(title);
			job.add(location);
			job.add(pay);
			job.add(technology);

			jobs.add(job);
			}
			
			return jobs;
		
		}
		else return jobs;
	}
}
