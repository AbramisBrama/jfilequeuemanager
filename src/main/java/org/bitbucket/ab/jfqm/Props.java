/**
    This file is part of JFileQueueManager.

    JFileQueueManager is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JFileQueueManager is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JFileQueueManager.  If not, see <http://www.gnu.org/licenses/>.

   (Этот файл — часть JFileQueueManager.

   JFileQueueManager - свободная программа: вы можете перераспространять ее и/или
   изменять ее на условиях Стандартной общественной лицензии GNU в том виде,
   в каком она была опубликована Фондом свободного программного обеспечения;
   либо версии 3 лицензии, либо (по вашему выбору) любой более поздней
   версии.

   JFileQueueManager распространяется в надежде, что она будет полезной,
   но БЕЗО ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА
   или ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Стандартной
   общественной лицензии GNU.

   Вы должны были получить копию Стандартной общественной лицензии GNU
   вместе с этой программой. Если это не так, см.
   <http://www.gnu.org/licenses/>.)
 */
package org.bitbucket.ab.jfqm;

import java.util.LinkedList;
import java.util.List;

import org.bitbucket.ab.jfqm.scheduler.impl.ResourceCheckJob;
import org.bitbucket.ab.jfqm.task.ITaskInfo;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 */
public class Props {
	private static Props props = null;
	private static List<ResourceCheckJob> dirs;
	private Props(){
		
	}
	/*	public synchronized static Props getInstance(){
		if(props==null){
			props = new Props();
			//TODO: read props from config file
			dirs = new LinkedList<ResourceCheckJob>();
			ResourceCheckJob dir = new ResourceCheckJob();
			dir.setName("queue1");
			dir.setFrom("./test/resources/q1/from/");
			dir.setTo("./test/resources/q1/to/");
			dir.setMoveChecked(true);
			dir.setTimeout(30000); //30s
			dirs.add(dir);
			
			dir = new ResourceCheckJob();
			dir.setName("queue2");
			dir.setFrom("./test/resources/q2/from/");
			dir.setTo("./test/resources/q2/to/");
			dir.setMoveChecked(false);
			dir.setTimeout(30000); //30s
			dirs.add(dir);
			
			return props;
			
		}
		else
		{
			return props;
		}
	}*/
	
	public List<ResourceCheckJob> getDirList()
	{
		return dirs;
	}
	
	public ITaskInfo getNextJob()
	{ 
		//TODO - выдать QTaskInfo с ближайшим временем выполнения
		return null;
	}

}
