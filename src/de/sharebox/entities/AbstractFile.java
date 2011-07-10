package de.sharebox.entities;

import java.util.Date;

public abstract class AbstractFile {

	private int userId;

	private String name;

	private Date creationDate;

	private Date lastChange;

	private transient Dir parent;

	public AbstractFile() {
	}

	public AbstractFile(int userId, String name, Dir parent) {
		this.userId = userId;
		this.name = name;
		this.parent = parent;
		this.creationDate = new Date();
		this.lastChange = new Date();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	@Override
	public String toString() {
		return name;
	}

	public Dir getParent() {
		return parent;
	}

	public void setParent(Dir parent) {
		this.parent = parent;
	}

	public abstract boolean isDir();
}
