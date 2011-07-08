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

	// creates a history entry for every activity
	public History createHistory(int userId, String activity) {

		History history = new History(userId, new Date(), activity);
		historyList.add(history);
		try {
			saveHistory();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return history;

	}

	// removes user from data bank and saves the change
	public void logremoveUser(User user) {

		createHistory(user.getId(), "User deleted" + user.getName());
		loadHistory();
	}

	public void logUserCreatedItself(int idU, String userName) {
		createHistory(idU, userName + " created ");
	}

	// writes the history with userName, date and activity
	public void logUserNameChanged(int idU, String userName) {
		createHistory(idU, " Username changed to " + userName);
	}

	public void logUserPasswordChanged(int idU) {
		createHistory(idU, " Password changed ");
	}

	public void logUserEmailChanged(int idU, String email) {
		createHistory(idU, " Email changed to " + email);
	}

	public void logUserLimitChanged(int idU, double limit) {
		createHistory(idU, " limit changed to " + limit);
	}

	public void logFileUpload(int idU, String name) {
		createHistory(idU, " uploaded file '" + name);
	}

	public void logFileDeletion(int userId, String fileName) {
		createHistory(userId, " deleted '" + fileName + "'");
	}

	public void logFolderCreation(int userId, String folderName) {
		createHistory(userId, " created folder " + folderName);
	}

	public void logTextFileCreation(int userId, String fileName) {
		createHistory(userId, " created text file " + fileName);
	}

	public List<History> getHistoryEntriesByUsers(int userId) {

		List<History> resultList = new ArrayList<History>();
		for (History history : historyList) {
			if (history.getUserId() == userId) {
				resultList.add(history);
			}
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	private void loadHistory() {
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				XMLDecoder decoder = new XMLDecoder(fis);
				historyList = (ArrayList<History>) decoder.readObject();
				decoder.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// save the history entry
	public void saveHistory() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(historyList);
			encoder.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
