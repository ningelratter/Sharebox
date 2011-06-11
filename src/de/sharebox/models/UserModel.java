package de.sharebox.models;

import de.sharebox.gui.User;

/**
 * 
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
