package de.sharebox.gui;

import java.awt.Font;

import javax.swing.JLabel;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;
import javax.swing.JScrollBar;

/**
 * 
 * This GUI is the view when login was successfully. Extends from
 * ChangeablePanel.
 * 
 * @author MW
 * @version 11.06.11
 * 
 * 
 */

public class HomePanel extends MenuPanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 2268226143091328329L;

	/**
	 * create the home view of the user
	 * 
	 * @param conotroller
	 * @param userModel
	 */
	public HomePanel(Controller controller, UserModel userModel) {
		super(controller, userModel);

		// get the user
		User user = userModel.getUser();

		// label statement welcome
		JLabel label = new JLabel("Herzlich Willkommen, " + user.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(20, 69, 310, 56);
		add(label);

		TreePanel treePanel = new TreePanel(controller);
		add(treePanel);
	

	}
}
