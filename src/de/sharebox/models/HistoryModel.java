package de.sharebox.models;

import de.sharebox.entities.History;

public class HistoryModel {
	/**
	 * 
	 * @author Eilin
	 * @version 02.07.11
	 */

	private History history;

	public HistoryModel(History history) {
		setHistory(history);
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public History getUser() {
		return history;
	}
}
