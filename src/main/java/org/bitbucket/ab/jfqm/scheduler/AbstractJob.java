/**
 * 
 */
package org.bitbucket.ab.jfqm.scheduler;

import java.sql.Timestamp;

/**
 * @author saver
 *
 */
public abstract class AbstractJob implements IJob {

	/* (non-Javadoc)
	 * @see org.bitbucket.ab.jfqm.JobInterface#run()
	 */
	abstract public void run();

	
	public Timestamp getNextRunTime() {
		return nextRunTime;
	}

	public void setNextRunTime(Timestamp nextRunTime) {
		this.nextRunTime = nextRunTime;
	}

	private Timestamp nextRunTime; //initialized value = curr time + timeout
	
}
