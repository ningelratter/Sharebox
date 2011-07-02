package de.sharebox.entities;

import java.util.Date;

/**
 * Objectclass history
 * 
 * @author Eilin
 * @version 02.07.11
 * 
 */

public class History {

	private int userId;
	private Date date;
	private String activity;

	public History(int userName, Date date, String activity) {

		setUser(userId);
		setDate(date);
		setActivity(activity);
	}

	public void setUser(int userId) {
		this.userId = userId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getUser() {
		return userId;
	}

	public Date getDate() {
		return date;
	}

	public String getActivity() {
		return activity;
	}
}
