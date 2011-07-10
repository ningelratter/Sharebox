package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * This class change the properties of a user.
 * 
 * @author MW
 * @version 28.06.2011
 * 
 */
public class UserPropertiesPanel extends MenuPanel {

	// every GUI class has to have a UID to verify
	private static final long serialVersionUID = 2342342341L;
	private final JTextField userField;
	private final JTextField passwordField;
	private final JList languageList;

	private final JTextField emailField;
	private final User user;

	public UserPropertiesPanel(final Controller controller, final UserModel userModel) {

		super(controller, userModel);
		user = userModel.getUser();

		Font font = new Font("Tahoma", Font.PLAIN, 18);
		Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		Font font3 = new Font("Tahoma", Font.PLAIN, 14);

		JLabel welcomeUserText =
				new JLabel("Hier k\u00F6nnen Sie die Einstellungen f\u00FCr " + user.getName() + " \u00E4ndern!");

		welcomeUserText.setFont(font);
		welcomeUserText.setBounds(25, 33, 615, 54);
		add(welcomeUserText);

		JLabel lblUsername = new JLabel("Benutzername:");
		lblUsername.setFont(font2);
		lblUsername.setBounds(25, 120, 115, 34);
		add(lblUsername);

		userField = new JTextField();
		userField.setToolTipText("Hier neuen Benutzernamen eingeben");
		userField.setText(user.getName());
		userField.setBounds(168, 120, 203, 34);
		userField.setColumns(10);
		add(userField);

		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(font2);
		lblPasswort.setBounds(25, 170, 115, 34);
		add(lblPasswort);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Hier neues Passwort eigeben");
		passwordField.setColumns(10);
		passwordField.setBounds(168, 170, 203, 34);
		add(passwordField);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(font2);
		lblEmail.setBounds(25, 220, 115, 34);
		add(lblEmail);

		emailField = new JTextField(user.getMail());
		emailField.setToolTipText("Hier neues Emailadresse eigeben");
		emailField.setColumns(10);
		emailField.setBounds(168, 220, 203, 34);
		add(emailField);

		JLabel lblSprache = new JLabel("Sprache:");
		lblSprache.setFont(font2);
		lblSprache.setBounds(25, 270, 115, 34);
		add(lblSprache);

		languageList = new JList();
		languageList
				.setToolTipText("Waehlen Sie die gewuenschte Sprache in der ihre ShareBoxUltimate angezeigt werden soll");
		languageList.setFont(font3);

		languageList.setModel(new AbstractListModel() {

			private static final long serialVersionUID = -3117312090257427767L;

			String[] values = new String[] { "Deutsch = 0", "Englisch = 1", "Franz\u00F6sisch = 2", "Spanisch = 3" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		languageList.setSelectedIndex(user.getLanguage());
		languageList.setBounds(168, 270, 203, 76);
		add(languageList);

		JButton saveSettings = new JButton("Einstellungen \u00E4ndern");
		saveSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				changeUserName(user);
				changeUserPassword(user);
				changeUserEmail(user);
				controller.saveData();
				changePanel(new UserPropertiesPanel(controller, userModel));
			}
		});

		saveSettings.setToolTipText("Hier klicken, wenn die get\u00E4tigten Einstellungen uebernommen werden sollen");
		saveSettings.setFont(font);
		saveSettings.setBounds(168, 462, 238, 54);
		add(saveSettings);

		JButton removeAccount = new JButton("Account l\u00F6schen");
		removeAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent eevent) {
				areYouSure();
			}
		});

		removeAccount.setToolTipText("Hier klicken, wenn Sie ihren Account l\u00F6schen m\u00F6chten");
		removeAccount.setFont(font);
		removeAccount.setBounds(168, 537, 238, 54);
		add(removeAccount);

	}

	/**
	 * Method is setting the new username of the logged in user when its valid.
	 * 
	 * @param user
	 */
	public void changeUserName(User user) {

		String name = userField.getText();
		if (name.length() >= 5 && name.length() <= 12) {
			controller.setUserName(name);
		}
	}

	/**
	 * Method is setting the new password of the logged in user.
	 * 
	 * @param user
	 */
	public void changeUserPassword(User user) {

		String password = passwordField.getText();
		if (password.length() >= 5 && password.length() <= 12) {
			controller.setUserPassword(user, password);
		}
	}

	/**
	 * Method is setting the new mailadress when its valid.
	 * 
	 * @param user
	 */
	public void changeUserEmail(User user) {

		String email = emailField.getText();
		// checking the mail properties
		boolean validEmail =
				email.contains("@") && email.contains(".de") || email.contains("@") && email.contains(".com") ||
						email.contains("@") && email.contains(".fr") || email.contains("@") && email.contains(".net");

		if (validEmail) {

			controller.setUserEmail(user, email);

		}
	}

	public void areYouSure() {

		int confirm = JOptionPane.showConfirmDialog(null, "Wollen Sie ihren Account wirklich entfernen?");

		if (confirm == JOptionPane.OK_OPTION) {
			controller.removeUser(user);
			LoginPanel loginPanel = new LoginPanel(controller);
			changePanel(loginPanel);
		}
	}
}
