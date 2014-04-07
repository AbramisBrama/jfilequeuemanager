/**
 *   This file is part of JFileQueueManager.
 *   JFileQueueManager is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   JFileQueueManager is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with JFileQueueManager.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   (Этот файл — часть JFileQueueManager.
 *
 *   JFileQueueManager - свободная программа: вы можете перераспространять ее и/или
 *   изменять ее на условиях Стандартной общественной лицензии GNU в том виде,
 *   в каком она была опубликована Фондом свободного программного обеспечения;
 *   либо версии 3 лицензии, либо (по вашему выбору) любой более поздней
 *   версии.
 *
 *   JFileQueueManager распространяется в надежде, что она будет полезной,
 *   но БЕЗО ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА
 *   или ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Стандартной
 *   общественной лицензии GNU.
 *
 *   Вы должны были получить копию Стандартной общественной лицензии GNU
 *   вместе с этой программой. Если это не так, см.
 *   <http://www.gnu.org/licenses/>.)
 */

package org.bitbucket.ab.jfqm.scheduler;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.concurrent.BlockingQueue;

import org.bitbucket.ab.jfqm.DirChecker;
import org.bitbucket.ab.jfqm.config.JobConfigSet;
import org.bitbucket.ab.jfqm.scheduler.impl.MoveJob;


/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 * 
 */
public class MoveJobProducer implements Runnable {

	private BlockingQueue<MoveJob> jobQueue;
	private JobConfigSet checkJobs;

	@Override
	public void run() {
		ITimeoutJob first = checkJobs.pollFirst();
	
		long currTime = System.currentTimeMillis();			//to avoid frequent reading of System.currentTimeMillis()
		long delta=currTime - first.getNextRunTime().getTime(); // time before nearest job
		
		while (!Thread.interrupted()) {
			ITimeoutJob nearestJob = checkJobs.pollFirst();
			if (isTimeToRun(nearestJob) ){
				nearestJob.run();
				nearestJob.refreshNextRunTime();
				checkJobs.add(nearestJob);
			} 
			else
			{
				try {
					Thread.sleep(System.currentTimeMillis()-nearestJob.getNextRunTime().getTime());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	/*		isTimeToRun(*/
	/*		while (delta>=-500) { 							// if less than 500 ms before job beginning
				try {
					if (!DirChecker.isEmpty(first.getTaskInfo().getFrom())) { // the longest operation TODO put it to new thread
						jobQueue.put(new MoveJob(first.getTaskInfo()));
					} else {
						System.err.println("Dir empty: "+ first.getTaskInfo().getFrom()); // TODO Write to log
					}
				} catch (FileNotFoundException e) {
					System.err.println("File error: "+ e.getMessage()); // TODO Write to log
				} catch (InterruptedException e) {
					e.printStackTrace();	// TODO Write to log
				} finally {
						first.refreshNextRunTime();  //we have already checked first item, so let's refresh its next time to run TODO - bring it to job
						checkJobs.add(first);	// TODO add after job is done			
						first = checkJobs.pollFirst();
						delta = currTime - first.getNextRunTime().getTime();
				}
			}
			
			try { //TODO I don't like it
					Thread.sleep(-delta);
					delta = System.currentTimeMillis()
							- first.getNextRunTime().getTime();
			} catch (InterruptedException e) {
				e.printStackTrace();	 //TODO Write to log
			}
			currTime=System.currentTimeMillis();	
*/
		}

	}

	public MoveJobProducer(BlockingQueue<MoveJob> jobQueue,
			JobConfigSet checkJobs) {
		super();
		this.jobQueue = jobQueue;
		this.checkJobs = checkJobs;
	}
	
	private boolean isTimeToRun(ITimeoutJob job){
		return (System.currentTimeMillis()- job.getNextRunTime().getTime() ) >=-500;
	}
}
