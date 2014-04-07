/**
 * 
 */
package org.bitbucket.ab.jfqm;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.bitbucket.ab.jfqm.config.JobConfigSet;
import org.bitbucket.ab.jfqm.scheduler.MoveJobProducer;
import org.bitbucket.ab.jfqm.scheduler.impl.MoveJob;
import org.bitbucket.ab.jfqm.scheduler.impl.ResourceCheckJob;
import org.bitbucket.ab.jfqm.task.ITaskInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 */
public class Main {

	static final Logger logger = Logger.getLogger(Main.class);
	
	private static ClassPathXmlApplicationContext beanFactory;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		beanFactory = new ClassPathXmlApplicationContext("config.xml");
		ConcurrentSkipListSet jobsSet = new ConcurrentSkipListSet((List<ITimeoutJob>) beanFactory.getBean("jobList"));
		
		JobConfigSet jobs = (JobConfigSet) beanFactory.getBean("jobsSet");
		BlockingQueue<MoveJob> b = new LinkedBlockingQueue<MoveJob>();
		MoveJobProducer m = new MoveJobProducer(b, jobs );
		MoveJobProducer m2 = new MoveJobProducer(b, jobsSet);
		
		//ResourceCheckJob first = (ResourceCheckJob) jobs.pollFirst();
		/*
		long delta = System.currentTimeMillis()-first.getNextRunTime().getTime();
		System.out.println(first.getNextRunTime()+" "+first.getTaskInfo().getFrom()+" "+delta );
		
		first = (ResourceCheckJob) jobs.pollFirst();
		delta = System.currentTimeMillis()-first.getNextRunTime().getTime();
		System.out.println(first.getNextRunTime()+" "+first.getTaskInfo().getFrom()+" "+delta );
		
		first = (ResourceCheckJob) jobs.pollFirst();
		delta = System.currentTimeMillis()-first.getNextRunTime().getTime();
		System.out.println(first.getNextRunTime()+" "+first.getTaskInfo().getFrom()+" "+delta );
		*/
		//new Thread(m).start();
		
		new Thread(m2).start();

	}

}
