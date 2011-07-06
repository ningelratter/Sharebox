package de.sharebox.entities;

import java.util.ArrayList;
import java.util.List;

import de.sharebox.services.DirService;

/**
 * 
 * Object class user
 * 
 * @author MW
 * @version 11.06.11
 * 
 * 
 */

public class User {

	private int idU;
	private int language;
	private int limit;
	private String name;
	private String password;
	private String mail;
	private List<String> dirList = new ArrayList<String>();

	public User() {
		// standard constructor

	}

	public User(String name, int idU, int limit, String password, String mail,
			int language) {

		setName(name);
		setId(idU);
		setLimit(limit);
		setPassword(password);
		setMail(mail);
		setLanguage(language);

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int idU) {
		this.idU = idU;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setDirList(List<String> dirList) {
		this.dirList = dirList;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	/**
	 * add a directory to a user
	 * 
	 * @author Eilin
	 * @param dir
	 */
	public void addDir(String dir) {
		dirList.add(dir);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return idU;
	}

	public int getLimit() {
		return limit;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public int getLanguage() {
		return language;
	}

	public List<String> getDirList() {
		return dirList;
	}

	@Override
	public String toString() {
		return idU + ": " + name;
	}

	public void setRootDir(int idU) {

		DirService.createRootDirLocation(idU);

	}

	public String getRootDir() {
		String userId = String.valueOf(idU);
		return (System.getProperty("user.dir") + "\\" + userId);
	}

}
