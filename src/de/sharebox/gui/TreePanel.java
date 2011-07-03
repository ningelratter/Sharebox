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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;
import de.sharebox.services.DirService;

/**
 * @author MW class thats shows users Directories and Files as a tree
 */
public class TreePanel extends ChangeablePanel implements ItemListener,
		ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File root;
	JTree tree;
	JPopupMenu jPopup;

	TreePanel(Controller controller, final UserModel userModel) {
		super(controller);
		setLayout(null);
		final String label1 = "Order/Datei anlegen";
		final String label2 = "Ordner/Datei löschen";
		final String label3 = "Order/Datei umbenennen";
		final String label4 = "Order/Datei einfügen";
		final String label5 = "Eigenschaften";

		// get userPath
		User user = userModel.getUser();
		final String userDir = user.getRootDir();

		// if Tree is getting to big for screen, JScrollPane lets you navigate
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 594, 501);
		add(scrollPane);

		// is creating a JTree with users Directories and Files
		final JTree tree = new JTree();

		scrollPane.setViewportView(tree);
		tree.setAutoscrolls(true);
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tree.setRootVisible(true);
		// creates new JTree
		buildTreeModelAccordingToDirectoryStructure(root = new File(userDir),
				tree);
		// listens on mouseActions in Tree
		tree.addMouseListener(new MouseAdapter() {

			public void mouseReleased(final MouseEvent evt) {
				try {
					// left mouse click
					if (evt.getButton() == MouseEvent.BUTTON1) {
						System.out.println("linksKlick");

						int selRow = tree.getRowForLocation(evt.getX(),
								evt.getY());
						TreePath selPath = tree.getPathForLocation(evt.getX(),
								evt.getY());

						// System.out.println(selRow);
						// System.out.println(selPath);
						String path = makePath(selPath.getPath());
						System.out.println(path);
						File file = new File(path);
						System.out.println(file.delete());
						String apath = file.getAbsolutePath();
						File file2 = new File(path);
						file2.createNewFile();
						
						System.out.println(file2.isFile());
						System.out.println(apath);
				
					DirService.removeDir(file2, userModel);

					
					// right mouse click
					if (evt.getButton() == MouseEvent.BUTTON3) {

						jPopup = new JPopupMenu();
						jPopup.add(new JMenuItem(label1));
						jPopup.add(new JMenuItem(label2));
						jPopup.add(new JMenuItem(label3));
						jPopup.add(new JMenuItem(label4));
						jPopup.add(new JMenuItem(label5));
						jPopup.show(tree, getX(), getY());

						jPopup.show(evt.getComponent(), evt.getX(), evt.getY());

					}
					}} catch (NullPointerException e) {

					e.getMessage();
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

			// creates a string containing path from TreePath Object
			private String makePath(Object[] p) {
				String temp = "";
				for (int i = 0; i < p.length; i++) {
					if (i != p.length - 1) {
						temp += p[i].toString() + "\\";
					} else {
						temp += p[i].toString();
					}
				}
				return temp;
			}

		});
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}