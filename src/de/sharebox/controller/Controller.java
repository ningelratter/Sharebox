package de.sharebox.controller;

import de.sharebox.gui.User;
import de.sharebox.services.UserService;

public class Controller {

	private UserService userService;

	public Controller() {
		userService = new UserService();
	}

	public User createUser(String name, String password, String mail) {
		return userService.createUser(name, password, mail);
	}

	public User getUser(String name, String password) {
		return userService.getUserByName(name, password);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// das ist erst mal nur zu Testzwecken gewesen!!!
		/*
		 * Date d1 = new Date(99, 9, 1, 12, 22, 22); Date d2 = new Date(100, 3, 3,
		 * 13, 10, 56); Verzeichnis mw = new Verzeichnis("Hallo", "Martin", 2.0, d1,
		 * d2);
		 * 
		 * System.out.println(mw.getName());
		 * System.out.println(mw.getErstellungsdatum());
		 * System.out.println(mw.getLetzteAenderung());
		 * 
		 * Datei mwD = new Datei("Datei", "Martin", 3.0, d1, d2);
		 * 
		 * System.out.println(mwD.getBesitzer()); mwD.setBesitzer("besitzer");
		 * System.out.println(mwD.getBesitzer());
		 * System.out.println(mwD.getErstellungsdatum());
		 */
	}

}
