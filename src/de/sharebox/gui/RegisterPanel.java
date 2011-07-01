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
 * ChangeablePanel. :)
 * 
 * @author Eilin,MW
 * @version 11.06.11
 * 
 * 
 */

public class RegisterPanel extends ChangeablePanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 2135442992970725951L;

	private JTextField userName;
	private JTextField mail;
	private JPasswordField password;

	/**
	 * creates the view for registration
	 * 
	 * @param c
	 */
	public RegisterPanel(Controller c) {
		super(c);

		// design of the view
		setForeground(Color.WHITE);
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setPreferredSize(new Dimension(640, 680));
		setSize(new Dimension(640, 680));

		// button registered
		JButton Registrieren = new JButton("Registrieren");
		Registrieren.setToolTipText("Alle Daten eingeben? Dann los!");
		Registrieren.addMouseListener(new MouseAdapter() {

			@Override
			// logic - create a user with the input from fields
			public void mouseClicked(MouseEvent arg0) {

				userRegistration();
			}
		});

		setLayout(null);

		// TextField name
		userName = new JTextField();
		userName.setBounds(272, 291, 166, 20);
		add(userName);
		userName.setColumns(10);
		// TExtField password
		password = new JPasswordField();
		password.setBounds(272, 339, 166, 20);
		add(password);

		// TextField mail
		mail = new JTextField();
		// finish registration with Enter
		mail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					userRegistration();
				}
			}
		});

		mail.setBounds(272, 394, 166, 20);
		add(mail);
		mail.setColumns(10);

		// label name
		JLabel Benutzername = new JLabel("Benutzername:");
		Benutzername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Benutzername.setBounds(94, 291, 106, 20);
		add(Benutzername);

		// label password
		JLabel Passwort = new JLabel("Passwort:");
		Passwort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Passwort.setBounds(94, 337, 69, 20);
		add(Passwort);

		// label email
		JLabel Email = new JLabel("Email:");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setBounds(94, 392, 45, 20);
		add(Email);

		// label registration
		JLabel Registration = new JLabel("Registration:");
		Registration.setHorizontalAlignment(SwingConstants.CENTER);
		Registration.setFont(new Font("Tahoma", Font.BOLD, 20));
		Registration.setBounds(210, 84, 218, 65);
		add(Registration);

		// label statement - what the user have to do
		JLabel BitteGebenSie = new JLabel(
				"Bitte geben Sie nun folgende f\u00FCr die Registrierung notwendigen Daten ein:");
		BitteGebenSie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BitteGebenSie.setBounds(52, 191, 541, 20);
		add(BitteGebenSie);

		// registered - button
		Registrieren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Registrieren.setBounds(272, 445, 147, 58);
		add(Registrieren);
		// login-button leads back to LoginPanel-View
		JButton backToLogin = new JButton("Login");
		backToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent y) {
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);

			}
		});
		backToLogin.setToolTipText("Zur\u00FCck zum Login");
		backToLogin.setBounds(297, 562, 89, 23);
		add(backToLogin);

	}

	// gets the input from Fields and tries to register a user with input
	public void userRegistration() {

		String userName = RegisterPanel.this.userName.getText();
		@SuppressWarnings("deprecation")
		String password = RegisterPanel.this.password.getText();
		String mail = RegisterPanel.this.mail.getText();

		// checks if mail is valid

		boolean validEmail = mail.contains("@") && mail.contains(".de")
				|| mail.contains("@") && mail.contains(".com")
				|| mail.contains("@") && mail.contains(".fr")
				|| mail.contains("@") && mail.contains(".net");
		boolean validUserName = false;
		int lengthUser = userName.length();
		validUserName = (5 <= lengthUser && 12 >= lengthUser);

		boolean validPassword = false;
		int lengthPwd = password.length();
		validPassword = (5 <= lengthPwd && 12 >= lengthPwd);

		if (validEmail && validUserName && validPassword) {
			// transferred the params to the controller and save it as a
			// user
			User user = controller.createUser(userName, password, mail);
			// check if UserName is between 5-12 characters

			// create a new UserModel
			UserModel userModel = new UserModel(user);
			// change into HomePanel with the userModel
			changePanel(new HomePanel(controller, userModel));

		}

		// if mail is not valid - Popup is leading back to
		// RegisterPanel
		else {

			if (validEmail == false) {
				// is shown when password is to short
				// error label email
				JLabel wrongEmail = new JLabel("");
				wrongEmail.setForeground(Color.RED);
				wrongEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
				wrongEmail.setBounds(446, 394, 147, 20);
				add(wrongEmail);
				wrongEmail.setText("ungültige Email");

			}
			if (validUserName == false) {
				// error label user
				JLabel wrongUser = new JLabel("");
				wrongUser.setForeground(Color.RED);
				wrongUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
				wrongUser.setBounds(446, 291, 147, 20);
				add(wrongUser);
				wrongUser.setText("ungültiger Benutzername");
			}
			if (validPassword == false) {
				// error label password
				JLabel wrongPassword = new JLabel("");
				wrongPassword.setForeground(Color.RED);
				wrongPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
				wrongPassword.setBounds(448, 339, 147, 20);
				add(wrongPassword);
				wrongPassword.setText("ungültiges Passwort");

			}
			// shows a helpMessage with the right input format
			JLabel helpMessage = new JLabel("");
			helpMessage.setForeground(Color.RED);
			helpMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
			helpMessage.setBounds(177, 519, 400, 50);
			add(helpMessage);
			helpMessage.setText("Hinweis:"
					+ "Benutzername/Passwort: 5-12 Zeichen");
		}

	}
}
