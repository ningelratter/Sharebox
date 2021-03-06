package de.sharebox.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Directories can hold others directories and files.
 * @author MW 
 * @version 11.06.11
 * 
 */

public class Dir extends AbstractFile implements Serializable {

	private static final long serialVersionUID = 106498166012293975L;

	private List<AbstractFile> children = new ArrayList<AbstractFile>();

	public Dir() {
	}

	public Dir(int userId, String name, Dir parent) {
		super(userId, name, parent);
	}

	public List<AbstractFile> getChildren() {
		return children;
	}

	public void setChildren(List<AbstractFile> children) {
		for (AbstractFile child : children) {
			addChild(child);
		}
		this.children = children;
	}

	public void addChild(AbstractFile child) {
		child.setParent(this);
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