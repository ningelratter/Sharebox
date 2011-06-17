package de.sharebox.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;

import de.sharebox.controller.Controller;
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
	private JTextField password;
	private JTextField mail;
	JFrame frame;
	Popup popup;

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
		Registrieren.addMouseListener(new MouseAdapter() {

			@Override
			// logic - create a user with the input from fields
			public void mouseClicked(MouseEvent arg0) {
				String userName = RegisterPanel.this.userName.getText();
				String password = RegisterPanel.this.password.getText();
				String mail = RegisterPanel.this.mail.getText();

				// checks if mail is valid

				boolean b = mail.contains("@") && mail.contains(".de")
						|| mail.contains("@") && mail.contains(".com")
						|| mail.contains("@") && mail.contains(".fr");

				if (b) {
					// transferred the params to the controller and save it as a
					// user
					User user = controller.createUser(userName, password, mail);

					// create a new UserModel
					UserModel userModel = new UserModel(user);
					// change into HomePanel with the userModel
					changePanel(new HomePanel(controller, userModel));

					// if mail is not valid - Popup is leading back to
					// RegisterPanel
				} else {

					frame = new JFrame("Eingabe der Nutzerdaten nicht korrekt");
					frame.setSize(200, 150);
					frame.setLocation(200, 200);
					PopupFactory factory = PopupFactory.getSharedInstance();
					JButton button;
					popup = factory.getPopup(frame, button = new JButton(
							"Eingabedaten inkorrekt!"), 200, 240);
					popup.show();
					frame.setVisible(true);
					button.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent arg0) {

							RegisterPanel registerPanel = new RegisterPanel(
									controller);
							changePanel(registerPanel);

							frame.setVisible(false);

						}

					});
				}

			}

		});
		setLayout(null);

		// TextField name
		userName = new JTextField();
		userName.setBounds(272, 291, 166, 20);
		add(userName);
		userName.setColumns(10);

		// TextField password
		password = new JTextField();
		password.setBounds(272, 339, 166, 20);
		add(password);
		password.setColumns(10);

		// TextField mail
		mail = new JTextField();
		mail.setBounds(272, 394, 166, 20);
		add(mail);
		mail.setColumns(10);

		// label name
		JLabel lblNewLabel = new JLabel("Benutzername:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(94, 291, 106, 20);
		add(lblNewLabel);

		// label password
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(94, 337, 69, 20);
		add(lblPasswort);

		// label email
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(94, 392, 45, 20);
		add(lblNewLabel_1);

		// label registration
		JLabel lblRegistration = new JLabel("Registration:");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistration.setBounds(210, 84, 218, 65);
		add(lblRegistration);

		// label statement - what the user have to do
		JLabel lblBitteGebenSie = new JLabel(
				"Bitte geben Sie nun folgende f\u00FCr die Registierung notwendigen Daten ein:");
		lblBitteGebenSie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBitteGebenSie.setBounds(52, 191, 521, 20);
		add(lblBitteGebenSie);

		// registered - button
		Registrieren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Registrieren.setBounds(272, 445, 147, 58);
		add(Registrieren);

	}
}