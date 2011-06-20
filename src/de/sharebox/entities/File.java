package de.sharebox.entities;

import java.util.Date;

/**
 * Objectclass File :)
 * 
 * @author MW
 * @version 11.06.11
 */

public class File {

	private String name;
	private User owner;
	private Date creationDate;
	private Date lastChange;
	private int id;
	private double size;

	public File(String name, User owner, int id, double size, Date creationDate, Date lastChange) {

		setName(name);
		setOwner(owner);
		setId(id);
		setsize(size);
		setcreationDate(creationDate);
		setlastChange(lastChange);

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setsize(double size) {
		this.size = size;
	}

	public void setcreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setlastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public int getId() {
		return id;
	}

	public double getsize() {
		return size;
	}

	public String getcreationDate() {
		return creationDate.toLocaleString();
	}

	public String getlastChange() {
		return lastChange.toLocaleString();
	}

}