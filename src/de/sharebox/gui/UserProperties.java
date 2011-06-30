/**
 * 
 */
package de.sharebox.gui;

import de.sharebox.controller.Controller;
import javax.swing.JTable;
import javax.swing.JToolBar;

/**
 * @author MW
 * 
 */
// class in which the user can change the properties
public class UserProperties extends ChangeablePanel {


	
	
	
	// every GUI class has to have a UID to verify
	private static final long serialVersionUID = 2342342341L;

	
	public UserProperties(Controller c){
		
		super(c);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(64, 71, 379, 205);
		add(toolBar);
	}
}
