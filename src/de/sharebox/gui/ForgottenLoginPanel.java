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
 * @author MW class that gets user-logindata over existing mailadress in data
 *         bank
 */
public class ForgottenLoginPanel extends ChangeablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5039410585133415906L;
	private JTextField emailInput;
	JFrame frame;
	Popup popup, popup1, popup2;

	public ForgottenLoginPanel(final Controller controller) {
		super(controller);
		setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel howToRestore = new JLabel(
				"Geben Sie hier ihre Emailadresse ein: ");
		howToRestore.setToolTipText("Enter Email\r\n");
		howToRestore.setFont(new Font("Tahoma", Font.BOLD, 18));
		howToRestore.setBounds(145, 99, 349, 77);
		add(howToRestore);
		// gets you back into loginPanel-View
		JLabel goBackToLogin = new JLabel("Zur\u00FCck zum Login:");
		goBackToLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		goBackToLogin.setBounds(222, 410, 188, 90);
		add(goBackToLogin);

		emailInput = new JTextField();
		emailInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
		emailInput.setToolTipText("Geben Sie hier ihre Emailadresse ein");
		emailInput.setBounds(145, 216, 342, 77);
		add(emailInput);
		emailInput.setColumns(10);

		JButton getUserData = new JButton("Zeige Benutzerdaten");
		getUserData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent get) {
				// is searching in data bank for the user with this mailadress
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
		getUserData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getUserData
				.setToolTipText("Hier klicken, um Benutzerdaten \u00FCber die Emailadresse anzeigen zu lassen");
		getUserData.setBounds(199, 336, 211, 63);
		add(getUserData);

		JButton backToLogin = new JButton("Login");
		backToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent z) {

				changePanel(new LoginPanel(controller));
			}
		});
		backToLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backToLogin
				.setToolTipText("Hier klicken, um zum Login zur\u00FCck zu gelangen");
		backToLogin.setBounds(242, 495, 144, 63);
		add(backToLogin);

	}

	// is showing the UserData and an option to get back to the LoginPanel-View
	public void printData(String userName, String userPassword) {

		frame = new JFrame("Ihre Benutzerdaten");
		frame.setSize(400, 400);
		frame.setLocation(200, 200);

		PopupFactory factory = PopupFactory.getSharedInstance();

		JButton userN = new JButton();
		add(userN);

		JButton userPwd = new JButton();
		add(userN);

		JButton backToLogin = new JButton("Zurück zum Login");
		backToLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(backToLogin);

		popup = factory.getPopup(frame, userN = new JButton("Benutzername: "
				+ userName), 200, 350);
		popup2 = factory.getPopup(frame, userPwd = new JButton("Passwort: "
				+ userPassword), 200, 400);
		popup1 = factory.getPopup(frame, backToLogin = new JButton(
				"Zurück zum Login"), 325, 500);

		popup.show();
		popup1.show();
		popup2.show();
		frame.setVisible(true);

		backToLogin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);

				frame.setVisible(false);
			}

		});

	}

	// error popup which is shown, when emailadress is not in data bank
	public void emailNotFound() {

		frame = new JFrame("Keinen Benutzer gefunden!");
		frame.setSize(400, 300);
		frame.setLocation(150, 200);

		PopupFactory factory = PopupFactory.getSharedInstance();

		JButton noUser = new JButton();
		add(noUser);

		popup = factory.getPopup(frame, noUser = new JButton(
				"Keinen Benutzer mit dieser Mail-Adresse gefunden"), 200, 350);
		frame.setVisible(true);
		popup.show();
		noUser.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				ForgottenLoginPanel forgottenLoginPanel = new ForgottenLoginPanel(
						controller);
				changePanel(forgottenLoginPanel);
				frame.setVisible(false);
			}

		});
	}
}
