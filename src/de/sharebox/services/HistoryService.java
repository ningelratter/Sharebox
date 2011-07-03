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

	private File file = new File("data/history.xml");

	public HistoryService() {
		loadHistory();
	}

	// creates a historyentry for every activity
	public History createHistory(int userId, String activity) {

		History history = new History(userId, new Date(), activity);
		historyList.add(history);
		saveHistory();
		return history;

	}

	// removes user from data bank and saves the change
	public void logremoveUser(User user) {

		createHistory(user.getId(), "User deleted" + user.getName());
		loadHistory();
	}

	public void logUserCreatedItself(int id, String userName) {
		createHistory(id, userName + " created ");
	}

	// writes the history with userName, date and activity
	public void logUserNameChanged(int id, String userName) {
		createHistory(id, " Username changed to " + userName);
	}

	public void logUserPasswordChanged(int id) {
		createHistory(id, " Password changed ");
	}

	public void logUserEmailChanged(int id, String email) {
		createHistory(id, " Email changed to " + email);
	}

	public void logUserLimitChanged(int id, double limit) {
		createHistory(id, " limit changed to " + limit);
	}

	public List<History> getHistoryEntriesByUsers(int id){
		
		List<History> resultList = new ArrayList<History>();
		for (History history: historyList) {
			if(history.getUserId() == id){
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// save the historyentry
	public void saveHistory() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(historyList);
			encoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
