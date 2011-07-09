package de.sharebox.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.sharebox.entities.Dir;

public class DirModelTest {
	private Dir dir;

	@Before
	public void setUp() throws Exception {

		dir = new Dir(50,"testDir",null);
	}

	@Test
	public void testSetDir() {
		
		//TODO
	}

}
