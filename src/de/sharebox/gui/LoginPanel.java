package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is view for the Login. It extends from ChangeablePanel.
 * 
 * @author Eilin aus Potsdam
 * @version 11.06.11
 * 
 * 
 */

public class LoginPanel extends ChangeablePanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = -2633038937425341985L;

	public LoginPanel(Controller c) {
		super(c);

		setLayout(null);

		// create the loginPanel
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(78, 104, 376, 69);
		add(loginPanel);

		// label statement - what the user have to do
		JLabel loginLabel = new JLabel("Bitte loggen Sie sich ein:");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLabel.setBounds(156, 63, 237, 37);
		add(loginLabel);
		
		// label statement for registration
		JLabel lblNochKeinLogin = new JLabel("noch kein Login? Dann melden Sie sich jetzt an:");
		lblNochKeinLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNochKeinLogin.setBounds(94, 312, 376, 34);
		add(lblNochKeinLogin);
		
		//TODO for MW - für was sind diese Label?
		JLabel label = new JLabel("");
		label.setBounds(231, 63, 0, 0);
		add(label);

		//TODO for MW - für was sind diese Label?
		JLabel label_1 = new JLabel("");
		label_1.setBounds(236, 63, 0, 0);
		add(label_1);


		// text field username
		final JTextField loginNameField = new JTextField("username");
		loginNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginPanel.add(loginNameField);

		// text field password
		final JPasswordField loginPasswordField = new JPasswordField("password");
		loginPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginPanel.add(loginPasswordField);

		
		// button register
		JButton registerButton = new JButton("Registrieren");
		registerButton.setBounds(110, 357, 322, 50);

		// button login and actionhandling
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ActionListener loginButtonClickedActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = loginNameField.getText();
				// string konstruktor - macht aus dem chararray einen string
				String password = new String(loginPasswordField.getPassword());

				User user = controller.getUser(name, password);

				if (user != null) {
					UserModel userModel = new UserModel(user);
					changePanel(new HomePanel(controller, userModel));
				} else {
					// TODO exception: Falsches Passwort in der GUI
				}
			}
		};

		loginButton.addActionListener(loginButtonClickedActionListener);
		loginPanel.add(loginButton);

	
		// actionhandling register button
		ActionListener registerButtonClickedActionListener = new ActionListener() {
			@Override
			// change the view when user push the register button
			public void actionPerformed(ActionEvent f) {
				changePanel(new RegisterPanel(controller));
			}
		};

		registerButton.addActionListener(registerButtonClickedActionListener);
		add(registerButton);

	}
}