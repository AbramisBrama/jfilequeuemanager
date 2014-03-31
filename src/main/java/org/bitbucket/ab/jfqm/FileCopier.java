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


import static java.nio.file.StandardCopyOption.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

/**
 * @author Dmitry Myasnikov <saver_is_not@bk.ru>
 * @author Victor Letovaltsev <Z_U_B_R_U_S@mail.ru>
 */
public class FileCopier {
	
	public static void copy(String source, String target)
	{
		try { //http://stackoverflow.com/questions/5003907/how-to-copy-file-in-java
			Path pTarget = Files.createDirectories(FileSystems.getDefault().getPath(target), new FileAttribute<?>[0]);
			java.nio.file.Files.move(FileSystems.getDefault().getPath(source), pTarget, REPLACE_EXISTING); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
