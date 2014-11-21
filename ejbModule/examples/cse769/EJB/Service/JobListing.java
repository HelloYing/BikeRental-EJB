package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class JobListing {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<List<String>> findJob(String title, String location) {
		JobListingEntity newEntity = new JobListingEntity();
		
		List<List<String>> jobs = new ArrayList<List<String>>();
		long aidNbr;
		String aid = "";
		String pay;
		String technology;
		String employer;
		List<JobListingEntity> jobListing;
		
		Query query = em.createNativeQuery
				("select * from JOBLISTING where TITLE like '" + title
						+ "'" + " OR LOCATION like '" + location + "'", JobListingEntity.class);

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
			employer = jle.getUser();
			aidNbr = jle.getAnnouncementId();
			aid = String.valueOf(aidNbr);

			List<String> job = new ArrayList<String>();

			job.add(title);
			job.add(location);
			job.add(pay);
			job.add(technology);
			job.add(employer);
			job.add(aid);
			
			jobs.add(job);
			}
			
			return jobs;
		
		}
		
		else return jobs;
	}
}
