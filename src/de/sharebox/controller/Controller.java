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
 * This class controll the services (UserService, FileService,
 * DirectoryService).
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 */

public class Controller {

	private UserService userService;

	private HistoryService historyService;

	private FileService fileService;

	private User loggedInUser;

	// constructor
	public Controller() {
		userService = new UserService();
		historyService = new HistoryService();
		fileService = new FileService();
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

	public void removeUser(User user) {
		userService.removeUser(user);
		historyService.logremoveUser(user);
	}

	public User login(String name, String password) {
		User user = getUser(name, password);
		loggedInUser = user;
		return user;
	}

	public void logout() {
		saveData();
		loggedInUser = null;
	}

	public User getUser(String name, String password) {
		return userService.getUserByName(name, password);
	}

	public User getUser(String mail) {
		return userService.getUserByMail(mail);
	}

	// calls the userService to save all Userprofiles
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

	// calls the userService to change the mailadress of the user
	public void setUserEmail(User user, String email) {

		userService.setUserEmail(user, email);
		historyService.logUserEmailChanged(user.getId(), email);
	}

	// calls the userService and historyService to change and log them
	public void setUserLimit(User user, int limit) {
		userService.setUserLimit(user, limit);
		historyService.logUserLimitChanged(user.getId(), limit);

	}

	// calls the Logentries
	public List<History> getHistory(int userId) {
		return historyService.getHistoryEntriesByUsers(userId);
	}

	public void createDir(String folderName, Dir dir) {
		fileService.createDir(loggedInUser.getId(), folderName, dir);
		historyService.logFolderCreation(loggedInUser.getId(), folderName);
	}

	public void createTextFile(String fileName, Dir dir) {
		fileService.createTextFile(loggedInUser.getId(), fileName, dir);
		historyService.logTextFileCreation(loggedInUser.getId(), fileName);
	}

	public void removeFile(AbstractFile file) {
		fileService.removeElement(file);
		historyService.logFileDeletion(loggedInUser.getId(), file.getName());
	}

	public Dir getRootDir() {
		return fileService.getRootDir(loggedInUser.getId());
	}
}
