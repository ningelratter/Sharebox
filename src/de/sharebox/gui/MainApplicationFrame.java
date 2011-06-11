package de.sharebox.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import de.sharebox.controller.Controller;

public class MainApplicationFrame extends JFrame {

	private static final long serialVersionUID = -8617748510406583242L;

	/**
	 * @param args
	 *          Die Login.java-Datei erzeugt das Fenster der Applikation. Dazu
	 *          wird LoginPanel aufgerufen.
	 */

	public MainApplicationFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("ShareBox-Ultimate");
		setSize(640, 680);
		setPreferredSize(new Dimension(640, 680));

		// einzige Stelle, wo Controller erzeugt wird
		Controller controller = new Controller();

		LoginPanel loginPanel = new LoginPanel(controller);
		add(loginPanel);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("Sharebox-Ultimate");
		new MainApplicationFrame();

	}
}
