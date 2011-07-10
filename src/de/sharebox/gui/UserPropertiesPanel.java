package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

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
	private final JTextField limitField;
	private final JTextField emailField;
	private JFrame frame;
	private Popup popupRemove, popupDontRemove;
	private final User user;

	public UserPropertiesPanel(final Controller controller, final UserModel userModel) {

		super(controller, userModel);
		user = userModel.getUser();

		Font font = new Font("Tahoma", Font.PLAIN, 18);
		Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		Font font3 = new Font("Tahoma", Font.PLAIN, 14);

		// create first label of the this panel
		JLabel welcomeUserText = new JLabel("Hier koennen Sie die Einstellungen fuer: " + user.getName() + " aendern!");
		welcomeUserText.setFont(font);
		welcomeUserText.setBounds(25, 33, 615, 54);
		add(welcomeUserText);

		// create label username
		JLabel lblUsername = new JLabel("Benutzername:");
		lblUsername.setFont(font2);
		lblUsername.setBounds(25, 116, 115, 34);
		add(lblUsername);

		// create label password
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(font2);
		lblPasswort.setBounds(25, 169, 115, 34);
		add(lblPasswort);

		// create label email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(font2);
		lblEmail.setBounds(25, 230, 115, 34);
		add(lblEmail);

		// create label language
		JLabel lblSprache = new JLabel("Sprache:");
		lblSprache.setFont(font2);
		lblSprache.setBounds(25, 364, 115, 34);
		add(lblSprache);

		// create label limit
		JLabel lblLimit = new JLabel("Limit:");
		lblLimit.setFont(font2);
		lblLimit.setBounds(25, 298, 115, 34);
		add(lblLimit);

		// create text field username
		userField = new JTextField();
		userField.setToolTipText("Hier neuen Benutzernamen eingeben");
		userField.setBounds(168, 118, 203, 34);
		add(userField);
		userField.setColumns(10);

		// create text field password
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Hier neues Passwort eigeben");
		passwordField.setColumns(10);
		passwordField.setBounds(168, 171, 203, 34);
		add(passwordField);

		// create text field email
		emailField = new JTextField();
		emailField.setToolTipText("Hier neues Emailadresse eigeben");
		emailField.setColumns(10);
		emailField.setBounds(168, 232, 203, 34);
		add(emailField);

		// create label current username
		final JLabel currentUserName = new JLabel("");
		currentUserName.setToolTipText("aktueller Benutzername");
		currentUserName.setBounds(25, 144, 115, 34);
		add(currentUserName);
		currentUserName.setText(user.getName());

		languageList = new JList();
		languageList
				.setToolTipText("waehlen Sie die gewuenschte Sprache in der ihre ShareBoxUltimate angezeigt werden soll");
		languageList.setFont(font3);
		languageList.setName("");
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
		languageList.setBounds(168, 364, 203, 76);
		add(languageList);

		// create text field limit
		limitField = new JTextField();
		limitField.setColumns(10);
		limitField.setBounds(168, 300, 203, 34);
		add(limitField);

		// create button to change properties
		JButton einstellungenndern = new JButton("Einstellungen aendern");

		/**
		 * When button for changing properties is clicked details are changing.
		 */
		einstellungenndern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				changeUserName(user);
				changeUserPassword(user);
				changeUserEmail(user);
				controller.saveData();
				changePanel(new UserPropertiesPanel(controller, userModel));
			}
		});

		// create label statement for changing button
		einstellungenndern.setToolTipText("Hier klicken, wenn die getaetigten Einstellungen uebernommen werden sollen");
		einstellungenndern.setFont(font);
		einstellungenndern.setBounds(168, 462, 238, 54);
		add(einstellungenndern);

		// create label current password shows the current detail
		JLabel currentPassword = new JLabel((String) null);
		currentPassword.setToolTipText("aktuelles Passwort");
		currentPassword.setBounds(25, 199, 115, 34);
		add(currentPassword);
		currentPassword.setText(user.getPassword());

		// create label current email and shows the current detail
		JLabel currentMail = new JLabel((String) null);
		currentMail.setToolTipText("aktuelle Emailadresse");
		currentMail.setBounds(25, 263, 115, 34);
		add(currentMail);
		currentMail.setText(user.getMail());

		// create label current limit and shows the current detail
		JLabel currentLimit = new JLabel((String) null);
		currentLimit.setToolTipText("aktuelles Limit");
		currentLimit.setBounds(25, 330, 115, 34);
		add(currentLimit);
		double limit = user.getLimit();
		String sLimit = String.valueOf(limit);
		currentLimit.setText(sLimit);

		// create label current langugage and shows the current detail
		JLabel currentLanguage = new JLabel((String) null);
		currentLanguage.setToolTipText("aktuell eingestellte Sprache");
		currentLanguage.setBounds(25, 406, 115, 34);
		add(currentLanguage);
		int iLanguage = user.getLanguage();
		String sLanguage = String.valueOf(iLanguage);
		currentLanguage.setText(sLanguage);

		// create label to remove a account
		JButton removeAccount = new JButton("Account loeschen");
		removeAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent eevent) {

				areYouSure();

			}
		});
		// create label statement for removing account button
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
		boolean validEmail = email.contains("@") && email.contains(".de") || email.contains("@") && email.contains(".com")
				|| email.contains("@") && email.contains(".fr") || email.contains("@") && email.contains(".net");

		if (validEmail) {

			controller.setUserEmail(user, email);

		}
	}

	/**
	 * Method pops up a window where the user have to confirm that he wants to
	 * delete the ac count, when remove account button is clicked.
	 * */
	public void areYouSure() {

		// frame are you sure?
		frame = new JFrame("Sind Sie sicher?!");
		frame.setSize(400, 300);
		frame.setLocation(150, 200);

		PopupFactory factory = PopupFactory.getSharedInstance();

		// creates button remove
		JButton remove = new JButton();
		add(remove);
		// creates button stay
		JButton stay = new JButton();
		add(stay);

		// creates button yes and no
		popupRemove = factory.getPopup(frame, remove = new JButton("Ja, Accounnt loeschen"), 250, 300);
		frame.setVisible(true);
		popupDontRemove = factory.getPopup(frame, stay = new JButton("Nein, Account nicht loeschen"), 250, 400);
		popupRemove.show();
		popupDontRemove.show();

		/**
		 * When yes - remove button is clicked user is going to delete in the
		 * database and the login panel is shown.
		 */
		remove.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				controller.removeUser(user);
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);
				frame.setVisible(false);
			}

		});

		/**
		 * When button don't removing is clicked the pop up window is going to close
		 * and user properties panel is shown again.
		 */
		stay.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				frame.setVisible(false);
			}

		});

	}

}
