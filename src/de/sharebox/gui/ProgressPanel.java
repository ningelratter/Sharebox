package de.sharebox.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;

public class ProgressPanel extends JPanel {

	private static final long serialVersionUID = 992059630592376542L;

	public ProgressPanel(int limit) {
		super();

		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

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
