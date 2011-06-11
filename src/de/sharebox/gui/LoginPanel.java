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

public class LoginPanel extends ChangeablePanel {

	private static final long serialVersionUID = -2633038937425341985L;

	public LoginPanel(Controller c) {
		super(c);
		setLayout(null);

		JLabel loginLabel = new JLabel("Bitte loggen Sie sich ein:");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLabel.setBounds(156, 63, 237, 37);
		add(loginLabel);

		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(78, 104, 376, 69);

		final JTextField loginNameField = new JTextField("username");
		loginPanel.add(loginNameField);

		final JPasswordField loginPasswordField = new JPasswordField("password");
		loginPanel.add(loginPasswordField);

		JButton loginButton = new JButton("Login");
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
					// Fehlermeldung: Falsches Passwort in der GUI
				}
			}
		};
		ActionListener registerButtonClickedActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent f) {
				changePanel(new RegisterPanel(controller));
			}
		};

		JLabel label = new JLabel("");
		label.setBounds(231, 63, 0, 0);
		add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(236, 63, 0, 0);
		add(label_1);

		add(loginPanel);

		loginButton.addActionListener(loginButtonClickedActionListener);
		loginPanel.add(loginButton);

		JButton registerButton = new JButton("Registrieren");
		registerButton.setBounds(110, 357, 322, 50);

		registerButton.addActionListener(registerButtonClickedActionListener);
		add(registerButton);

		JLabel lblNochKeinLogin = new JLabel("noch kein Login? Dann melden Sie sich jetzt an:");
		lblNochKeinLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNochKeinLogin.setBounds(94, 312, 376, 34);
		add(lblNochKeinLogin);
	}
}