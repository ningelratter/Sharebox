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

import de.sharebox.controller.Controller;

public abstract class ChangeablePanel extends ShareboxPanel {

	private static final long serialVersionUID = 3629679597896223833L;

	public ChangeablePanel(Controller controller) {
		super(controller);
		setSize(new Dimension(640, 680));
		setPreferredSize(new Dimension(640, 680));

		JButton exitButton = new JButton("ShareBox-Ultimate beenden");
		exitButton.setBounds(0, 657, 640, 23);
		ActionListener exitButtonClickedActionListener = new ActionListener() {

			@Override
			// Anonyme Untermethode
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exitButton.addActionListener(exitButtonClickedActionListener);
		setLayout(null);
		add(exitButton);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 640, 37);
		add(toolBar);

		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setAutoscrolls(true);
		menuBar.add(mnDatei);

		JMenu mnBenutzereinstellungen = new JMenu("Benutzereinstellungen");
		menuBar.add(mnBenutzereinstellungen);

		JMenuItem mntmBenutzereinstellungenAnsehen = new JMenuItem("Benutzereinstellungen ansehen");
		mnBenutzereinstellungen.add(mntmBenutzereinstellungenAnsehen);

		JMenuItem mntmLogAufrufen = new JMenuItem("Log aufrufen");
		mnBenutzereinstellungen.add(mntmLogAufrufen);

		JMenu mnEinladungenVerschicken = new JMenu("Einladungen verschicken");
		menuBar.add(mnEinladungenVerschicken);

		JMenuItem mntmEinladungenVerschicken = new JMenuItem("Einladungen verschicken");
		mnEinladungenVerschicken.add(mntmEinladungenVerschicken);

		JMenuItem mntmEinladungenAnnehmen = new JMenuItem("Einladungen annehmen");
		mnEinladungenVerschicken.add(mntmEinladungenAnnehmen);

		JMenu mnVerzeichnisliste = new JMenu("Verzeichnisliste");
		toolBar.add(mnVerzeichnisliste);

		JMenuItem mntmVerzeichnisreiterAnzeigen = new JMenuItem("Verzeichnisreiter anzeigen");
		mnVerzeichnisliste.add(mntmVerzeichnisreiterAnzeigen);
	}

	public void changePanel(HomePanel homePanel) {
		Container parent = getParent();
		parent.removeAll();
		parent.add(homePanel);
		parent.validate();
		parent.repaint();
	}

	public void changePanel(RegisterPanel registerPanel) {

		Container parent = getParent();
		parent.removeAll();
		parent.add(registerPanel);
		parent.validate();
		parent.repaint();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}