package de.sharebox.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

public class MenuPanel extends ChangeablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8555827717858274404L;

	public MenuPanel(final Controller controller, final UserModel userM) {
		super(controller);
		final UserModel userModel = userM;
		User user = userModel.getUser();
		int limit = user.getLimit();

		// creates a menubar on the toolbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		menuBar.setBounds(0, 0, 440, 37);
		add(menuBar);

		JMenu mnHome = new JMenu("Home");
		mnHome.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent event1) {
				HomePanel homePanel = new HomePanel(controller, userModel);
				changePanel(homePanel);
			}
		});

		menuBar.add(mnHome);

		// creates a submenu on the menubar
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setAutoscrolls(true);
		menuBar.add(mnDatei);

		// creates a submenu on the menubar
		JMenu mnBenutzereinstellungen = new JMenu("Benutzereinstellungen");
		menuBar.add(mnBenutzereinstellungen);

		// creates a submenu on the menubar
		JMenuItem mntmBenutzereinstellungenAnsehen = new JMenuItem(
				"Benutzereinstellungen ansehen");
		mntmBenutzereinstellungenAnsehen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				UserPropertiesPanel userProperties = new UserPropertiesPanel(
						controller, userModel);
				changePanel(userProperties);
			}
		});
		mnBenutzereinstellungen.add(mntmBenutzereinstellungenAnsehen);

		// creates a menu on the menubar
		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
		mntmLogAufrufen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				HistoryPanel historyPanel = new HistoryPanel(controller,
						userModel);
				changePanel(historyPanel);
			}
		});
		mnBenutzereinstellungen.add(mntmLogAufrufen);

		// creates a menu on the menubar
		JMenu mnEinladungenVerschicken = new JMenu("Einladungen");
		menuBar.add(mnEinladungenVerschicken);

		// creates a submenu "Einladungen verschicken"
		JMenuItem mntmEinladungenVerschicken = new JMenuItem(
				"Einladungen verschicken");
		mnEinladungenVerschicken.add(mntmEinladungenVerschicken);

		// creates a submenu "Einladungen annehmen"
		JMenuItem mntmEinladungenAnnehmen = new JMenuItem(
				"Einladungen annehmen");
		mnEinladungenVerschicken.add(mntmEinladungenAnnehmen);

		// creates a menu "Verzeichnisliste"
		JMenu mnVerzeichnisliste = new JMenu("Verzeichnisliste");
		menuBar.add(mnVerzeichnisliste);

		// creates a submenu "Verzeichnisliste anzeigen"
		JMenuItem mntmVerzeichnisliste = new JMenuItem(
				"Verzeichnisliste anzeigen");
		// mouseclick on the submenu "Verzeichnisliste anzeigen" opens
		// DirPanel-View
		mntmVerzeichnisliste.addMouseListener(new MouseAdapter() {
			@Override
			// Change into DirPanel
			public void mouseReleased(MouseEvent eevent2) {

				DirPanel dirPanel = new DirPanel(controller, userModel);
				changePanel(dirPanel);
			}
		});

		// Logout menu
		mnVerzeichnisliste.add(mntmVerzeichnisliste);

		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnLogout.add(mntmLogout);
		// shows user limit
		JProgressBar progressBar = new JProgressBar();
		progressBar.setToolTipText("Ihr verbleibender Speicher in %");
		progressBar.setStringPainted(true);
		progressBar.setBounds(466, 11, 146, 26);
		progressBar.setMaximum(100);
		progressBar.setValue(limit);
		add(progressBar);

		// logs a user out - leads back in loginPanel
		mntmLogout.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent eevent3) {
				// saves the user before logout
				controller.saveData();
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);
			}
		});
	}
}
