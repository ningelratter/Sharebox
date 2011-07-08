package de.sharebox.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.sharebox.controller.Controller;

/**
 * 
 * This GUI exchanges the panels, when a view is modified.  
 * Extends from ShareBoxPanel.
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
		exitButton.setBounds(21, 618, 584, 23);
		// create new ActionListener
		ActionListener exitButtonClickedActionListener = new ActionListener() {

			/**
			 * Method saved the data and terminate the system.
			 * 
			 *@param event
			 */
			@Override
			public void actionPerformed(ActionEvent eevent) {
				controller.saveData();
				System.exit(0);
			}
		};

		// handling the event click exit
		exitButton.addActionListener(exitButtonClickedActionListener);
		setLayout(null);
		add(exitButton);
	}
/**
 * The Method is change a view. 
 * @param panel
 */
	public void changePanel(ChangeablePanel panel) {
		try {
			Container parent = getParent();
			parent.removeAll();
			parent.add(panel);
			parent.validate();
			parent.repaint();
		}
		catch (NullPointerException nullE) {

			nullE.getMessage();
		}
	}
}
