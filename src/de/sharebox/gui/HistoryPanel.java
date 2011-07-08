package de.sharebox.gui;

import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.sharebox.controller.Controller;
import de.sharebox.entities.History;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * 
 * This GUI shows the history entries of the user. Extends from MenuPanel.
 * 
 * @author Eilin
 * @version 03.07.11
 * 
 * 
 */

public class HistoryPanel extends MenuPanel {

	/**
	 * EVERY Panel needs a serialVersionUID.
	 */
	private static final long serialVersionUID = 2268226143091328329L;

	/**
	 * Create the history view of the current user.
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

		// statemant at the beginning of the panel
		String historyString = "History of user " + username + "\n\n";
		for (History history : historyEntries) {
			historyString = new StringBuffer().append(historyString).append(history.getDate()).append(" ")
					.append(history.getActivity()).append("\n").toString();
		}

		//create the layout of the current user
		JTextArea currentUserHistory = new JTextArea(historyString);
		currentUserHistory.setMargin(new Insets(10, 10, 10, 10));
		currentUserHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currentUserHistory.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(currentUserHistory);
		scrollPane.setBounds(25, 50, 500, 500);
		add(scrollPane);
	}
}
