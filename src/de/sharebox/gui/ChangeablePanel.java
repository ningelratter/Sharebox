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

	public ChangeablePanel(final Controller controller) {
		super(controller);

		// design of the view
		setSize(new Dimension(640, 680));
		setPreferredSize(new Dimension(640, 680));

		// button exit
		JButton exitButton = new JButton("ShareBox-Ultimate beenden");
		exitButton.setToolTipText("Hier klicken, um sich von ShareBoxUltimate abzumelden");
		exitButton.setBounds(0, 618, 640, 23);
		// create new ActionListener
		ActionListener exitButtonClickedActionListener = new ActionListener() {

			@Override
			// closing the programm
			public void actionPerformed(ActionEvent e) {
				controller.saveData();
				System.exit(0);
			}
		};

		// handling the event click exit
		exitButton.addActionListener(exitButtonClickedActionListener);
		setLayout(null);
		add(exitButton);
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
	//opens LoignPanel-View
	public void changePanel(LoginPanel loginPanel){
		
		Container parent = getParent();
		parent.removeAll();
		parent.add(loginPanel);
		parent.validate();
		parent.repaint();
	}
	//opens ForgottenLoginPanel-View
	public void changePanel(ForgottenLoginPanel forgottenLoginPanel){
		Container parent = getParent();
		parent.removeAll();
		parent.add(forgottenLoginPanel);
		parent.validate();
		parent.repaint();
	}

}
