/**
 * 
 */
package de.sharebox.services;

import java.util.Random;

import de.sharebox.gui.User;

/**
 * @author MW
 * 
 */
public class UserService {

	private double limit = 2.0; // Limit für neuregistrierte Nutzer - kann unter

	private int language = 0; // Standardeinstellung kann unter Optionen geändert
														// werden

	public User createUser(String name, String password, String mail) {

		int id = createUniqueId();
		User user = new User(name, id, limit, password, mail, language);

		// insert....

		System.out.println(user.getMail());

		return user;
	}

	public User getUserByName(String name, String password) {
		return null;
	}

	private int createUniqueId() {
		Random random = new Random();
		int id = random.nextInt(100);

		// TODO checken, ob id schon vergeben...

		return id;
	}

};
