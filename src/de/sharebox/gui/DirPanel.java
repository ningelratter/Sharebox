package de.sharebox.gui;

import javax.swing.JTree;

import de.sharebox.controller.Controller;

/**
 * ? TODO describe the function of this class 
 * 
 * @author MW
 * @version 11.06.11
 *
 */

public class DirPanel extends ChangeablePanel {
	public DirPanel(Controller c) {
		super(c);
		
		JTree tree = new JTree();
		tree.setBounds(119, 144, 179, 155);
		add(tree);
	}
	}
