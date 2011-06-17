package de.sharebox.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.sharebox.controller.Controller;

public class ChangeableRegisterLogin extends ShareboxPanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 * 
	 * @author MW
	 */
	private static final long serialVersionUID = 3629179597896223833L;
	//class is used to show less then changePanel before login/register
	public ChangeableRegisterLogin(Controller controller) {
		super(controller);

		// design of the view
		setSize(new Dimension(640, 680));
		setPreferredSize(new Dimension(640, 680));
		setLayout(null);
		
		JButton button = new JButton("ShareBox-Ultimate beenden");
		button.setBounds(0, 618, 640, 23);
		add(button);

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

}
