package org.bitbucket.ab.jfqm.scheduler.impl;

import java.util.Comparator;

import org.bitbucket.ab.jfqm.scheduler.ITimeoutJob;


public class TimeoutJobComparator implements Comparator<ITimeoutJob> {

	public int compare(ITimeoutJob o1, ITimeoutJob o2) {
		int rez = o1.getNextRunTime().compareTo(o2.getNextRunTime());
		if(rez == 0) rez = 1;
		return rez;
	}
 
}
