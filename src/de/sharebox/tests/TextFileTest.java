package de.sharebox.tests;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.sharebox.entities.Dir;

public class TextFileTest {
	private Dir dir, dir1;

	@Before
	public void setUp() throws Exception {

		dir = new Dir(99, "testFile", null);
		dir1 = new Dir(98, "testFile1", dir);
	}

	@Test
	public void testIsDir() {
		// assert that dir and dir1 is directory
		boolean bDir = dir.isDir();
		boolean bDir1 = dir1.isDir();
		assertTrue("dir is Directoy", bDir);
		assertTrue("dir1 is Directoy", bDir1);
		assertNotSame(dir, dir1);

	}

	@After
	public void resetGlobal() {

		dir = null;
		dir1 = null;

	}

}
