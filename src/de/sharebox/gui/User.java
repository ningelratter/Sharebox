package de.sharebox.gui;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private double limit;
	private List<String> dirList = new ArrayList<String>();
	private String password;
	private String mail;
	private int language;
	private int id;

	// private List history;
	public User() {
	}

	public User(String name, int id, double limit, String password, String mail, int language) {

		setName(name);
		setId(id);
		setLimit(limit);
		setPassword(password);
		setMail(mail);
		setLanguage(language);
	}

	/**
	 * @param name
	 *          the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param limit
	 *          the limit to set
	 */
	public void setLimit(double limit) {
		this.limit = limit;
	}

	/**
	 * @return the limit
	 */
	public double getLimit() {
		return limit;
	}

	/**
	 * @param dirList
	 *          the dirList to set
	 */
	public void setDirList(List<String> dirList) {
		this.dirList = dirList;
	}

	/**
	 * @return the verzeichnisListe
	 */
	public List<String> getDirList() {
		return dirList;
	}

	public void addDir(String dir) {
		dirList.add(dir);
	}

	/**
	 * @param passwort
	 *          the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param email
	 *          the email to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the email
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param sprache
	 *          the sprache to set
	 */
	public void setLanguage(int language) {
		this.language = language;
	}

	/**
	 * @return the language
	 */
	public int getLanguage() {
		return language;
	}

	/**
	 * @param id
	 *          the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
