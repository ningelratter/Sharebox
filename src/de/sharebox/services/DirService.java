/**
 * 
 */
package de.sharebox.services;

import java.io.File;
import java.io.Serializable;

/**
 * @author MW class for creating and changing Directories
 */
public class DirService implements Serializable, Comparable<File> {

	private static final long serialVersionUID = 3540898262107664579L;

	public static void createRootDirLocation(String rootDir) {
		String path = System.getProperty("user.dir");
		try {
			File dir = new File(path + "\\" + rootDir);
			dir.mkdir();
		
		} catch (Throwable NullPointerException) {
			// TODO hier weitere m�gliche Fehler abfangen

		}
	}

	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
