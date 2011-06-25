/**
 * 
 */
package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * @author MW
 * 
 */
// class in which the user can change the properties
public class UserProperties extends MenuPanel {

	// every GUI class has to have a UID to verify
	private static final long serialVersionUID = 2342342341L;
	private JTextField benutzerField;
	private JTextField passwordField;
	private JList languageList;
	private JTextField limitField;
	private JTextField emailField;

	public UserProperties(final Controller controller, UserModel userModel) {

		super(controller, userModel);
		final User user = userModel.getUser();

		JLabel welcomeUserText = new JLabel(
				"Hier k\u00F6nnen Sie die Einstellungen für: " + user.getName()
						+ " \u00E4ndern!");
		welcomeUserText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeUserText.setBounds(25, 33, 615, 54);
		add(welcomeUserText);

		JLabel lblUsername = new JLabel("Benutzername:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(25, 116, 115, 34);
		add(lblUsername);

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(25, 169, 115, 34);
		add(lblPasswort);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(25, 230, 115, 34);
		add(lblEmail);

		JLabel lblSprache = new JLabel("Sprache:");
		lblSprache.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSprache.setBounds(25, 364, 115, 34);
		add(lblSprache);

		JLabel lblLimit = new JLabel("Limit:");
		lblLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLimit.setBounds(25, 298, 115, 34);
		add(lblLimit);

		benutzerField = new JTextField();
		benutzerField.setToolTipText("Hier neuen Benutzernamen eingeben");
		benutzerField.setBounds(168, 118, 203, 34);
		add(benutzerField);
		benutzerField.setColumns(10);

		passwordField = new JTextField();
		passwordField.setToolTipText("Hier neues Passwort eigeben");
		passwordField.setColumns(10);
		passwordField.setBounds(168, 171, 203, 34);
		add(passwordField);

		emailField = new JTextField();
		emailField.setToolTipText("Hier neues Passwort eigeben");
		emailField.setColumns(10);
		emailField.setBounds(168, 232, 203, 34);
		add(emailField);

		final JLabel currentUserName = new JLabel("");
		currentUserName.setToolTipText("aktueller Benutzername");
		currentUserName.setBounds(25, 144, 115, 34);
		add(currentUserName);
		currentUserName.setText(user.getName());

		languageList = new JList();
		languageList
				.setToolTipText("w\u00E4hlen Sie die gew\u00FCnschte Sprache in der ihre ShareBoxUltimate angezeigt werden soll");
		languageList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		languageList.setName("");
		languageList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Deutsch = 0", "Englisch = 1", "Franz\u00F6sisch = 2", "Spanisch = 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		languageList.setBounds(168, 364, 203, 76);
		add(languageList);

		limitField = new JTextField();
		limitField.setColumns(10);
		limitField.setBounds(168, 300, 203, 34);
		add(limitField);

		JButton einstellungenndern = new JButton("Einstellungen \u00E4ndern");
		einstellungenndern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				changeUserName(user);
				changeUserPassword(user);
				changeUserEmail(user);
				controller.saveData();
				currentUserName.repaint();
			}
		});
		einstellungenndern
				.setToolTipText("Hier klicken, wenn die get\u00E4tigten Einstellungen \u00FCbernommen werden sollen");
		einstellungenndern.setFont(new Font("Tahoma", Font.PLAIN, 18));
		einstellungenndern.setBounds(168, 493, 238, 54);
		add(einstellungenndern);

		JLabel currentPassword = new JLabel((String) null);
		currentPassword.setToolTipText("aktuelles Passwort");
		currentPassword.setBounds(25, 199, 115, 34);
		add(currentPassword);
		currentPassword.setText(user.getPassword());

		JLabel currentMail = new JLabel((String) null);
		currentMail.setToolTipText("aktuelle Emailadresse");
		currentMail.setBounds(25, 263, 115, 34);
		add(currentMail);
		currentMail.setText(user.getMail());

		JLabel currentLimit = new JLabel((String) null);
		currentLimit.setToolTipText("aktuelles Limit");
		currentLimit.setBounds(25, 330, 115, 34);
		add(currentLimit);
		double d = user.getLimit();
		String s = String.valueOf(d);
		currentLimit.setText(s);

		JLabel currentLanguage = new JLabel((String) null);
		currentLanguage.setToolTipText("aktuell eingestellte Sprache");
		currentLanguage.setBounds(25, 406, 115, 34);
		add(currentLanguage);
		int i = user.getLanguage();
		String s1 = String.valueOf(i);
		currentLanguage.setText(s1);

	}

	// is setting the new userName
	public void changeUserName(User user) {

		String name = benutzerField.getText();
		if (name != null) {
			controller.setUserName(user, name);
		}
	}

	// is setting the new password
	public void changeUserPassword(User user) {

		String password = passwordField.getText();
		if (password.length() <= 5 && password.length() <= 12) {
			controller.setUserPassword(user, password);
		}
	}

	// is setting the new mailadress
	public void changeUserEmail(User user) {
		String email = emailField.getText();
		if (email != null) {
			controller.setUserEmail(user, email);
		}
	}

}
