package de.sharebox.gui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.sharebox.controller.Controller;
import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.User;

public class FileInfoPanel extends JPanel {

	private static final long serialVersionUID = -8653653707677187673L;

	private Controller controller;

	private JLabel nameLabel;
	private JLabel userLabel;

	public FileInfoPanel(AbstractFile selectedFile, Controller controller) {
		setLayout(null);

		this.controller = controller;

		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setBounds(10, 440, 600, 150);

		JLabel infoLabel = new JLabel("Infos");
		infoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		infoLabel.setBounds(10, 10, 100, 15);
		add(infoLabel);

		JLabel nameHeaderLabel = new JLabel("Name:");
		nameHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameHeaderLabel.setBounds(10, 40, 100, 10);
		add(nameHeaderLabel);

		nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(80, 40, 100, 10);
		add(nameLabel);

		JLabel userHeaderLabel = new JLabel("Besitzer:");
		userHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		userHeaderLabel.setBounds(10, 60, 100, 10);
		add(userHeaderLabel);

		userLabel = new JLabel();
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userLabel.setBounds(80, 60, 100, 10);
		add(userLabel);

		updateModel(selectedFile);
	}

	public void setSelectedFile(AbstractFile selectedFile) {
		updateModel(selectedFile);
		revalidate();
		repaint();
	}

	private void updateModel(AbstractFile selectedFile) {
		nameLabel.setText(selectedFile.getName());

		int userId = selectedFile.getUserId();
		User user = controller.getUserById(userId);
		userLabel.setText(user.getName());
	}
}
