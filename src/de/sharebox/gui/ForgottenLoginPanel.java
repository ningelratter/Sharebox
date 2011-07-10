/**
 * 
 */
package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;

/**
 * This class gets user-logindata over existing mailadress in database.
 * 
 * @author MW
 * @date 07.06.11
 * 
 */
public class ForgottenLoginPanel extends ChangeablePanel {

	private static final long serialVersionUID = -5039410585133415906L;
	private final JTextField emailInput;
	private JFrame frame;
	private Popup popup, popup1, popup2;

	public ForgottenLoginPanel(final Controller controller) {
		super(controller);
		Font font = new Font("Tahoma", Font.BOLD, 18);

		// label to input the emailadress
		JLabel howToRestore = new JLabel("Geben Sie hier ihre Emailadresse ein: ");
		howToRestore.setFont(font);
		howToRestore.setToolTipText("Enter Email\r\n");
		howToRestore.setBounds(145, 99, 349, 77);
		add(howToRestore);

		// gets you back into loginPanel-View
		JLabel goBackToLogin = new JLabel("Zurueck zum Login:");
		goBackToLogin.setBounds(222, 410, 188, 90);
		add(goBackToLogin);

		// creates textfield for Log
		emailInput = new JTextField();

		/**
		 * Prints the data out, when button "Zeige Benutzerdaten" is clicked.
		 * 
		 * @param event2
		 */
		emailInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent event2) {

				if (event2.getKeyCode() == KeyEvent.VK_ENTER) {
					String mail = emailInput.getText();
					User user = controller.getUser(mail);

					if (user != null) {
						String userName = user.getName();
						String userPassword = user.getPassword();
						printData(userName, userPassword);
					} else {

						emailNotFound();
					}
				}

			}
		});
		// create statement to indicate the emailadress
		emailInput.setToolTipText("Geben Sie hier ihre Emailadresse ein");
		emailInput.setBounds(145, 216, 342, 77);
		add(emailInput);
		emailInput.setColumns(10);

		// create button "Zeige Benutzerdaten"
		JButton getUserData = new JButton("Zeige Benutzerdaten");
		getUserData.addMouseListener(new MouseAdapter() {

			/**
			 * Method gets username and password. Calls the method printData().
			 */
			@Override
			public void mouseReleased(MouseEvent get) {
				// is searching in database for the user with this mailadress
				String mail = emailInput.getText();
				User user = controller.getUser(mail);

				if (user != null) {
					String userName = user.getName();
					String userPassword = user.getPassword();
					printData(userName, userPassword);
				}

				else {
					emailNotFound();
				}

			}
		});
		// mouse overview for the button "Zeige Benutzerdaten"
		Font font2 = new Font("Tahoma", Font.PLAIN, 16);
		getUserData.setFont(font2);
		getUserData.setToolTipText("Hier klicken, um Benutzerdaten ueber die Emailadresse anzeigen zu lassen");
		getUserData.setBounds(199, 336, 211, 63);
		add(getUserData);

		// create button Login
		JButton backToLogin = new JButton("Login");

		/**
		 * When the button is clicked the LoginPanel is loaded.
		 */
		backToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent zevent) {

				changePanel(new LoginPanel(controller));
			}
		});
		backToLogin.setFont(font2);
		backToLogin.setToolTipText("Hier klicken, um zum Login zurueckzugelangen");
		backToLogin.setBounds(242, 495, 144, 63);
		add(backToLogin);

	}

	// is showing the UserData and an option to get back to the LoginPanel-View
	public void printData(String userName, String userPassword) {

		frame = new JFrame("Ihre Benutzerdaten");
		frame.setSize(400, 400);
		frame.setLocation(200, 200);

		PopupFactory factory = PopupFactory.getSharedInstance();

		// Button username
		JButton userN = new JButton();
		add(userN);

		// Button password
		JButton userPwd = new JButton();
		add(userPwd);

		// Button Login
		JButton backToLogin = new JButton("Zurueck zum Login");
		add(backToLogin);

		// creates the popup window with button username, password and back to login
		popup = factory.getPopup(frame, userN = new JButton("Benutzername: " + userName), 200, 350);
		popup2 = factory.getPopup(frame, userPwd = new JButton("Passwort: " + userPassword), 200, 400);
		popup1 = factory.getPopup(frame, backToLogin = new JButton("Zurueck zum Login"), 325, 500);

		// shows popup window
		popup.show();
		popup1.show();
		popup2.show();
		frame.setVisible(true);

		/**
		 * When button back to login is clicked method change to LoginPanel.
		 */
		backToLogin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);

				frame.setVisible(false);
			}

		});

	}

	/**
	 * Error popup is shown, when emailadress is not in database.
	 */
	public void emailNotFound() {

		frame = new JFrame("Keinen Benutzer gefunden!");
		frame.setSize(400, 300);
		frame.setLocation(150, 200);

		PopupFactory factory = PopupFactory.getSharedInstance();

		// creates button no user found (as popup)
		JButton noUser = new JButton("Keinen Benutzer mit dieser Mail-Adresse gefunden");
		frame.add(noUser);

		// popup window no user found
		popup = factory.getPopup(frame, noUser, 170, 350);
		frame.setVisible(true);
		popup.show();

		/**
		 * When no user is found and Button is clicked ForgottenLoginPanel is shown
		 * again.
		 */
		noUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				ForgottenLoginPanel forgottenLoginPanel = new ForgottenLoginPanel(controller);
				changePanel(forgottenLoginPanel);
				frame.setVisible(false);
			}

		});
	}
}
