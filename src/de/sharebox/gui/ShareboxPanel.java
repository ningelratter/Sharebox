package de.sharebox.gui;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import de.sharebox.controller.Controller;

/**
 * At the moment I don't know why we need this class. :( :)
 * 
 * @author Eilin
 * @version 11.06.11
 * 
 */

public abstract class ShareboxPanel extends JPanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = -8030564383947937101L;

	// protected damit Kindklassen drauf zugreifen koennen
	protected Controller controller;

	protected JDesktopPane desktop;

	// constructor calls the controller
	public ShareboxPanel(Controller controller) {
		super();
		this.controller = controller;
		this.desktop = desktop;
	}
}
