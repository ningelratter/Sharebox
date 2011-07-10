package de.sharebox.gui;

import javax.swing.JPanel;

import de.sharebox.controller.Controller;

/**
 * This is the abstract super panel for all of use.
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

	// protected so that all child classes could access.
	protected Controller controller;

	public ShareboxPanel(Controller controller) {
		this.controller = controller;
	}
}
