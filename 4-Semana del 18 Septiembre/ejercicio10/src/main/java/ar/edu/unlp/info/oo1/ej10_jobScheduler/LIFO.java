package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class LIFO extends JobScheduler {

	@Override
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.get(jobs.size()-1);
		this.unschedule(nextJob);
		return nextJob;
	}
	
}
