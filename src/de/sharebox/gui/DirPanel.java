package de.sharebox.gui;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

/**
 * ?
 * 
 * @author MW
 * @version 1.07.11 class in which the user can see his directories and files
 * 
 */

public class DirPanel extends MenuPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4789182974023884485L;

	public DirPanel(Controller controller, UserModel userModel) {
		super(controller, userModel);
		// shows TreePanel
		TreePanel treePanel = new TreePanel(controller, userModel);
		add(treePanel);
	}
}