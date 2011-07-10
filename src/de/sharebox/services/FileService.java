/**
 * 
 */
package de.sharebox.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;
import de.sharebox.entities.TextFile;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * @author MW class for creating and changing Directories
 */
public class FileService implements Serializable {

	private static final long serialVersionUID = 3540898262107664579L;

	private Map<Integer, Dir> rootDirs = new HashMap<Integer, Dir>();

	private File file = new File("data/files.xml");

	public FileService() {
		loadFiles();
	}

	public static void createRootDirLocation(int idU) {
		String path = System.getProperty("user.dir");
		String userId;
		userId = String.valueOf(idU);

		File dir = new File(path + "\\" + userId);

		if (!dir.isDirectory()) {

			dir.mkdir();
		}
		else {

		}
	}

	public static File[] listofFiles(File file) {

		File[] files = file.listFiles();
		for (int nIndex = 0; nIndex < files.length; nIndex++) {
			listofFiles(files[nIndex]);
		}

		return files;
	}

	public static void renameRootDirLocation(String rootDir) {

		// TODO

	}

	public static boolean removeDir(File dir, UserModel userModel) {
		String path = System.getProperty("user.dir");
		User user = userModel.getUser();
		String idU = user.getRootDir();

		// can't remove if directory doess'nt exists or if its the RootDir of a
		// user
		if (dir.getPath().equals(path + "\\" + idU)) {

			return false;
		}
		else {
			deleteSubFolder(dir);
			return true;
		}
	}

	public static void deleteSubFolder(File dir) {
		File[] files = dir.listFiles();

		for (int nIndex = 0; nIndex < files.length; nIndex++) {
			if (files[nIndex].isDirectory()) {
				deleteSubFolder(files[nIndex]);
			}
			files[nIndex].delete();
		}
	}

	public Dir getRootDir(int userId) {

		if (rootDirs.containsKey(userId)) {
			return rootDirs.get(userId);
		}
		else {
			Dir dir = new Dir(userId, "ROOT", null);
			rootDirs.put(userId, dir);
			saveFiles();
			return dir;
		}
	}

	// creates a directory
	public void createDir(int userId, String folderName, Dir parent, User user) {
		Dir dir = new Dir(userId, folderName, parent);
		addChild(parent, dir);

	}

	// creates a text-file
	public void createTextFile(int userId, String fileName, Dir parent, User user) {
		TextFile file = new TextFile(userId, fileName, parent);
		addChild(parent, file);
	}

	private void addChild(Dir parent, AbstractFile file) {

		boolean nameExists = false;

		for (AbstractFile child : parent.getChildren()) {
			if (child.getName().equals(file.getName())) {
				nameExists = true;
				break;
			}
		}

		if (!nameExists) {
			parent.addChild(file);
		}
		saveFiles();
	}

	// removes directory or file
	public void removeElement(AbstractFile file, User user) {
		Dir parent = file.getParent();
		parent.removeChild(file);
		saveFiles();
	}

	public void saveFiles() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(rootDirs);
			encoder.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadFiles() {
		try {
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				XMLDecoder decoder = new XMLDecoder(fis);
				rootDirs = (Map<Integer, Dir>) decoder.readObject();
				decoder.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
