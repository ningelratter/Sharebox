/**
 * 
 */
package de.sharebox.gui;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
 * @author MW class thats shows users Directories and Files as a tree
 */
public class TreePanel extends ChangeablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File root;

	TreePanel(Controller controller, UserModel userModel) {
		super(controller);
		setLayout(null);
		// get userPath
		User user = userModel.getUser();
		String userDir = user.getRootDir();

		// if Tree is getting to big for screen, JScrollPane lets you navigate
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 594, 501);
		add(scrollPane);

		// is creating a JTree with users Directories and Files
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setVisibleRowCount(50);
		tree.setDragEnabled(true);
		tree.setAutoscrolls(true);
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tree.setRootVisible(true);
		// creates new JTree
		buildTreeModelAccordingToDirectoryStructure(root = new File(userDir),
				tree);

	}

	// builds Tree starting from given file
	void buildTreeModelAccordingToDirectoryStructure(File file, JTree tree) {
		tree.setModel(new DefaultTreeModel(new FileSystemTreeNode(file)));
	}

	// new innerClass FileSystemTreeNode
	class FileSystemTreeNode extends DefaultMutableTreeNode {
		// is sorting the files directorys
		Comparator comparator = new Comparator() {

			public int compare(Object o1, Object o2) {

				File file1 = (File) o1;
				File file2 = (File) o2;

				if (file1.isDirectory() && file2.isDirectory()) {
					return file1.getName().compareTo(file2.getName());
				} else if (file1.isDirectory()) {
					return -1;
				} else if (file2.isDirectory()) {
					return +1;
				}

				int point1 = file1.getName().lastIndexOf(".");
				int point2 = file2.getName().lastIndexOf(".");

				if (point1 == -1 || point2 == -1)
					return -1;

				String fileEnd1 = file1.getName()
						.substring(point1 + 1, file1.getName().length() - 1)
						.toLowerCase();
				String fileEnd2 = file2.getName()
						.substring(point2 + 1, file2.getName().length() - 1)
						.toLowerCase();

				int result = fileEnd1.compareTo(fileEnd2);

				if (result == 0)
					return file1.getName().compareTo(file2.getName());

				return result;

			}
		};

		ArrayList<File> currentFiles;

		public FileSystemTreeNode(File file) {
			setUserObject(file);
		}

		// gets the number of elements in the List
		public int getChildCount() {
			filterDirectories((File) getUserObject());

			if (currentFiles == null) {
				return 0;
			}

			return currentFiles.size();
		}

		// returns the child at index
		public TreeNode getChildAt(int index) {
			filterDirectories((File) getUserObject());

			return new FileSystemTreeNode(currentFiles.get(index));
		}

		public boolean isLeaf() {

			if (((File) getUserObject()).isFile())
				return true;
			return false;
		}

		private void filterDirectories(File file) {

			TreeMap directoryList = new TreeMap(comparator);

			// when file is directory then its stored in the "directoryList"
			if (file.isDirectory()) {

				File[] files = file.listFiles();

				for (int i = 0; i < files.length; i++) {

					directoryList.put(files[i], files[i]);

				}
				// puts all directorys out of the "directoryList" in the array
				// "currentFiles"
				currentFiles = new ArrayList<File>();
				for (Object o : directoryList.values()) {
					File folders = (File) o;

					currentFiles.add(folders);
				}
				// puts all files that are not directorys in an array
				// "currentFiles"
			} else {
				currentFiles = new ArrayList<File>();
				currentFiles.add(file);
			}
		}

	}
}
