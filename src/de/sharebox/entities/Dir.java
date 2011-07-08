package de.sharebox.entities;

import java.util.Date;
import java.util.List;

/**
 * Object class directory
 * 
 * @author MW 
 * @version 11.06.11
 * 
 */

public class Dir {

	private User owner;
	private String name;
	private Date creationDate;
	private Date lastChange;
	private int idD;
	private double size;
	private List<String> userList;
	private List<String> fileList;

	// constructor
	public Dir(String name, User owner, double size, Date creationDate,
			Date lastChange, int idD, List<String> userlist,
			List<String> filelist) {

		setName(name);
		setOwner(owner);
		setSize(size);
		setCreationDate(creationDate);
		setLastChange(lastChange);
		setId(idD);
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

	public void setId(int idD) {
		this.idD = idD;
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

	@SuppressWarnings("deprecation")
	public String getCreationDate() {
		return creationDate.toLocaleString();
	}

	@SuppressWarnings("deprecation")
	public String getLastChange() {
		return lastChange.toLocaleString();
	}

	public int getId() {
		return idD;
	}

	public List<String> getUserList() {
		return userList;
	}

	public List<String> getFileList() {
		return fileList;
	}

}
