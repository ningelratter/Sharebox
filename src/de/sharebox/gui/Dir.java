package de.sharebox.gui;

import java.util.Date;
import java.util.List;

/**
 * Objectclass directory
 * @author MW aus Berlin
 * @version 11.06.11
 * 
 */

public class Dir {

	private User owner;
	private String name;
	private Date creationDate;
	private Date lastChange;
	private int id;
	private double size;
	private List<String> userList;
	private List<String> fileList;

	// constructor
	public Dir(String name, User owner, double size, Date creationDate, Date lastChange, int id, List<String> userlist,
			List<String> filelist) {

		setName(name);
		setOwner(owner);
		setSize(size);
		setCreationDate(creationDate);
		setLastChange(lastChange);
		setId(id);
		setUserList(userList);
		setFileList(fileList);

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(User Owner) {
		this.owner = Owner;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;

	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public double getSize() {
		return size;
	}

	public String getCreationDate() {
		return creationDate.toLocaleString();
	}

	public String getLastChange() {
		return lastChange.toLocaleString();
	}

	public int getId() {
		return id;
	}

	public List<String> getUserList() {
		return userList;
	}

	public List<String> getFileList() {
		return fileList;
	}

}
