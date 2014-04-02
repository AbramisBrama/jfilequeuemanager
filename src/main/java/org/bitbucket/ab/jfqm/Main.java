/**
 * 
 */
package org.bitbucket.ab.jfqm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.bitbucket.ab.jfqm.config.JobConfigSet;
import org.bitbucket.ab.jfqm.scheduler.MoveJobProducer;
import org.bitbucket.ab.jfqm.scheduler.impl.ResourceCheckJob;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("config.xml");
		JobConfigSet jobs = (JobConfigSet) beanFactory.getBean("jobsSet");
		BlockingQueue b = new LinkedBlockingQueue();
		MoveJobProducer m = new MoveJobProducer(b, jobs );
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
		new Thread(m).start();

	}

}
