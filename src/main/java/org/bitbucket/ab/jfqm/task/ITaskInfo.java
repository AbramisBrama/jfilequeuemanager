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
 */
public interface ITaskInfo {

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

	public abstract int getId();

	public abstract void setId(int id);

}