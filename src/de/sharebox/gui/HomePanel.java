package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is the view when login was successfully. Extends from MenuPanel.
 * 
 * @author MW
 * @version 11.06.11
 * 
 * 
 */

public class HomePanel extends MenuPanel {

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
	public HomePanel(Controller controller, final UserModel userModel) {
		super(controller, userModel);

		// get the user
		User user = userModel.getUser();

		// label statement welcome
		JLabel label = new JLabel("Herzlich Willkommen, " + user.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(20, 69, 310, 56);
		add(label);

		ProgressPanel progressPanel = new ProgressPanel(user.getLimit());
		progressPanel.setBounds(420, 50, 180, 25);
		add(progressPanel);

		final TreePanel treePanel = new TreePanel(controller, userModel);

		JButton addFolderButton = new JButton("+");
		addFolderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String filenameDialog = JOptionPane.showInputDialog("Bitte Dateinamen eingeben");
				byte[] bytes = filenameDialog.getBytes();
				if (bytes != null) {
					String folderName = new String(bytes);
					if (!folderName.isEmpty()) {
						String rootDir = userModel.getUser().getRootDir();
						new File(rootDir, folderName).mkdir();
						treePanel.updateTree();
					}
				}
			}
		});

		addFolderButton.setBounds(420, 80, 25, 25);
		add(addFolderButton);

		JButton removeFolderButton = new JButton("-");
		removeFolderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File selectedFile = treePanel.getSelectedFile();
				if (selectedFile != null && selectedFile.exists()) {
					selectedFile.delete();
					treePanel.updateTree();
				}
			}
		});

		removeFolderButton.setBounds(450, 80, 25, 25);
		add(removeFolderButton);
		add(treePanel);
	}
}
