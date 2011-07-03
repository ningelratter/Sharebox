/**
 * 
 */
package de.sharebox.services;

import java.io.File;
import java.io.Serializable;

import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * @author MW class for creating and changing Directories
 */
public class DirService implements Serializable, Comparable<File> {

	private static final long serialVersionUID = 3540898262107664579L;

	public static void createRootDirLocation(int id) {
		String path = System.getProperty("user.dir");
		String userId;
		userId = String.valueOf(id);

		File dir = new File(path + "\\" + userId);

		if (!dir.isDirectory()) {

			dir.mkdir();
		} else {
			System.out.println("order gibts es schon!");

		}
	}
	
	public static File[] listofFiles(File file){
		
		File[] files = file.listFiles();
		for(int nIndex = 0; nIndex < files.length; nIndex++){
			listofFiles(files[nIndex]);
		}
						
		return files;
	}

	public static void renameRootDirLocation(String rootDir) {

	}



	public static boolean removeDir(File dir, UserModel userModel) {
		String path = System.getProperty("user.dir");
		User user = userModel.getUser();
		String id = user.getRootDir();

		// can't remove if directory doess'nt exists or if its the RootDir of a
		// user
		if (dir.getPath().equals(path + "\\" + id)) {
			System.out.println("root");
			return false;
		} else {
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

	
	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

/*
 * System.out.println(dir.exists()); System.out.println(dir.canRead());
 * System.out.println(dir.canWrite()); System.out.println(dir.canExecute());
 * System.out.println(dir.isFile() + "ex"); // recursive deleting if Directories
 * is not empty for (File file : dir.listFiles()) { if (file.isDirectory()) {
 * removeDir(file, userModel); file.delete(); } } return dir.delete();
 * 
 * 
 * }
 */

