/**
 * 
 */
package de.sharebox.models;

import de.sharebox.gui.User;

/**
 * @author MW
 * 
 */
public class UserModel {

	private User user;

	public UserModel(User user) {
		setUser(user);
	}

	// gibt den Besitzer (Owner) einer Datei (file) zurück
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
