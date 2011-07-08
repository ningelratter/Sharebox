package de.sharebox.controller;

import java.util.List;

import de.sharebox.entities.History;
import de.sharebox.entities.User;
import de.sharebox.services.HistoryService;
import de.sharebox.services.UserService;

/**
 * This class controls the services (UserService, FileService,
 * DirectoryService).
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 */

public class Controller {

	private final UserService userService;
	private final HistoryService historyService;

	// constructor
	public Controller() {
		userService = new UserService();
		historyService = new HistoryService();
	}

	/**
	 * call to create a user in the userService From type User and call to write
	 * history
	 * 
	 * @param name
	 * @param password
	 * @param mail
	 * @return a user with his properties
	 */
	public User createUser(String name, String password, String mail) {
		User user = userService.createUser(name, password, mail);
		if (user != null) {
			historyService.logUserCreatedItself(user.getId(), name);
		}
		return user;

	}

	/**
	 * @author Eilin
	 * @param name
	 * @param password
	 * @return the user
	 */
	// is removing user from data bank
	public void removeUser(User user) {

		userService.removeUser(user);
		historyService.logremoveUser(user);

	}

	public User getUser(String name, String password) {
		return userService.getUserByName(name, password);
	}

	public User getUser(String mail) {
		return userService.getUserByMail(mail);
	}

	// calls the userService to save all User profiles
	public void saveData() {
		userService.saveUsers();
	}

	// calls the userService to change the UserName
	public void setUserName(User user, String name) {
		userService.setUserName(user, name);
		historyService.logUserNameChanged(user.getId(), name);

	}

	// calls the userService to change Users Password
	public void setUserPassword(User user, String password) {

		userService.setUserPassword(user, password);
		historyService.logUserPasswordChanged(user.getId());
	}

	// calls the userService to change the mail adress of the user
	public void setUserEmail(User user, String email) {

		userService.setUserEmail(user, email);
		historyService.logUserEmailChanged(user.getId(), email);
	}

	// calls the userService and historyService to change and log them
	public void setUserLimit(User user, int limit) {
		userService.setUserLimit(user, limit);
		historyService.logUserLimitChanged(user.getId(), limit);

	}

	// calls the Log entries
	public List<History> getHistory(int idI) {
		return historyService.getHistoryEntriesByUsers(idI);
	}
	//
	public void createDirector(int idU, String nameOfDirectory) {
		
		//erstell Aktion 
		historyService.logDirectoryCreated(idU, nameOfDirectory);

	}

}
