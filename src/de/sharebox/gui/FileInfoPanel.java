package de.sharebox.gui;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.sharebox.controller.Controller;
import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.User;

/**
 * Shows properties - name, owner and creation date of the selected directories
 * and files.
 * 
 * @author Eilin
 * @version 10.07.11
 */
public class FileInfoPanel extends JPanel {

	private static final long serialVersionUID = -8653653707677187673L;

	private Controller controller;

	private JLabel nameLabel;
	private JLabel userLabel;
	private JLabel creationDateLabel;

	public FileInfoPanel(AbstractFile selectedFile, Controller controller) {
		setLayout(null);

		this.controller = controller;

		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setBounds(10, 440, 600, 150);

		//create label info
		JLabel infoLabel = new JLabel("Infos");
		infoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		infoLabel.setBounds(10, 10, 100, 15);
		add(infoLabel);

		//create label name
		JLabel nameHeaderLabel = new JLabel("Name:");
		nameHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameHeaderLabel.setBounds(10, 40, 100, 10);
		add(nameHeaderLabel);

		nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(100, 40, 100, 10);
		add(nameLabel);

		//create label owner
		JLabel userHeaderLabel = new JLabel("Besitzer:");
		userHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		userHeaderLabel.setBounds(10, 60, 100, 10);
		add(userHeaderLabel);

		userLabel = new JLabel();
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userLabel.setBounds(100, 60, 100, 10);
		add(userLabel);

		//create label creation date
		JLabel creationDateHeaderLabel = new JLabel("Erstellt am:");
		creationDateHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		creationDateHeaderLabel.setBounds(10, 80, 100, 10);
		add(creationDateHeaderLabel);

		creationDateLabel = new JLabel();
		creationDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		creationDateLabel.setBounds(100, 80, 120, 10);
		add(creationDateLabel);

		updateModel(selectedFile);
	}

	/**
	 * Sets a selected file. 
	 * @param selectedFile
	 */
	public void setSelectedFile(AbstractFile selectedFile) {
		updateModel(selectedFile);
		revalidate();
		repaint();
	}

	/**
	 * Updates the current model of a user.
	 * @param selectedFile
	 */
	private void updateModel(AbstractFile selectedFile) {
		nameLabel.setText(selectedFile.getName());

		int userId = selectedFile.getUserId();
		User user = controller.getUserById(userId);
		userLabel.setText(user.getName());

		Date creationDate = selectedFile.getCreationDate();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
		creationDateLabel.setText(dateFormat.format(creationDate));
	}
}
