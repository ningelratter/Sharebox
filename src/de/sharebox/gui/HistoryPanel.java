package de.sharebox.gui;

import java.util.List;

import de.sharebox.controller.Controller;
import de.sharebox.entities.History;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is the views the historyentries of the user. Extends from MenuPanel.
 * 
 * @author Eilin
 * @version 03.07.11
 * 
 * 
 */

public class HistoryPanel extends MenuPanel {

	/**
	 * EVERY Panel needs a serialVersionUID
	 */
	private static final long serialVersionUID = 2268226143091328329L;

	/**
	 * create the home view of the user
	 * 
	 * @param conotroller
	 * @param userModel
	 */
	public HistoryPanel(Controller controller, UserModel userModel) {
	super(controller, userModel);
	
		// get the user
		User user = userModel.getUser();
		String username = user.getName();
		int userId = user.getId();
/*		
	public List<History> getHistoryById(int userId) {

				controller.getHistory(id);
			}		
	
*/
	}
}
