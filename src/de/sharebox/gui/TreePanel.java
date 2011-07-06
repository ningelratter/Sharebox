/**
 *
 */
package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * @author MW class thats shows users Directories and Files as a tree
 */
public class TreePanel extends ChangeablePanel implements ItemListener, ActionListener {

	private static final long serialVersionUID = -3558567367073733821L;

	private final File rootDir;
	private JPopupMenu jPopup;
	private JTree tree;
	private String userDir;

	TreePanel(Controller controller, final UserModel userModel) {
		super(controller);
		setLayout(null);
		final String label1 = "Order/Datei anlegen";
		final String label2 = "Ordner/Datei loeschen";
		final String label3 = "Order/Datei umbenennen";
		final String label4 = "Order/Datei einfuegen";
		final String label5 = "Eigenschaften";

		// get userPath
		User user = userModel.getUser();
		userDir = user.getRootDir();

		// if Tree is getting to big for screen, JScrollPane lets you navigate
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 594, 501);
		add(scrollPane);

		rootDir = new File(userDir);
		// sollte man hier nicht lieber den DirService aufrufen mit
		// createRootDirLocation?
		// andererseits besteht der Ordner theoretisch ja schon oder ist das
		// eher als Absicherung gedacht?
		rootDir.mkdir();

		// is creating a JTree with users Directories and Files
		tree = new JTree(new FileSystemModel(rootDir));

		scrollPane.setViewportView(tree);
		tree.setAutoscrolls(true);
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tree.setRootVisible(false);

		// listens on mouseActions in Tree
		tree.addMouseListener(new MouseAdapter() {

			public void mouseReleased(final MouseEvent evt) {

				// left mouse click
				if (evt.getButton() == MouseEvent.BUTTON1) {

					// TODO

				}
				// right mouse click
				else if (evt.getButton() == MouseEvent.BUTTON3) {

					jPopup = new JPopupMenu();
					JMenuItem newFolderItem = new JMenuItem(label1);

					jPopup.add(newFolderItem);

					jPopup.add(new JMenuItem(label2));
					jPopup.add(new JMenuItem(label3));
					jPopup.add(new JMenuItem(label4));
					jPopup.add(new JMenuItem(label5));
					jPopup.show(tree, getX(), getY());

					jPopup.show(evt.getComponent(), evt.getX(), evt.getY());
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent eevent1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	class FileSystemModel implements TreeModel {

		private final File root;

		private Vector<TreeModelListener> listeners = new Vector<TreeModelListener>();

		public FileSystemModel(File rootDirectory) {
			root = rootDirectory;
		}

		public Object getRoot() {
			return new TreeFile(root);
		}

		public Object getChild(Object parent, int index) {
			File directory = (File) parent;
			String[] children = directory.list();
			return new TreeFile(directory, children[index]);
		}

		public int getChildCount(Object parent) {
			File file = (File) parent;
			if (file.isDirectory()) {
				String[] fileList = file.list();
				if (fileList != null) {
					return file.list().length;
				}
			}
			return 0;
		}

		public boolean isLeaf(Object node) {
			File file = (File) node;
			return file.isFile();
		}

		public int getIndexOfChild(Object parent, Object child) {
			File directory = (File) parent;
			File file = (File) child;
			String[] children = directory.list();
			for (int i = 0; i < children.length; i++) {
				if (file.getName().equals(children[i])) {
					return i;
				}
			}
			return -1;

		}

		public void valueForPathChanged(TreePath path, Object value) {
			File oldFile = (File) path.getLastPathComponent();
			String fileParentPath = oldFile.getParent();
			String newFileName = (String) value;
			File targetFile = new File(fileParentPath, newFileName);
			oldFile.renameTo(targetFile);
			File parent = new File(fileParentPath);
			int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
			Object[] changedChildren = { targetFile };
			fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

		}

		private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {

			TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
			for (TreeModelListener listener : listeners) {
				listener.treeNodesChanged(event);
			}
		}

		public void addTreeModelListener(TreeModelListener listener) {
			listeners.add(listener);
		}

		public void removeTreeModelListener(TreeModelListener listener) {
			listeners.remove(listener);
		}

		private class TreeFile extends File {

			private static final long serialVersionUID = -2543661820439650693L;

			public TreeFile(File file) {
				super(file.getAbsolutePath());
			}

			public TreeFile(File parent, String child) {
				super(parent, child);
			}

			public String toString() {
				return getName();
			}
		}
	}

	public File getSelectedFile() {
		TreePath selectionPath = tree.getSelectionPath();
		if (selectionPath != null) {
			Object[] path = selectionPath.getPath();

			StringBuilder pathBuilder = new StringBuilder(userDir);

			if (path.length > 1) {
				for (int i = 1; i < path.length; i++) {
					pathBuilder.append("/" + path[i]);
				}
			}

			return new File(pathBuilder.toString());
		}

		return null;
	}

	public void updateTree() {
		tree.setModel(new FileSystemModel(rootDir));
	}
}