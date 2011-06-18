package de.sharebox.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import de.sharebox.controller.Controller;

/**
 * 
 * This GUI is the ... Extends from ShareBoxPanel.
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 * 
 */

public class ChangeablePanel extends ShareboxPanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 3629679597896223833L;

	public ChangeablePanel(Controller controller) {
		super(controller);

		// design of the view
		setSize(new Dimension(640, 680));
		setPreferredSize(new Dimension(640, 680));

		// button exit
		JButton exitButton = new JButton("ShareBox-Ultimate beenden");
		exitButton.setBounds(0, 618, 640, 23);
		// create new ActionListener
		ActionListener exitButtonClickedActionListener = new ActionListener() {

			@Override
			// closing the programm
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		// handling the event click exit
		exitButton.addActionListener(exitButtonClickedActionListener);
		setLayout(null);
		add(exitButton);
		// creates a toolbar
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 640, 37);
		add(toolBar);
		// cretes a menubar on the toolbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		toolBar.add(menuBar);

		JMenu Home = new JMenu("Home");
		/*
		 * Home.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override //Opens HomePanel-View public void mouseReleased(MouseEvent
		 * e) { Controller c = new Controller();
		 * //TODO hier muss der aktuelle User aufgerufen werden, erst möglich durch Datenbank
		 * 
		 * HomePanel homePanel = new HomePanel(c,userModel);
		 * changePanel(homePanel); } });
		 */
		menuBar.add(Home);
		// creates a submenu on the menubar
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setAutoscrolls(true);
		menuBar.add(mnDatei);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u00D6ffnen");
		mnDatei.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("umbennen");
		mnDatei.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("l\u00F6schen");
		mnDatei.add(mntmNewMenuItem_3);
		// creates a submenu on the menubar
		JMenu mnBenutzerServiceeinstellungen = new JMenu("BenutzerService");
		menuBar.add(mnBenutzerServiceeinstellungen);
		// creates a submenu on the menubar

		JMenuItem mntmBenutzereinstellungenAnsehen = new JMenuItem(
				"Benutzereinstellungen ansehen/\u00E4ndern");
		mntmBenutzereinstellungenAnsehen.addMouseListener(new MouseAdapter() {
			@Override
			// opens UserProperties-View when clicked
			public void mouseReleased(MouseEvent arg0) {

				Controller c = new Controller();
				UserProperties userProperties = new UserProperties(c);
				changePanel(userProperties);
			}
		});
		mnBenutzerServiceeinstellungen.add(mntmBenutzereinstellungenAnsehen);
		// creates a menu on the menubar

		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
		mnBenutzerServiceeinstellungen.add(mntmLogAufrufen);
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
				DirPanel dirPanel = new DirPanel(c);
				changePanel(dirPanel);

			}
		});
		mnVerzeichnisliste.add(mntmVerzeichnisliste);
	}

	// opens HomePanel-View
	public void changePanel(HomePanel homePanel) {
		Container parent = getParent();
		parent.removeAll();
		parent.add(homePanel);
		parent.validate();
		parent.repaint();
	}

	// opens RegisterPanel-View
	public void changePanel(RegisterPanel registerPanel) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(registerPanel);
		parent.validate();
		parent.repaint();
	}

	// opens DirPanel-View
	public void changePanel(DirPanel dirPanel) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(dirPanel);
		parent.validate();
		parent.repaint();
	}

	public void changePanel(UserProperties userProperties) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(userProperties);
		parent.validate();
		parent.repaint();
	}
}
