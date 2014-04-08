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
package org.bitbucket.ab.jfqm;

import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.log4j.Logger;
import org.bitbucket.ab.jfqm.scheduler.ITimeoutJob;
import org.bitbucket.ab.jfqm.scheduler.MoveJobProducer;
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
		List<ITimeoutJob> bean = (List<ITimeoutJob>) beanFactory.getBean("jobList");
		ConcurrentSkipListSet<ITimeoutJob> jobsSet = new ConcurrentSkipListSet<ITimeoutJob>(bean);
		//BlockingQueue<MoveJob> b = new LinkedBlockingQueue<MoveJob>();
		MoveJobProducer m2 = new MoveJobProducer(jobsSet);
		new Thread(m2).start();

	}

}
