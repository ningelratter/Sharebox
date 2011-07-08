package de.sharebox.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import de.sharebox.controller.Controller;
import de.sharebox.models.UserModel;

public class MenuPanel extends ChangeablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8555827717858274404L;

	public MenuPanel(final Controller controller, final UserModel userModel) {
		super(controller);

		// creates a menubar on the toolbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		menuBar.setBounds(0, 0, 640, 37);
		add(menuBar);

		//creates  menu of menubar
		JMenu mnHome = new JMenu("Home");
		mnHome.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent event1) {
				HomePanel homePanel = new HomePanel(controller, userModel);
				changePanel(homePanel);
			}
		});

		menuBar.add(mnHome);

		// creates a menu on the menubar
		JMenu mnBenutzereinstellungen = new JMenu("Benutzereinstellungen");
		menuBar.add(mnBenutzereinstellungen);

		// creates a submenu on the menubar
		JMenuItem mntmBenutzereinstellungenAnsehen = new JMenuItem("Benutzereinstellungen ansehen");
		mntmBenutzereinstellungenAnsehen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				UserPropertiesPanel userProperties = new UserPropertiesPanel(controller, userModel);
				changePanel(userProperties);
			}
		});
		mnBenutzereinstellungen.add(mntmBenutzereinstellungenAnsehen);

		// creates a submenu on the menubar
		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
		mntmLogAufrufen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				HistoryPanel historyPanel = new HistoryPanel(controller, userModel);
				changePanel(historyPanel);
			}
		});
		mnBenutzereinstellungen.add(mntmLogAufrufen);

		// creates a menu on the menubar 
		JMenu mnEinladungenVerschicken = new JMenu("Einladungen");
		menuBar.add(mnEinladungenVerschicken);

		// creates a submenu "Einladungen verschicken"
		JMenuItem mntmEinladungenVerschicken = new JMenuItem("Einladungen verschicken");
		mnEinladungenVerschicken.add(mntmEinladungenVerschicken);

		// creates a submenu "Einladungen annehmen"
		JMenuItem mntmEinladungenAnnehmen = new JMenuItem("Einladungen annehmen");
		mnEinladungenVerschicken.add(mntmEinladungenAnnehmen);

		//creates a menu on the menubar
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnLogout.add(mntmLogout);

		// logs a user out - leads back in loginPanel
		mntmLogout.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent event3) {
				controller.logout();
				LoginPanel loginPanel = new LoginPanel(controller);
				changePanel(loginPanel);
			}
		});
	}
}
