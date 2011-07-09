package de.sharebox.entities;

import java.util.Date;

public abstract class AbstractFile {

	private final int userId;

	private final String name;

	private final Date creationDate;

	private Date lastChange;

	private final Dir parent;

	public AbstractFile(int userId, String name, Dir parent) {
		this.userId = userId;
		this.name = name;
		this.parent = parent;
		this.creationDate = new Date();
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public abstract boolean isDir();

	@Override
	public String toString() {
		return name;
	}

	public Dir getParent() {
		return parent;
	}
}
