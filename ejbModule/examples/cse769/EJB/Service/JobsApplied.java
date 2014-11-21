package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class JobsApplied {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;

	public List<List<String>> jobsApplied(String user) {
		
		
		List<List<String>> jobs = new ArrayList<List<String>>();
		String location = "";
		String pay = "";
		String title = "";
		String technology = "";
		String employer = "";
		long aidNbr;
		String aid = "";

		String user1 = "";
		List<JobApplyEntity> jobApply;
		Query query = em.createNativeQuery
				("select * from JOBAPPLY where USER like '" + user
						+ "'" , JobApplyEntity.class);

		jobApply = query.getResultList();
		if(!jobApply.isEmpty())
			{
				int size = jobApply.size();
				
				for(int i = 0; i< size ; i++)
				{
					JobApplyEntity jae = new JobApplyEntity();
					jae = jobApply.get(i);
				
				title = jae.getTitle();
				location = jae.getLocation();
				pay = jae.getPay();
				technology = jae.getTechnology();
				employer = jae.getUser();
				aidNbr = jae.getAnnouncementId();
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
