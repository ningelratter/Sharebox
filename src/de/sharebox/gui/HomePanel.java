package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.sharebox.controller.Controller;
import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * 
 * This GUI is the view when login was successfully. Extends from MenuPanel.
 * 
 * @author MW, Eilin
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
	 * Create the home view of the user.
	 * 
	 * @param controller
	 * @param userModel
	 */
	public HomePanel(final Controller controller, final UserModel userModel) {
		super(controller, userModel);

		// get the user
		final User user = userModel.getUser();

		// label statement welcome
		JLabel label = new JLabel("Herzlich Willkommen, " + user.getName());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(20, 69, 310, 56);
		add(label);

		// creates a progressPanel limit
		final ProgressPanel progressPanel = new ProgressPanel(user.getLimit());
		progressPanel.setBounds(420, 50, 180, 25);
		add(progressPanel);

		final TreePanel treePanel = new TreePanel(controller);

		// create the button directory
		JButton addFolderButton = new JButton("O");

		/**
		 * When button create directory is clicked user have to put dataname in and
		 * directory is produced.
		 */
		addFolderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event1) {

				String filenameDialog = JOptionPane.showInputDialog("Bitte Ordnernamen eingeben");
				if (filenameDialog != null) {
					byte[] bytes = filenameDialog.getBytes();
					if (bytes != null) {
						String folderName = new String(bytes);
						if (!folderName.isEmpty()) {
							AbstractFile selectedItem = treePanel.getSelectedItem();
							Dir selectedDir = getSelectedDir(controller, selectedItem);
							controller.createDir(folderName, selectedDir);
							treePanel.updateTree();
							changePanel(new HomePanel(controller, userModel));
						}
					}
				}
			}
		});

		// create button directory accessible
		addFolderButton.setBounds(420, 80, 25, 25);
		addFolderButton.setToolTipText("Ordner anlegen");
		add(addFolderButton);

		// create button data(file)
		JButton addFileButton = new JButton("D");

		/**
		 * When button file accessible is clicked user have to put directory name in
		 * and file is produced.
		 */
		addFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event2) {

				String filenameDialog = JOptionPane.showInputDialog("Bitte Dateinamen eingeben");
				byte[] bytes = filenameDialog.getBytes();
				if (bytes != null) {
					String fileName = new String(bytes);
					if (!fileName.isEmpty()) {

						AbstractFile selectedItem = treePanel.getSelectedItem();
						Dir selectedDir = getSelectedDir(controller, selectedItem);
						controller.createTextFile(fileName, selectedDir);
						treePanel.updateTree();
						changePanel(new HomePanel(controller, userModel));
					}
				}
			}
		});

		// create button file accessible
		addFileButton.setBounds(450, 80, 25, 25);
		addFileButton.setToolTipText("Datei anlegen");
		add(addFileButton);

		// create button file oder directory delete
		JButton removeFileButton = new JButton("-");

		/**
		 * When button remove is clicked selected file or directory is deleted.
		 */
		removeFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event3) {
				AbstractFile selectedItem = treePanel.getSelectedItem();
				if (selectedItem != null) {
					controller.removeFile(selectedItem);
					treePanel.updateTree();
					changePanel(new HomePanel(controller, userModel));
				}
			}
		});

		// removes selected file or directory
		removeFileButton.setBounds(480, 80, 25, 25);
		removeFileButton.setToolTipText("Ordner oder Datei entfernen");
		add(removeFileButton);

		add(treePanel);
	}

	/**
	 * Method gives selected directory back.
	 * 
	 * @param controller
	 * @param selectedItem
	 * @return
	 */
	private Dir getSelectedDir(final Controller controller, AbstractFile selectedItem) {
		Dir selectedDir;
		if (selectedItem != null) {

			if (selectedItem.isDir()) {
				selectedDir = (Dir) selectedItem;
			}
			else {
				selectedDir = selectedItem.getParent();
			}
		}
		else {
			selectedDir = controller.getRootDir();
		}
		return selectedDir;
	}

}