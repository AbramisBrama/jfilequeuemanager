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

package org.bitbucket.ab.jfqm.scheduler.impl;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.BlockingQueue;



import org.apache.log4j.Logger;
import org.bitbucket.ab.jfqm.DirChecker;
import org.bitbucket.ab.jfqm.scheduler.AbstractTimeoutJob;
import org.bitbucket.ab.jfqm.task.ITaskInfo;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 */
public class ResourceCheckJob extends AbstractTimeoutJob {

	static final Logger logger = Logger.getLogger(AbstractTimeoutJob.class);
	
	private BlockingQueue<MoveJob> jobQueue;

	public ResourceCheckJob(ITaskInfo currTaskInfo) {
		super();
		this.setTaskInfo(currTaskInfo);
		Date now = new Date();
		this.setNextRunTime(new Timestamp(now.getTime()+currTaskInfo.getTimeout()));
	}
	
	public ResourceCheckJob(ITaskInfo currTaskInfo, BlockingQueue<MoveJob> jobQueue) {
		super();
		this.setTaskInfo(currTaskInfo);
		this.setJobQueue(jobQueue);
		Date now = new Date();
		this.setNextRunTime(new Timestamp(now.getTime()+currTaskInfo.getTimeout()));
	}

	public BlockingQueue<MoveJob> getJobQueue() {
		return jobQueue;
	}

	public void setJobQueue(BlockingQueue<MoveJob> jobQueue) {
		this.jobQueue = jobQueue;
	}

	@Override
	public void run() {

		try {
			if (!DirChecker.isEmpty(getTaskInfo().getFrom())) { // the longest operation TODO put it to new thread
				jobQueue.put(new MoveJob(getTaskInfo()));
			} else {
				logger.error("Dir empty: "+ getTaskInfo().getFrom()); 
			}
		} catch (FileNotFoundException | InterruptedException e) {
			logger.error("Not found: "+ getTaskInfo().getFrom());
		}
		
	}

}
