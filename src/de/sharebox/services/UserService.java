package de.sharebox.services;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import de.sharebox.entities.User;

/**
 * 
 * @author Eilin,MW
 * @version 11.06.11
 */
public class UserService {

	// Map for holding users
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

		if (name != null && !name.isEmpty() && password != null
				&& !password.isEmpty()) {

			int id = createUniqueId();
			boolean idCheck = false;

			for (User user : userByIdMap.values()) {
				int i = user.getId();

				if (id == i) {

					idCheck = false;
				} else {
					idCheck = true;
				}
			}
			if (idCheck) {
				User user1 = new User(name, id, limit, password, mail, language);
				userByIdMap.put(id, user1);
				return user1;

			} else {
				// recursive call if id wasn't unique
				createUser(name, password, mail);

			}

		}
		return null;

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
			if (name.equals(user.getName())
					&& password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	// gets User over his mailadress

	public User getUserByMail(String mail) {
		for (User user : userByIdMap.values()) {

			if (mail.equals(user.getMail())) {

				return user;
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
		int id = random.nextInt(100);

		List<String> idList;

	

		return id;
	}

	@SuppressWarnings("unchecked")
	public void loadUsers() {
		try {

			FileInputStream fis = new FileInputStream(file);
			XMLDecoder decoder = new XMLDecoder(fis);
			userByIdMap = (Map<Integer, User>) decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// removes user from data bank and saves the change
	public void removeUser(User user) {

		int i = user.getId();
		userByIdMap.remove(i);
		saveUsers();
		loadUsers();
	}

	public void saveUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			// encoder from java to xml
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(userByIdMap);
			encoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

};
