/**
 *
 */
package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import de.sharebox.controller.Controller;
import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;

/**
 * @author MW class thats shows users Directories and Files as a tree
 */
public class TreePanel extends ChangeablePanel implements ItemListener, ActionListener, TreeSelectionListener {

	private static final long serialVersionUID = -3558567367073733821L;

	private Dir rootDir;
	private JTree tree;

	TreePanel(Controller controller) {
		super(controller);
		setLayout(null);

		// get userPath

		rootDir = controller.getRootDir();

		// if Tree is getting to big for screen, JScrollPane lets you navigate
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 594, 501);
		add(scrollPane);

		// is creating a JTree with users Directories and Files
		tree = new JTree(new FileModel(rootDir));

		scrollPane.setViewportView(tree);
		tree.setAutoscrolls(true);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent eevent1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	class FileModel implements TreeModel {

		private final Dir rootDir;

		private Vector<TreeModelListener> listeners = new Vector<TreeModelListener>();

		public FileModel(Dir rootDir) {
			this.rootDir = rootDir;
		}

		public Object getRoot() {
			return rootDir;
		}

		public Object getChild(Object parent, int index) {
			Dir dir = (Dir) parent;
			return dir.getChildren().get(index);
		}

		public int getChildCount(Object parent) {
			Dir dir = (Dir) parent;
			return dir.getChildren().size();
		}

		public boolean isLeaf(Object node) {

			AbstractFile file = (AbstractFile) node;
			return !file.isDir();
		}

		public int getIndexOfChild(Object parent, Object child) {
			// TODO
			return -1;
		}

		public void valueForPathChanged(TreePath path, Object value) {
			// TODO
		}

		public void addTreeModelListener(TreeModelListener listener) {
			listeners.add(listener);
		}

		public void removeTreeModelListener(TreeModelListener listener) {
			listeners.remove(listener);
		}
	}

	public AbstractFile getSelectedItem() {
		return (AbstractFile) tree.getLastSelectedPathComponent();
	}

	public void updateTree() {
		tree.setModel(new FileModel(rootDir));
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {

	}
}