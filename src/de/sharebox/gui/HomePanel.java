package de.sharebox.gui;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

public class HomePanel extends ChangeablePanel {

	private static final long serialVersionUID = 2268226143091328329L;

	public HomePanel(Controller c, UserModel userModel) {
		super(c);

		setLayout(null);

		User user = userModel.getUser();

		JLabel label = new JLabel("Herzlich Willkommen, " + user.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(20, 69, 310, 56);
		add(label);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}