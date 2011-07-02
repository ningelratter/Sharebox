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

	public static void createRootDirLocation(int id) {
		String path = System.getProperty("user.dir");
		String userId;
		userId = String.valueOf(id);
		try {

			File dir = new File(path + "\\" + userId);

			if (!dir.isDirectory()) {

				dir.mkdir();
			} else {
				System.out.println("order gibts es schon!");
			}

			dir.mkdir();

		} catch (Throwable NullPointerException) {
			// TODO hier weitere mögliche Fehler abfangen
		}

	}

	public static void renameRootDirLocation(String rootDir) {

	}

	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
