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

	public User createUser(String name, String password, String mail) {

		if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
			int id = createUniqueId();
			User user = new User(name, id, limit, password, mail, language);
			userByIdMap.put(id, user);

			// TODO insert....

			// System.out.println(user.getMail());

			return user;
		} else {
			return null;
		}
	}

	/**
	 * get the user
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public User getUserByName(String name, String password) {
		for (User user : userByIdMap.values()) {
			if (name.equals(user.getName()) && password.equals(user.getPassword())) {
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
	private int createUniqueId() {
		Random random = new Random();
		int id = random.nextInt(100);

		List<String> idList;

		// TODO checken, ob id schon vergeben...

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
