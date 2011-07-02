<<<<<<< HEAD
package de.sharebox.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import de.sharebox.entities.Dir;
import de.sharebox.entities.User;

/**
 * 
 * @author Eilin
 * @verson 30.06.11
 */
public class DirService {

	private Map<Integer, Dir> dirByIdMap = new HashMap<Integer, Dir>();

	public DirService() {
		loadDir();
	}

	public Dir createDir(String name, User owner, double size, Date creationDate, Date lastChange, int id,
			List<String> userlist, List<String> filelist) {

		if (name != null && !name.isEmpty()) {
			id = createUniqueId();
			boolean idCheck = false;

			for (Dir dir : dirByIdMap.values()) {
				int i = dir.getId();

				if (id == i) {

					idCheck = false;
				} else {
					idCheck = true;
				}
			}
			if (idCheck) {
				Dir dir1 = (Dir) new Dir(name, owner, size, creationDate, lastChange, id, userlist, filelist);
				dirByIdMap.put(id, dir1);
				return dir1;

			} else {
				// recursive call if id wasn't unique
				createDir(name, owner, size, creationDate, lastChange, id, userlist, filelist);

			}

		}

		return null;

	}

	private void loadDir() {
		// TODO Auto-generated method stub

	}

	// creates an id
	private int createUniqueId() {
		Random random = new Random();
		int id = random.nextInt(100);

		List<String> idList;

		// TODO checken, ob id schon vergeben...

		return id;
	}



=======
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
			// TODO hier weitere mögliche Fehler abfangen

		}
	}

	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
>>>>>>> 66ff061e920a89b18cfb79fad65c5948cf07d0cc
}
