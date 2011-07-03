package de.sharebox.gui;

import java.awt.TextArea;
import java.util.List;

import javax.swing.JLabel;

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
	 * create the history view of the user
	 * 
	 * @param controller
	 * @param userModel
	 */
	public HistoryPanel(Controller controller, UserModel userModel) {
		super(controller, userModel);

		// get the user
		User user = userModel.getUser();
		String username = user.getName();
		int userId = user.getId();

		List<History> historyEntries = controller.getHistory(userId);

		String historyString = "History of user " + username + "\n\n";
		for (History history : historyEntries) {
			historyString +=  history.getDate() + " " + history.getActivity() + "\n";
		}

		TextArea currentUserHistory = new TextArea(historyString);
//		currentUserHistory.setToolTipText("History");
		currentUserHistory.setEditable(false);
		currentUserHistory.setBounds(25, 50, 500, 500);
		add(currentUserHistory);
	}
}
