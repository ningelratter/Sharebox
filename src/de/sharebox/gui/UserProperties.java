/**
 * 
 */
package de.sharebox.gui;

import javax.swing.JToolBar;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

/**
 * @author MW
 * 
 */
// class in which the user can change the properties
public class UserProperties extends ChangeablePanel {

	// every GUI class has to have a UID to verify
	private static final long serialVersionUID = 2342342341L;

	public UserProperties(Controller controller, UserModel userModel) {

		super(controller);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(64, 71, 379, 205);
		add(toolBar);
	}
}
