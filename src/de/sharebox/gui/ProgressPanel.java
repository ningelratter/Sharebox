package de.sharebox.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;

/**
 * This class creates a limit display that shows how much limit of the logged in
 * user exists at the moment.
 * 
 * @author MW
 * @version 05.07.2011
 * 
 */
public class ProgressPanel extends JPanel {

	private static final long serialVersionUID = 992059630592376542L;

	public ProgressPanel(int limit) {
		super();

		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		// create a label memory
		JLabel progressLabel = new JLabel("Speicher: ");
		progressLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		add(progressLabel);

		// shows user limit
		JProgressBar progressBar = new JProgressBar();
		progressBar.setToolTipText("Ihr verbleibender Speicher in %");
		progressBar.setStringPainted(true);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(false);
		progressBar.setPreferredSize(new Dimension(100, 8));
		progressBar.setValue(limit);
		add(progressBar);
	}
}
