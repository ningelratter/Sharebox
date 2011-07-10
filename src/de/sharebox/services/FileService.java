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
 * This class creates and changes directories of a user.
 * 
 * @author MW
 * 
 */
public class FileService implements Serializable {

	private static final long serialVersionUID = 3540898262107664579L;

	private Map<Integer, Dir> rootDirs = new HashMap<Integer, Dir>();

	private File file = new File("data/files.xml");

	public FileService() {
		loadFiles();
	}

	/**
	 * This method removes a directory of user.
	 * 
	 * @param dir
	 * @param userModel
	 */
	public static boolean removeDir(File dir, UserModel userModel) {
		String path = System.getProperty("user.dir");
		User user = userModel.getUser();
		String idU = user.getRootDir();

		// can't remove if directory doesn't exists or if its the root dir of a user
		if (dir.getPath().equals(path + "\\" + idU)) {

			return false;
		}
		else {
			deleteSubFolder(dir);
			return true;
		}
	}

	/**
	 * Method deletes subfolders of the root.
	 * 
	 * @param dir
	 */
	public static void deleteSubFolder(File dir) {
		File[] files = dir.listFiles();

		for (int nIndex = 0; nIndex < files.length; nIndex++) {
			if (files[nIndex].isDirectory()) {
				deleteSubFolder(files[nIndex]);
			}
			files[nIndex].delete();
		}
	}

	/**
	 * Method gets the root directory of a user.
	 * 
	 * @param userId
	 * @return directory
	 */
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

	/**
	 * Method creates a directory in the current level.
	 * 
	 * @param userId
	 * @param folderName
	 * @param parent
	 * @param user
	 */
	public void createDir(int userId, String folderName, Dir parent, User user) {
		Dir dir = new Dir(userId, folderName, parent);
		addChild(parent, dir);

	}

	/**
	 * Method creates a text file.
	 * 
	 * @param userId
	 * @param fileName
	 * @param parent
	 * @param user
	 */
	public void createTextFile(int userId, String fileName, Dir parent, User user) {
		TextFile file = new TextFile(userId, fileName, parent);
		addChild(parent, file);
	}

	/**
	 * Method add a child in the level when file name is unique.
	 * 
	 * @param parent
	 * @param file
	 */
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

	/**
	 * Method removes directories or files.
	 * 
	 * @param file
	 * @param user
	 */
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
