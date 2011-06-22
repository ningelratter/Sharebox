package de.sharebox.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * This GUI is view for the Login. It extends from ChangeablePanel.
 * 
 * @author Eilin,MW * @version 11.06.11
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

		// Welcome Label
		JLabel lblHerzlichWillkommenBei = new JLabel("Herzlich Willkommen bei ShareBoxUltimate");
		lblHerzlichWillkommenBei.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblHerzlichWillkommenBei.setBounds(42, 11, 620, 91);
		add(lblHerzlichWillkommenBei);

		// label statement - what the user have to do
		JLabel loginLabel = new JLabel("Bitte loggen Sie sich ein:");
		loginLabel.setBounds(212, 108, 298, 67);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(loginLabel);

		// label statement for registration
		JLabel lblNochKeinLogin = new JLabel("noch kein Login? Dann melden Sie sich jetzt an:");
		lblNochKeinLogin.setBounds(134, 446, 376, 34);
		lblNochKeinLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNochKeinLogin);

		// text field username
		final JTextField loginNameField = new JTextField("username");
		loginNameField.setBounds(190, 204, 110, 50);
		add(loginNameField);
		loginNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));

		// text field password
		final JPasswordField loginPasswordField = new JPasswordField("password");
		loginPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			//login with pressing enter key after password
			public void keyReleased(KeyEvent e) {
			
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {

						String name = loginNameField.getText();
						// string konstruktor - macht aus dem chararray einen string

						String password = new String(loginPasswordField.getPassword());
						User user = controller.getUser(name, password);

						if (user != null) {
							UserModel userModel = new UserModel(user);
							changePanel(new HomePanel(controller, userModel));
						} 
					}
			}
		});
		loginPasswordField.setPreferredSize(new Dimension(53, 20));
		loginPasswordField.setBounds(316, 206, 128, 50);
		add(loginPasswordField);
		loginPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));

		// labe text is only shown if login data is invalid
		final JLabel loginFailedLabel = new JLabel("");
		loginFailedLabel.setBounds(200, 160, 300, 50);
		loginFailedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginFailedLabel.setForeground(Color.red);
		add(loginFailedLabel);

		// button register
		JButton registerButton = new JButton("Registrieren");
		registerButton.setBounds(156, 508, 322, 50);

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

		// button login and actionhandling
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(236, 282, 130, 72);
		add(loginButton);
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
					// show error message
					loginFailedLabel.setText("Falsche Login-Daten du Pfeife...");
				}
			}
		};

		loginButton.addActionListener(loginButtonClickedActionListener);

	}
}