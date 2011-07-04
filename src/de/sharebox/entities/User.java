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

	private int id;
	private int language;
	private double limit;
	private String name;
	private String password;
	private String mail;
	private List<String> dirList = new ArrayList<String>();

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

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLimit(double limit) {
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
		return id;
	}

	public double getLimit() {
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
		return id + ": " + name;
	}

	public void setRootDir(int id) {

		DirService.createRootDirLocation(id);

	}

	public String getRootDir() {
		String userId = String.valueOf(id);
		return (System.getProperty("user.dir")+"\\"+userId);
	}

}
