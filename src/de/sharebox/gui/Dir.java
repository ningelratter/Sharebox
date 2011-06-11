package de.sharebox.gui;

import java.awt.List;
import java.util.Date;

public class Dir {
	/** Eigenschaften, die ein Verzeichnis (Dir = Directory) hat, alle Privat - über get/set erreichbar*/
	private String name;
	private User owner;
	private double size;
	private Date creationDate;
	private Date lastChange;
	private int id;
	private List userList;
	private List fileList;

	// Konstruktor
	public Dir(String name, User user, double size,Date creationDate, Date lastChange,int id,List userlist,List filelist) {

		setName(name);
		setOwner(owner);
		setSize(size);
		setCreationDate(creationDate);
		setLastChange(lastChange);
		setId(id);
		setUserList(userList);
		setFileList(fileList);

	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param size
	 *            the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate.toLocaleString();
	}


	/**
	 * @param lastChange
	 *            the lastChange to set
	 */
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	/**
	 * @return the lastChange
	 */
	public String getLastChange() {
		return lastChange.toLocaleString();
	}

	/**
	 * @param Owner the Owner to set
	 */
	public void setOwner(User Owner) {
		this.owner = Owner;
	}

	/**
	 * @return the Owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param id the id to set
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

	/**
	 * @param nutzer the nutzerliste to set
	 */
	public void setUserList(List userList) {
		this.userList = userList;
	}

	/**
	 * @return the userList
	 */
	public List getUserList() {
		return userList;
	}

	/**
	 * @param fileList the fileList to set
	 */
	public void setFileList(List fileList) {
		this.fileList = fileList;
	}

	/**
	 * @return the fileList
	 */
	public List getFileList() {
		return fileList;
	}

}
