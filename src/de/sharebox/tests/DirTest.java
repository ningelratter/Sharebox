package de.sharebox.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.sharebox.entities.AbstractFile;
import de.sharebox.entities.Dir;

public class DirTest {

	private Dir dir, dir1, dir2;
	private List<AbstractFile> children;

	@Before
	public void setUp() throws Exception {

		dir = new Dir(11, "testDir", null);
		dir1 = new Dir(12, "testDir1", dir);
		children = new ArrayList<AbstractFile>();
		children.add(dir);
		children.add(dir1);
		dir2 = new Dir(12, "testDir2", dir1);

	}

	@Test
	public void testIsDir() {
		// assert that dir and dir1 are directories
		boolean bDir = dir.isDir();
		boolean bDir1 = dir1.isDir();
		assertTrue("dir is Directoy", bDir);
		assertTrue("dir1 is Directoy", bDir1);
		assertNotSame(dir, dir1);
	}

	@Test
	public void testGetChildren() {
		// assert that list can be printed
		List<AbstractFile> liste = dir1.getChildren();
		assertNotNull("Liste contains data", liste);
	}

	@Test
	public void testAddChild() {
		// assert that adding child to abstract list works
		List<AbstractFile> liste2 = dir2.getChildren();
		dir2.addChild(dir2);

		assertNotNull("child was sucesfully added", liste2.get(0));
		assertEquals("list2 entrey equals dir2", liste2.get(0), dir2);

	}

	@After
	public void resetGlobal() {

		dir = null;
		dir1 = null;
		children = null;
	}
}
