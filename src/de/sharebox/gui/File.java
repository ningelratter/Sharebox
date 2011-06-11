package de.sharebox.gui;
import java.util.Date;

public class File {
	// Eigenschaften, die eine File hat, alle Privat - über get/set erreichbar
	private String name;
	private User owner;
	private double size;
	private Date creationDate;
	private Date lastChange;
	private int id;
	
	public File(String name,User owner,double size,Date creationDate,Date lastChange,int id){
		
		setName(name);
		setOwner(owner);
		setsize(size);
		setcreationDate(creationDate);
		setlastChange(lastChange);
		setId(id);
				
	}

	public void setcreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getcreationDate() {
		return creationDate.toLocaleString();
	}

	public void setsize(double size) {
		this.size = size;
	}

	public double getsize() {
		return size;
	}

	
	public void setlastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public String getlastChange() {
		return lastChange.toLocaleString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the owner
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
	
}