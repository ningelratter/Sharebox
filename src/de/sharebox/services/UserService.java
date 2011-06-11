/**
 * 
 */
package de.sharebox.services;

import java.util.Random;

import com.sun.tools.javac.util.List;

import de.sharebox.gui.User;

/**
 * 
 * @author MW
 * @version 11.06.11
 */
public class UserService {

	/**
	 * standart adjustment for new users
	 */	
	private double limit = 2.0;
	
	/**
	 * standart adjustment, change language at class UserObject @link{setLanguage()}
	 */
	private int language = 0;

	public User createUser(String name, String password, String mail) {

		int id = createUniqueId();
		User user = new User(name, id, limit, password, mail, language);

		// TODO insert....

		System.out.println(user.getMail());

		return user;
	}

	/**
	 * get the user
	 * @param name
	 * @param password
	 * @return
	 */
	public User getUserByName(String name, String password) {
		// TODO for Eilin
		return null;
	}

	/**
	 * create a id
	 * @return id
	 */
	private int createUniqueId() {
		Random random = new Random();
		int id = random.nextInt(100);
		
		List<String> idList;
		
		
		
		// TODO checken, ob id schon vergeben...

		return id;
	}

};
