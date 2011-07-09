package de.sharebox.controller;

import java.util.List;

import com.sun.java.swing.plaf.nimbus.ProgressBarPainter;

import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;
import de.sharebox.entities.History;
import de.sharebox.entities.User;
import de.sharebox.gui.ChangeablePanel;
import de.sharebox.services.FileService;
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

	private final FileService fileService;

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
		login(name, password);
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

	public User logout() {
		saveData();
		loggedInUser = null;
		return loggedInUser;
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
	public void setUserName(String name) {
		userService.setUserName(loggedInUser, name);
		historyService.logUserNameChanged(loggedInUser.getId(), name);
	
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
		fileService.createDir(loggedInUser.getId(), folderName, dir,loggedInUser);
		historyService.logFolderCreation(loggedInUser.getId(), folderName);
		userService.changeUserLimit(loggedInUser, 5);
	
	}

	public void createTextFile(String fileName, Dir dir) {
		fileService.createTextFile(loggedInUser.getId(), fileName, dir,loggedInUser);
		historyService.logTextFileCreation(loggedInUser.getId(), fileName);
		userService.changeUserLimit(loggedInUser,5);
		
	
	}

	public void removeFile(AbstractFile file) {
		fileService.removeElement(file,loggedInUser);
		historyService.logFileDeletion(loggedInUser.getId(), file.getName());
		userService.changeUserLimit(loggedInUser, -5);
	
		
	}

	public Dir getRootDir() {
		return fileService.getRootDir(loggedInUser.getId());
	}
}
