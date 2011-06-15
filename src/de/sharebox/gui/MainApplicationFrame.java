package de.sharebox.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import de.sharebox.controller.Controller;

/**
 * 
 * This class is the start application. Produce the first view of the
 * application - LoginPanel.
 * 
 * @author Eilin Schroder
 * @version 11.06.11
 * 
 */

public class MainApplicationFrame extends JFrame {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = -8617748510406583242L;

	/**
	 * 
	 * Creates the design of the view when the application started. The controller
	 * will be created and it take the call for LoginPanel.
	 * 
	 * @author Eilin
	 */
	public MainApplicationFrame() {

		// design of the view
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ShareBox-Ultimate");
		setSize(640, 680);
		setPreferredSize(new Dimension(640, 680));

		// create the controller, its the only one
		Controller controller = new Controller();

		// create and call the LoginPanel
		LoginPanel loginPanel = new LoginPanel(controller);
		add(loginPanel);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// text in the head of the window
	//	System.out.println("Sharebox-Ultimate");
		new MainApplicationFrame();

	}
}
