package org.bitbucket.ab.jfqm.scheduler.impl;

import java.util.Comparator;

import org.bitbucket.ab.jfqm.scheduler.ITimeoutJob;

@Deprecated
public class TimeoutJobComparator implements Comparator<ITimeoutJob> {

	public int compare(ITimeoutJob o1, ITimeoutJob o2) {
		int rez = o1.getNextRunTime().compareTo(o2.getNextRunTime());
		if(rez == 0) rez = o1.getTaskInfo().getName().compareTo(o2.getTaskInfo().getName());
		if(rez == 0) rez = o1.getTaskInfo().getId()-(o2.getTaskInfo().getId());
		if(rez == 0) rez = 1;
		return rez;
	}
 
}
