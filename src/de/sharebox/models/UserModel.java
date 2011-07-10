package de.sharebox.models;

import de.sharebox.entities.User;

/**
 * This class sets and gets a model of a user.
 * @author MW, Eilin
 * @version 11.06.11
 */

public class UserModel {

	private User user;

	public UserModel(User user) {
		setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
