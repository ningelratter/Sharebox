package de.sharebox.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

public class MenuPanel extends ChangeablePanel {
	UserModel userModel;

	public MenuPanel(final Controller controller, final UserModel userModel) {
		super(controller);
		this.userModel = userModel;

		// creates a toolbar
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 640, 37);
		add(toolBar);
		// cretes a menubar on the toolbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		toolBar.add(menuBar);

		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);

		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				Controller c = new Controller();
				HomePanel homePanel = new HomePanel(c, userModel);
				changePanel(homePanel);

			}
		});
		mnHome.add(mntmHome);
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
		mnBenutzereinstellungen.add(mntmBenutzereinstellungenAnsehen);
		// creates a menu on the menubar

		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
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
			public void mouseReleased(MouseEvent e) {

				Controller c = new Controller();
				DirPanel dirPanel = new DirPanel(c, userModel);
				changePanel(dirPanel);

			}
		});

		// Logout menu
		mnVerzeichnisliste.add(mntmVerzeichnisliste);

		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		// logs a user out - leads back in loginPanel
		mntmLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// saves the user before logout
				
				controller.saveData();
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);
			}
		});
		mnLogout.add(mntmLogout);
	}

}
