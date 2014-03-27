/**
 * 
 */
package org.bitbucket.ab.jfqm;

import org.bitbucket.ab.jfqm.scheduler.IJob;

/**
 * @author saver
 *
 */
public interface ITimeoutJob extends IJob {
	long getTimeout();
}
