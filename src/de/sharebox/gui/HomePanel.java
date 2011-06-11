package de.sharebox.gui;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;


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

public class HomePanel extends ChangeablePanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 2268226143091328329L;

	/**
	 *create the home view of the user
	 * @param c
	 * @param userModel
	 */
	public HomePanel(Controller c, UserModel userModel) {
		super(c);

		setLayout(null);

		//get the user
		User user = userModel.getUser();

		//label statement welcome
		JLabel label = new JLabel("Herzlich Willkommen, " + user.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(20, 69, 310, 56);
		add(label);

	}

	/**
	 * function????
	 * @author MW
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}