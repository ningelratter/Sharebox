package de.sharebox.gui;

import java.awt.Component;
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
import javax.swing.JPopupMenu;
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

public abstract class ChangeablePanel extends ShareboxPanel {

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
		//creates a toolbar
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 640, 37);
		add(toolBar);
		//cretes a menubar on the toolbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		toolBar.add(menuBar);
		//creates a submenu on the menubar
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setAutoscrolls(true);
		menuBar.add(mnDatei);
		//creates a submenu on the menubar
		JMenu mnBenutzereinstellungen = new JMenu("Benutzereinstellungen");
		menuBar.add(mnBenutzereinstellungen);
		//creates a submenu on the menubar
		
		JMenuItem mntmBenutzereinstellungenAnsehen = new JMenuItem(
				"Benutzereinstellungen ansehen");
		mnBenutzereinstellungen.add(mntmBenutzereinstellungenAnsehen);
		//creates a menu on the menubar
		
		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
		mnBenutzereinstellungen.add(mntmLogAufrufen);
		//creates a menu on the menubar
		
		JMenu mnEinladungenVerschicken = new JMenu("Einladungen");
		menuBar.add(mnEinladungenVerschicken);
		//creates a submenu "Einladungen verschicken"
		
		JMenuItem mntmEinladungenVerschicken = new JMenuItem(
				"Einladungen verschicken");
		
		mnEinladungenVerschicken.add(mntmEinladungenVerschicken);
		//creates a submenu "Einladungen annehmen"

		JMenuItem mntmEinladungenAnnehmen = new JMenuItem(
				"Einladungen annehmen");
		mnEinladungenVerschicken.add(mntmEinladungenAnnehmen);
		//creates a menu "Verzeichnisliste"
		JMenu mnVerzeichnisliste = new JMenu("Verzeichnisliste");
		menuBar.add(mnVerzeichnisliste);
		//creates a submenu "Verzeichnisliste anzeigen"
		JMenuItem mntmVerzeichnisliste = new JMenuItem(
				"Verzeichnisliste anzeigen");
		//mouseclick on the submenu "Verzeichnisliste anzeigen" opens DirPanel-View
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

	//opens HomePanel-View
	public void changePanel(HomePanel homePanel) {
		Container parent = getParent();
		parent.removeAll();
		parent.add(homePanel);
		parent.validate();
		parent.repaint();
	}
	//opens RegisterPanel-View
	public void changePanel(RegisterPanel registerPanel) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(registerPanel);
		parent.validate();
		parent.repaint();
	}
	//opens DirPanel-View
	public void changePanel(DirPanel dirPanel) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(dirPanel);
		parent.validate();
		parent.repaint();

	}

}
