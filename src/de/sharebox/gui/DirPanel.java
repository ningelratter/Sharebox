package de.sharebox.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTree;

import de.sharebox.controller.Controller;

public class DirPanel extends ChangeablePanel {
	public DirPanel(Controller c) {
		super(c);
		
		JTree tree = new JTree();
	
		tree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tree.setShowsRootHandles(true);
		tree.setEditable(true);
		add(tree, BorderLayout.CENTER);
	}

	
	}
