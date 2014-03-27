/**
 * 
 */
package org.bitbucket.ab.jfqm.scheduler;

import java.sql.Timestamp;

/**
 * @author saver
 *
 */
public interface IJob {
	Timestamp getNextRuntime();
	void run();
}
