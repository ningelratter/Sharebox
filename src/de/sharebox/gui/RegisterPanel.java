package de.sharebox.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

public class RegisterPanel extends ChangeablePanel {

	private static final long serialVersionUID = 2135442992970725951L;

	private JTextField userName;
	private JTextField password;
	private JTextField mail;

	public RegisterPanel(Controller c) {
		super(c);

		setForeground(Color.WHITE);
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setPreferredSize(new Dimension(640, 680));
		setSize(new Dimension(640, 680));

		JButton Registrieren = new JButton("Registrieren");
		Registrieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String userName = RegisterPanel.this.userName.getText();
				System.out.println(userName);
				String password = RegisterPanel.this.password.getText();
				String mail = RegisterPanel.this.mail.getText();

				User user = controller.createUser(userName, password, mail);

				UserModel userModel = new UserModel(user);
				changePanel(new HomePanel(controller, userModel));
			}
		});
		Registrieren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Registrieren.setBounds(267, 499, 159, 48);
		add(Registrieren);

		userName = new JTextField();
		userName.setBounds(213, 186, 248, 36);
		add(userName);
		userName.setColumns(10);

		password = new JTextField();
		password.setBounds(219, 271, 242, 36);
		add(password);
		password.setColumns(10);

		JLabel lblNewLabel = new JLabel("Benutzername:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 184, 109, 36);
		add(lblNewLabel);

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(37, 273, 109, 29);
		add(lblPasswort);

		JLabel lblBitteGebenSie = new JLabel(
				"Bitte geben Sie nun folgende f\u00FCr die Registierung notwendigen Daten ein:");
		lblBitteGebenSie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBitteGebenSie.setBounds(20, 91, 521, 64);
		add(lblBitteGebenSie);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 386, 46, 14);
		add(lblNewLabel_1);

		mail = new JTextField();
		mail.setBounds(219, 364, 242, 36);
		add(mail);
		mail.setColumns(10);

		JLabel lblRegistration = new JLabel("Registration:");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistration.setBounds(37, 41, 504, 53);
		add(lblRegistration);
	}
}