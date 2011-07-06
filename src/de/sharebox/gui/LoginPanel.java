package de.sharebox.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is view for the Login. It extends from ChangeablePanel.
 * 
 * @author Eilin, MW * @version 11.06.11
 * 
 * 
 */

public class LoginPanel extends ChangeablePanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = -2633038937425341985L;

	public LoginPanel(final Controller controller) {
		super(controller);
		setLayout(null);
		Font font = new Font("Tahoma", Font.PLAIN, 28);
		Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		// Welcome Label
		JLabel welcomeLabel = new JLabel(
				"Herzlich Willkommen bei ShareBoxUltimate");
		welcomeLabel.setFont(font);
		welcomeLabel.setBounds(42, 11, 620, 91);
		add(welcomeLabel);

		// label statement - what the user have to do
		JLabel loginLabel = new JLabel("Bitte loggen Sie sich ein:");
		loginLabel.setBounds(212, 108, 298, 67);
		loginLabel.setFont(font2);
		add(loginLabel);

		// label statement for registration
		JLabel lblNochKeinLogin = new JLabel(
				"Noch kein Login? Dann melden Sie sich jetzt an:");
		lblNochKeinLogin.setBounds(134, 446, 376, 34);
		lblNochKeinLogin.setFont(font2);
		add(lblNochKeinLogin);

		// text field userName
		final JTextField loginNameField = new JTextField("username");
		loginNameField.addFocusListener(new FocusAdapter() {
			@Override
			// is clearing the field for Users Input
			public void focusGained(FocusEvent arg0) {
				loginNameField.setText("");
			}
		});

		loginNameField
				.setToolTipText("Bitte geben Sie hier ihren Benutzernamen ein");
		loginNameField.setBounds(190, 204, 110, 50);
		add(loginNameField);
		loginNameField.setFont(font2);

		// label text is only shown if login data is invalid
		final JLabel loginFailedLabel = new JLabel("");
		loginFailedLabel.setBounds(239, 157, 300, 50);
		loginFailedLabel.setFont(font2);
		loginFailedLabel.setForeground(Color.red);
		add(loginFailedLabel);

		// text field password
		final JPasswordField loginPasswordField = new JPasswordField("password");
		loginPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			// is clearing the field for Users Input
			public void focusGained(FocusEvent arg0) {
				loginPasswordField.setText("");
			}
		});

		// button login and actionHandling
		JButton loginButton = new JButton("Login");
		loginButton.setToolTipText("Hier klicken zum Einloggen");
		loginButton.setBounds(236, 282, 130, 72);
		add(loginButton);
		loginButton.setFont(font2);
		// button is shown after bad login
		final JButton forgottenLogin = new JButton("");
		forgottenLogin.setForeground(Color.RED);
		forgottenLogin.setFont(font2);
		forgottenLogin.setContentAreaFilled(false);
		forgottenLogin.setBounds(190, 375, 220, 51);
		forgottenLogin
				.setToolTipText("Bitte klicken Sie hier, um ihren Benutzernamen und Passwort zu erfahren");

		loginPasswordField
				.setToolTipText("Bitte geben Sie hier ihr Passwort ein");
		loginPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			// login with pressing enter key after password
			public void keyReleased(KeyEvent evnt) {

				if (evnt.getKeyCode() == KeyEvent.VK_ENTER) {

					String name = loginNameField.getText();
					// string constructor - creates string from charArray

					String password = new String(loginPasswordField
							.getPassword());
					User user = controller.getUser(name, password);

					if (user != null) {

						login(user);
					} else {
						// show error message
						loginFailedLabel.setText("Falsche Login-Daten");
						add(forgottenLogin);
						forgottenLogin.setVisible(true);
						forgottenLogin.setText("Benutzerdaten vergessen?");

						final ActionListener forgottenLoginClickedActionListener = new ActionListener() {
							@Override
							// change the view when user push the register
							// button
							public void actionPerformed(final ActionEvent evntg) {
								changePanel(new ForgottenLoginPanel(controller));
							}
						};
						forgottenLogin
								.addActionListener(forgottenLoginClickedActionListener);
						add(forgottenLogin);
					}
				}
			}
		});
		loginPasswordField.setPreferredSize(new Dimension(53, 20));
		loginPasswordField.setBounds(316, 206, 128, 50);
		add(loginPasswordField);
		loginPasswordField.setFont(font2);

		// button register
		JButton registerButton = new JButton("Registrieren");
		registerButton.setToolTipText("Hier klicken, um sich zu registrieren");
		registerButton.setBounds(156, 508, 322, 50);

		// action-handling register button
		ActionListener registerButtonClickedActionListener = new ActionListener() {
			@Override
			// change the view when user push the register button
			public void actionPerformed(ActionEvent fevent) {

				changePanel(new RegisterPanel(controller));
			}
		};

		registerButton.addActionListener(registerButtonClickedActionListener);
		add(registerButton);

		ActionListener loginButtonClickedActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent eevent) {
				String name = loginNameField.getText();
				// string constructor - creates a string out of an a charArray

				String password = new String(loginPasswordField.getPassword());
				User user = controller.getUser(name, password);

				if (user != null) {

					login(user);

				} else {
					// show error message
					loginFailedLabel.setText("Falsche Login-Daten");
					add(forgottenLogin);
					forgottenLogin.setVisible(true);
					forgottenLogin.setText("Benutzerdaten vergessen?");

					final ActionListener forgottenLoginClickedActionListener = new ActionListener() {
						@Override
						// change the view when user push the register button
						public void actionPerformed(final ActionEvent evntg) {
							changePanel(new ForgottenLoginPanel(controller));
						}
					};
					forgottenLogin
							.addActionListener(forgottenLoginClickedActionListener);
					add(forgottenLogin);
				}
			}

		};

		loginButton.addActionListener(loginButtonClickedActionListener);
	}

	// logs an user in and changes the view
	public void login(User user) {
		UserModel userModel = new UserModel(user);
		changePanel(new HomePanel(controller, userModel));
	}
}
