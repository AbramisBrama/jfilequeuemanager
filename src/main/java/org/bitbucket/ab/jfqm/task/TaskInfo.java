package org.bitbucket.ab.jfqm.task;

public interface TaskInfo {

	/**
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * @param name the name to set
	 */
	public abstract void setName(String name);

	/**
	 * @return the from
	 */
	public abstract String getFrom();

	/**
	 * @param from the from to set
	 */
	public abstract void setFrom(String from);

	/**
	 * @return the to
	 */
	public abstract String getTo();

	/**
	 * @param to the to to set
	 */
	public abstract void setTo(String to);

	/**
	 * @return the moveChecked
	 */
	public abstract boolean isMoveChecked();

	/**
	 * @param moveChecked the moveChecked to set
	 */
	public abstract void setMoveChecked(boolean moveChecked);

	/**
	 * @return the timeout
	 */
	public abstract long getTimeout();

	/**
	 * @param timeout the timeout to set
	 */
	public abstract void setTimeout(long timeout);

	public abstract long getId();

	public abstract void setId(long id);

}