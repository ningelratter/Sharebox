package de.sharebox.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.sharebox.entities.History;
import de.sharebox.entities.User;

/**
 * This class creates a log with all activities of a user in the system.
 * 
 * @author Eilin
 * @version 02.07.11
 */

public class HistoryService {

	// Map for holding users
	private List<History> historyList = new ArrayList<History>();

	private final File file = new File("data/history.xml");

	public HistoryService() {
		loadHistory();
	}

	/**
	 * Method creates a history entry for every activity.
	 * 
	 * @param userId
	 * @param activity
	 * @return
	 */
	public History createHistory(int userId, String activity) {

		History history = new History(userId, new Date(), activity);
		historyList.add(history);
		try {
			saveHistory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return history;

	}

	/**
	 * Logs a directory created action.
	 * 
	 * @param idU
	 * @param nameOfDirectory
	 */
	public void logDirectoryCreated(int idU, String nameOfDirectory) {

		createHistory(idU, "Directory:" + nameOfDirectory + " created");

	}

	/**
	 * Removes user from database and saves the changes.
	 * 
	 * @param user
	 */
	public void logremoveUser(User user) {

		createHistory(user.getId(), "User deleted" + user.getName());
		loadHistory();
	}

	/**
	 * Log for the action creating a user
	 * 
	 * @param idU
	 * @param userName
	 */
	public void logUserCreatedItself(int idU, String userName) {
		createHistory(idU, userName + " created ");
	}

	/**
	 * Add a entry to the history when username is changed.
	 * 
	 * @param idU
	 * @param userName
	 */
	public void logUserNameChanged(int idU, String userName) {
		createHistory(idU, " Username changed to " + userName);
	}

	/**
	 * Add a entry to the history when password is changed.
	 * 
	 * @param idU
	 */
	public void logUserPasswordChanged(int idU) {
		createHistory(idU, " Password changed ");
	}

	/**
	 * Add a entry to the history when email is changed.
	 * 
	 * @param idU
	 * @param email
	 */
	public void logUserEmailChanged(int idU, String email) {
		createHistory(idU, " Email changed to " + email);
	}

	/**
	 * Add a entry to the history when limit is changed.
	 * 
	 * @param idU
	 * @param limit
	 */
	public void logUserLimitChanged(int idU, double limit) {
		createHistory(idU, " limit changed to " + limit);
	}

	/**
	 * Add a entry to the history when file is uploaded.
	 * 
	 * @param idU
	 * @param name
	 */
	public void logFileUpload(int idU, String name) {
		createHistory(idU, " uploaded file '" + name);
	}

	/**
	 * Add a entry to the history when file is deleted.
	 * 
	 * @param userId
	 * @param fileName
	 */
	public void logFileDeletion(int userId, String fileName) {
		createHistory(userId, " deleted '" + fileName + "'");
	}

	/**
	 * Add a entry to the history when folder is created.
	 * 
	 * @param userId
	 * @param folderName
	 */
	public void logFolderCreation(int userId, String folderName) {
		createHistory(userId, " created folder " + folderName);
	}

	/**
	 * Add a entry to the history when text file is created.
	 * 
	 * @param userId
	 * @param fileName
	 */
	public void logTextFileCreation(int userId, String fileName) {
		createHistory(userId, " created text file " + fileName);
	}

	/**
	 * Method gets the log entries of a user
	 * 
	 * @param userId
	 * @return result list of historyentries.
	 */
	public List<History> getHistoryEntriesByUsers(int userId) {

		List<History> resultList = new ArrayList<History>();
		for (History history : historyList) {
			if (history.getUserId() == userId) {
				resultList.add(history);
			}
		}
		return resultList;
	}

	/**
	 * Method loads the historyentries from database.
	 */
	@SuppressWarnings("unchecked")
	private void loadHistory() {
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				XMLDecoder decoder = new XMLDecoder(fis);
				historyList = (ArrayList<History>) decoder.readObject();
				decoder.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method saves the history entry.
	 * 
	 * @throws IOException
	 */
	public void saveHistory() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(historyList);
			encoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
