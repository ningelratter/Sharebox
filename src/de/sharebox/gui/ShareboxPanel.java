package de.sharebox.gui;

import javax.swing.JPanel;

import de.sharebox.controller.Controller;

public abstract class ShareboxPanel extends JPanel {

	private static final long serialVersionUID = -8030564383947937101L;

	// protected damit Kindklassen drauf zugreifen kšnnen
	protected Controller controller;

	public ShareboxPanel(Controller controller) {
		this.controller = controller;
	}
}
