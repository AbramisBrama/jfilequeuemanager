/**
 * 
 */
package org.bitbucket.ab.jfqm.test;

import static org.junit.Assert.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.bitbucket.ab.jfqm.scheduler.MoveJobProducer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author saver
 *
 */
public class TestMoveJobProducer {
/*
	private static JobConfigSet jobs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("config.xml");
		jobs = (JobConfigSet) beanFactory.getBean("jobsSet");
	}

	@Test
	public void test() {
		BlockingQueue b = new LinkedBlockingQueue();
		MoveJobProducer m = new MoveJobProducer(b, jobs );
		new Thread(m).start();
	}
*/
}
