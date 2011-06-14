package de.sharebox.controller;

import de.sharebox.gui.User;
import de.sharebox.services.UserService;

/**
 * This class controll the services (UserService, FileService, DirectoryService).
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 */

public class Controller {

	private UserService userService;

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
	public User getUser(String name, String password) {
		return userService.getUserByName(name, password);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
