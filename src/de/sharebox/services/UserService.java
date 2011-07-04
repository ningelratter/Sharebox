package de.sharebox.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.sharebox.entities.User;

/**
 * 
 * @author Eilin,MW
 * @version 11.06.11
 */
public class UserService {

	// Map holding users
	private Map<Integer, User> userByIdMap = new HashMap<Integer, User>();

	public UserService() {
		// load available users
		loadUsers();

	}

	/**
	 * standard adjustment for new users
	 */
	private double limit = 2.0;

	/**
	 * standard adjustment, change language at class UserObject
	 * 
	 * @link{setLanguage()
	 */
	private int language = 0;

	private File file = new File("data/users.xml");

	// creates a user account and checks before, if id is unique
	public User createUser(String name, String password, String mail) {
		// check if userdata is not empty
		if (name != null && !name.isEmpty() && password != null
				&& !password.isEmpty()) {

			int id = createUniqueId();
			User user = new User(name, id, limit, password, mail, language);
			user.setRootDir(id);
			userByIdMap.put(id, user);
			return user;
		}
		else {
			return null;
		}
	}

	// changes the UserName
	public void setUserName(User user, String name) {
		user.setName(name);
	}

	// changes the UserPassword
	public void setUserPassword(User user, String password) {
		user.setPassword(password);
	}

	// changes the Mailadress of the user
	public void setUserEmail(User user, String email) {
		user.setMail(email);
	}

	// TODO limit wird bisher noch nicht geaendert!!!
	public void setUserLimit(User user, double limit) {
		user.setLimit(limit);
	}

	/**
	 * get the user
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	// gets User by name and password and checks if user exist
	public User getUserByName(String name, String password) {

		for (User user : userByIdMap.values()) {
			if (user != null) {
				if (name.equals(user.getName())
						&& password.equals(user.getPassword())) {
					return user;
				}
				else {
					return null;
				}
			}
			else {

				return null;
			}
		}
		return null;
	}

	// gets User over his mail
	public User getUserByMail(String mail) {
		for (User user : userByIdMap.values()) {
			if (user != null) {

				if (mail.equals(user.getMail())) {

					return user;
				}
				else {
					return null;
				}
			}

			else {
				return null;
			}
		}
		return null;
	}

	/**
	 * create a id
	 * 
	 * @return id
	 */
	// creates an id
	private int createUniqueId() {

		Random random = new Random();

		while (true) {
			int id = random.nextInt(100);
			if (userByIdMap.containsKey(id)) {
				return id;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void loadUsers() {
		try {
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				XMLDecoder decoder = new XMLDecoder(fis);
				userByIdMap = (Map<Integer, User>) decoder.readObject();
				decoder.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// removes user from data bank and saves the change
	public void removeUser(User user) {

		int i = user.getId();
		userByIdMap.remove(i);
		saveUsers();
	}

	public void saveUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(userByIdMap);
			encoder.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
};
