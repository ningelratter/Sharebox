package de.sharebox.controller;

import de.sharebox.entities.User;
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

	// constructor
	// constructor
	public Controller() {
		userService = new UserService();
	}

	/**
	 * call to create a user in the userService From type User.
	 * 
	 * @param name
	 * @param password
	 * @param mail
	 * @return a user with his properties
	 */
	public User createUser(String name, String password, String mail) {
		return userService.createUser(name, password, mail);
	}

	/**
	 * @author Eilin
	 * @param name
	 * @param password
	 * @return the user
	 */
	//is removing user from data bank
	public void removeUser(User user){
		
		userService.removeUser(user);
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

	}

	// calls the userService to change Users Password
	public void setUserPassword(User user, String password) {

		userService.setUserPassword(user, password);
	}

	// calls the userService to change the mailadress of the user
	public void setUserEmail(User user, String email) {

		userService.setUserEmail(user, email);
	}

}
