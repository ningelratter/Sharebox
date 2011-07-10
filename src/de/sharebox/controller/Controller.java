package de.sharebox.controller;

import java.util.List;

import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;
import de.sharebox.entities.History;
import de.sharebox.entities.User;
import de.sharebox.services.FileService;
import de.sharebox.services.HistoryService;
import de.sharebox.services.UserService;

/**
 * This class controls the services (UserService, FileService, HistoryService).
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 */

public class Controller {

	private final UserService userService;

	private final HistoryService historyService;

	private final FileService fileService;

	private User loggedInUser;

	// constructor
	public Controller() {
		userService = new UserService();
		historyService = new HistoryService();
		fileService = new FileService();
	}

	/**
	 * Call to create a user in the user service from type User and call to write
	 * a history.
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
		login(name, password);
		return user;

	}

	/**
	 * Method calls the user service and history service to remove a user from the
	 * database.
	 * 
	 * @param user
	 */
	public void removeUser(User user) {
		userService.removeUser(user);
		historyService.logremoveUser(user);
	}

	/**
	 * Method gets the logged in user.
	 * 
	 * @param name
	 * @param password
	 * @return user
	 */
	public User login(String name, String password) {
		User user = getUser(name, password);
		loggedInUser = user;
		return user;
	}

	/**
	 * Method save the data, when user want to log out and set the loggedInUser
	 * null.
	 * 
	 * @return logged in user
	 */
	public User logout() {
		saveData();
		loggedInUser = null;
		return loggedInUser;
	}

	/**
	 * Gets the user by name and password.
	 * 
	 * @param name
	 * @param password
	 * @return user by name
	 */
	public User getUser(String name, String password) {
		return userService.getUserByName(name, password);
	}

	/**
	 * Gets the user by email.
	 * 
	 * @param mail
	 * @return user my email
	 */
	public User getUser(String mail) {
		return userService.getUserByMail(mail);
	}

	/**
	 * Calls the user service to save all user profiles.
	 */
	public void saveData() {
		userService.saveUsers();
		userService.loadUsers();
	}

	/**
	 * Calls the user service to change the name of a user and calls the history
	 * service to documented that.
	 * 
	 * @param name
	 */
	public void setUserName(String name) {
		userService.setUserName(loggedInUser, name);
		historyService.logUserNameChanged(loggedInUser.getId(), name);

	}

	/**
	 * Calls the user service to change password of the user and calls the history
	 * service to write them into the history.
	 * 
	 * @param user
	 * @param password
	 */
	public void setUserPassword(User user, String password) {

		userService.setUserPassword(user, password);
		historyService.logUserPasswordChanged(user.getId());
	}

	/**
	 * Calls the user service to change the mailadress of the user and calls the
	 * history service to write the change into the history.
	 * 
	 * @param user
	 * @param email
	 */
	public void setUserEmail(User user, String email) {

		userService.setUserEmail(user, email);
		historyService.logUserEmailChanged(user.getId(), email);
	}

	/**
	 * Calls the user service and history service to change and log them.
	 * 
	 * @param user
	 * @param limit
	 */
	public void setUserLimit(User user, int limit) {
		userService.setUserLimit(user, limit);
		historyService.logUserLimitChanged(user.getId(), limit);

	}

	/**
	 * Calls the Logentries of a user.
	 * 
	 * @param userId
	 * @return history entries by user
	 */
	public List<History> getHistory(int userId) {
		return historyService.getHistoryEntriesByUsers(userId);
	}

	/**
	 * Method creates a directory of the logged in user, calls the user service to
	 * change the user limit and calls the history service to log them.
	 * 
	 * @param folderName
	 * @param dir
	 */
	public void createDir(String folderName, Dir dir) {
		fileService.createDir(loggedInUser.getId(), folderName, dir, loggedInUser);
		historyService.logFolderCreation(loggedInUser.getId(), folderName);
		userService.changeUserLimit(loggedInUser, 5);

	}

	/**
	 * Method creates a text file of the logged in user, calls the user service to
	 * change the user limit and calls the history service to log them.
	 * 
	 * @param fileName
	 * @param dir
	 */
	public void createTextFile(String fileName, Dir dir) {
		fileService.createTextFile(loggedInUser.getId(), fileName, dir, loggedInUser);
		historyService.logTextFileCreation(loggedInUser.getId(), fileName);
		userService.changeUserLimit(loggedInUser, 5);

	}

	/**
	 * Method removes a file of the logged in user, calls the history to log them
	 * and calls the user service to change the user limit.
	 * 
	 * @param file
	 */
	public void removeFile(AbstractFile file) {
		fileService.removeElement(file, loggedInUser);
		historyService.logFileDeletion(loggedInUser.getId(), file.getName());
		userService.changeUserLimit(loggedInUser, -5);

	}

	/**
	 * Gets the root directory of a logged in user by id.
	 */
	public Dir getRootDir() {
		return fileService.getRootDir(loggedInUser.getId());
	}

	/**
	 * Returns a user for a given id.
	 */
	public User getUserById(int userId) {
		return userService.getUserById(userId);
	}
}
