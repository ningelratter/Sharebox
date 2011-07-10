package de.sharebox.entities;

/**
 * 
 * @author MW
 * @version 11.06.11
 */

public class TextFile extends AbstractFile {

	private String content;

	public TextFile() {
	}

	public TextFile(int userId, String name, Dir parent) {
		super(userId, name, parent);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean isDir() {
		return false;
	}
}