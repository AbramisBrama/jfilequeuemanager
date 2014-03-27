package org.bitbucket.ab.jfqm.scheduler;

import java.util.Collection;

import org.bitbucket.ab.jfqm.scheduler.impl.ResourceCheckJob;

public interface SchedulerInterface {
	void addJob(IJob t);
	Collection<ResourceCheckJob> getJobs();
	void removeJob(IJob t);
}
