package de.sharebox.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is the first view if a user want to register himself. Extends from
 * ChangeablePanel.
 * 
 * @author Eilin, MW
 * @version 11.06.11
 * 
 * 
 */

public class RegisterPanel extends ChangeablePanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 2135442992970725951L;

	private final JTextField usernameField;

	private final JTextField mailField;

	private final JPasswordField passwordField;

	private final JLabel wrongUserLabel;

	private final JLabel wrongMailLabel;

	private final JLabel wrongPasswordLabel;

	/**
	 * Creates the view for registration.
	 * 
	 * @param c
	 */
	public RegisterPanel(final Controller controller) {
		super(controller);

		Font font = new Font("Tahoma", Font.PLAIN, 14);
		Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		Font font3 = new Font("Tahoma", Font.BOLD, 20);

		// design of the view
		setForeground(Color.WHITE);
		setPreferredSize(new Dimension(640, 680));
		setSize(new Dimension(640, 680));

		// button registered
		JButton registerButton = new JButton("Registrieren");
		registerButton.setToolTipText("Alle Daten eingeben? Dann los!");

		/**
		 * When button register is clicked a user with the input from fields is
		 * creating and the user is registered.
		 */
		registerButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				userRegistration();
			}
		});

		setLayout(null);

		// text field name
		usernameField = new JTextField();
		usernameField.setBounds(272, 291, 166, 20);
		add(usernameField);
		usernameField.setColumns(10);

		wrongUserLabel = new JLabel("ung\u00FCltiger Benutzername");
		// error label user
		wrongUserLabel.setForeground(Color.RED);
		wrongUserLabel.setFont(font);
		wrongUserLabel.setBounds(272, 270, 200, 20);
		wrongUserLabel.setVisible(false);
		add(wrongUserLabel);

		// text field password
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 340, 166, 20);
		add(passwordField);

		// error label password
		wrongPasswordLabel = new JLabel("ung\u00FCltiges Passwort");
		wrongPasswordLabel.setForeground(Color.RED);
		wrongPasswordLabel.setFont(font);
		wrongPasswordLabel.setBounds(272, 320, 200, 20);
		wrongPasswordLabel.setVisible(false);
		add(wrongPasswordLabel);

		// text field mail
		mailField = new JTextField();

		/**
		 * Finish registration with Enter after filling the mail field with input.
		 * With enter and true details the view change to the home panel.
		 */
		mailField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent eevent) {
				if (eevent.getKeyCode() == KeyEvent.VK_ENTER) {
					userRegistration();
				}
			}
		});

		// textfield mail
		mailField.setBounds(272, 390, 166, 20);
		mailField.setColumns(10);
		add(mailField);

		// if the user details aren't ok a advance notice is shown/created
		wrongMailLabel = new JLabel("ung\u00FCltige Email");
		wrongMailLabel.setForeground(Color.RED);
		wrongMailLabel.setFont(font);
		wrongMailLabel.setBounds(272, 370, 200, 20);
		wrongMailLabel.setVisible(false);
		add(wrongMailLabel);

		// create label name
		JLabel usernameLabel = new JLabel("Benutzername:");
		usernameLabel.setFont(font2);
		usernameLabel.setBounds(94, 291, 106, 20);
		add(usernameLabel);

		// create label password
		JLabel passwortLabel = new JLabel("Passwort:");
		passwortLabel.setFont(font2);
		passwortLabel.setBounds(94, 337, 69, 20);
		add(passwortLabel);

		// create label email
		JLabel mailLabel = new JLabel("Email:");
		mailLabel.setFont(font2);
		mailLabel.setBounds(94, 392, 45, 20);
		add(mailLabel);

		// create label registration
		JLabel registerLabel = new JLabel("Registration:");
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setFont(font3);
		registerLabel.setBounds(210, 84, 218, 65);
		add(registerLabel);

		// create label statement - what the user have to do
		JLabel enterDataLabel = new JLabel("Bitte geben Sie nun folgende f\u00FCr die Registrierung notwendigen Daten ein:");
		enterDataLabel.setFont(font2);
		enterDataLabel.setBounds(52, 191, 541, 20);
		add(enterDataLabel);

		// create registered - button
		registerButton.setFont(font2);
		registerButton.setBounds(272, 445, 147, 58);
		add(registerButton);

		// create new login-button
		JButton backToLogin = new JButton("Login");
		/**
		 * Leads back to LoginPanel-Vie when clicked the button login.
		 */
		backToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent yevent) {
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);

			}
		});
		// create label statement for login button
		backToLogin.setToolTipText("Zurueck zum Login");
		backToLogin.setBounds(297, 562, 89, 23);
		add(backToLogin);

		// shows a help message with the right input format
		JLabel helpMessage = new JLabel("");
		helpMessage.setForeground(Color.BLACK);
		helpMessage.setFont(font);
		helpMessage.setBounds(177, 220, 400, 50);
		add(helpMessage);
		helpMessage.setText("Hinweis:" + "Benutzername/Passwort: 5-12 Zeichen");
	}

	/**
	 * Gets the input from fields and tries to register a user with this input.
	 * Method checks if all details are valid.
	 */
	public void userRegistration() {

		String userName = usernameField.getText();
		String password = new String(passwordField.getPassword());
		String mail = mailField.getText();

		// checks if mail is valid (an arbitrary string (\\w+) + @ + an
		// arbitrary
		// string (\\w+) + . + valid suffix
		boolean validEmail = mail.matches("\\w+@\\w+\\.(de|com|fr|net)");

		int nameLength = userName.length();
		boolean validUserName = (5 <= nameLength && 12 >= nameLength);

		// checks if password is valid
		int passwordLength = password.length();
		boolean validPassword = (5 <= passwordLength && 12 >= passwordLength);

		// everything is valid
		if (validEmail && validUserName && validPassword) {
			// transferred the params to the controller and save it as a
			// user
			User user = controller.createUser(userName, password, mail);
			// create a new UserModel
			UserModel userModel = new UserModel(user);
			// change into HomePanel with the userModel
			changePanel(new HomePanel(controller, userModel));
		} else {
			wrongUserLabel.setVisible(!validUserName);
			wrongPasswordLabel.setVisible(!validPassword);
			// is shown when password is to short
			wrongMailLabel.setVisible(!validEmail);
		}
	}
}
