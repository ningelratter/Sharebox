package de.sharebox.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author MW aus Berlin
 * @version 11.06.11
 * 
 */

public class Dir extends AbstractFile {

	private List<AbstractFile> children = new ArrayList<AbstractFile>();

	public Dir(int userId, String name, Dir parent) {
		super(userId, name, parent);
	}

	public List<AbstractFile> getChildren() {
		return children;
	}

	public void addChild(AbstractFile child) {
		children.add(child);
	}

	public void removeChild(AbstractFile childToRemove) {

		List<AbstractFile> newChildren = new ArrayList<AbstractFile>();

		for (AbstractFile child : children) {
			if (!child.getName().equals(childToRemove.getName())) {
				newChildren.add(child);
			}
		}

		children = newChildren;
	}

	@Override
	public boolean isDir() {
		return true;
	}
}