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
package org.bitbucket.ab.jfqm.task;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 *
 */
public class TaskInfo implements ITaskInfo {

	public TaskInfo(String name, String from, String to, boolean moveChecked,
			long timeout, int id) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.moveChecked = moveChecked;
		this.timeout = timeout;
		this.id = id;
	}
	public TaskInfo(String name, String from, String to, long timeout) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.timeout = timeout;
		this.id = new String(name+from+to+moveChecked+timeout).hashCode();
	}
	public TaskInfo(String name, String from, String to) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.timeout = 1000*60*30; //default timeout - 30 min
		this.id = new String(name+from+to+moveChecked+timeout).hashCode();
	}
	private String name;
	private String from;
	private String to;
	private boolean moveChecked = true;
	private long timeout;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public TaskInfo(String name, String from, String to, boolean moveChecked,
			long timeout) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.moveChecked = moveChecked;
		this.timeout = timeout;
		this.id = new String(name+from+to+moveChecked+timeout).hashCode();
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public boolean isMoveChecked() {
		return moveChecked;
	}
	public void setMoveChecked(boolean moveChecked) {
		this.moveChecked = moveChecked;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}
