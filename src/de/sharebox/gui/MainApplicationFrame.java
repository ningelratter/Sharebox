package de.sharebox.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

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
	 * Creates the design of the view when the application started. The
	 * controller will be created and it take the call for LoginPanel.
	 * 
	 * @author Eilin,MW
	 */

	public static final int MAINWINDOWWIDTH = 680;
	public static final int MAINWINDOWHEIGHT = 640;

	public MainApplicationFrame() {
		super();

		// design of the view
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ShareBox-Ultimate");
		setResizable(false);
		setSize(640, 680);
		setPreferredSize(new Dimension(MAINWINDOWHEIGHT, MAINWINDOWWIDTH));

		// create the data directory
		new File("data").mkdir();

		// create the controller, its the only one
		Controller controller = new Controller();

		// create and call the LoginPanel
		LoginPanel loginPanel = new LoginPanel(controller);
		getContentPane().add(loginPanel, BorderLayout.NORTH);

		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		// text in the head of the window
		// System.out.println("Sharebox-Ultimate");
		new MainApplicationFrame();

	}

}
