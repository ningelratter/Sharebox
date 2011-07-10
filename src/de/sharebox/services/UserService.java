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
	private final int limit = 100;

	/**
	 * standard adjustment, change language at class UserObject
	 * 
	 * @link{setLanguage()
	 */
	private final int language = 0;

	private final File file = new File("data/users.xml");

	// creates a user account and checks before, if id is unique
	public User createUser(String name, String password, String mail) {
		// check if user data is not empty
		if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {

			int idUnique = createUniqueId();
			User user = new User(name, idUnique, limit, password, mail, language);
			user.setRootDir(idUnique);
			userByIdMap.put(idUnique, user);
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

	// changes the mail of the user
	public void setUserEmail(User user, String email) {
		user.setMail(email);
	}

	// sets the limit of the user
	public void setUserLimit(User user, int limit) {
		user.setLimit(limit);
	}

	// changes the actual limit
	public void changeUserLimit(User user, int valueOfChange) {

		int newLimit = (user.getLimit() - valueOfChange);
		user.setLimit(newLimit);

	}

	// get user limit
	public int getLimit(User user) {

		return user.getLimit();

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
				if (name.equals(user.getName()) && password.equals(user.getPassword())) {
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

	// gets User by his Id
	public User getUserById(int userId) {

		for (User user : userByIdMap.values()) {
			if (user != null) {
				if (userId == (user.getId())) {
					return user;
				}
			}
		}

		// else
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
			int idUnique = random.nextInt(100);
			if (!userByIdMap.containsKey(idUnique)) {
				return idUnique;
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

		int iId = user.getId();
		userByIdMap.remove(iId);
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
