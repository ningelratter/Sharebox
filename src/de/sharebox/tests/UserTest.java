package de.sharebox.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.sharebox.entities.User;

public class UserTest {
	private User user;

	@Before
	public void setUp() throws Exception {

		user = new User("tester", 99, 100, "pwd", "tester@test.de", 0);

	}

	@Test
	public void testSetName() {
		user.setName("Neuertester");
		// assert name was set
		assertEquals("userName equals Neuertester", user.getName(), "Neuertester");

	}

	@Test
	public void testSetId() {

		user.setId(30);
		// assert id was set
		assertEquals("userId equals 30", user.getId(), 30);

	}

	@Test
	public void testSetLimit() {

		user.setLimit(200);
		// assert limit was set
		assertEquals("userLimit equals 200", user.getLimit(), 200);

	}

	@Test
	public void testSetPassword() {
		// assert password was set
		user.setPassword("12345");
		assertEquals("userPwd equals 12345", user.getPassword(), "12345");

	}

	@Test
	public void testSetMail() {
		// assert mail was set
		user.setMail("tester@web.de");
		assertEquals("userMail equals tester@web.de", user.getMail(), "tester@web.de");
	}

	@Test
	public void testSetLanguage() {
		// assert language was set
		user.setLanguage(1);
		assertEquals("userLanguage equals 1", user.getLanguage(), 1);

	}

	@Test
	public void testGetName() {
		// assert getName() delivers right userName
		String name = user.getName();
		assertNotNull("name is not Null", name);
		assertEquals("name equals tester", name, "tester");

	}

	@Test
	public void testGetId() {
		// assert getId() delivers right userId
		int userId = user.getId();
		assertNotNull("Id is not Null", userId);
		assertEquals("userId equals 99", userId, 99);

	}

	@Test
	public void testGetLimit() {
		// assert getLimit() delivers right userLimit
		int userLimit = user.getLimit();
		assertNotNull("Limit is not Null", userLimit);
		assertEquals("userLimit equals 100", userLimit, 100);

	}

	@Test
	public void testGetPassword() {

		// assert getPwd() delivers right userPwd
		String pwd = user.getPassword();
		assertNotNull("Pwd is not Null", pwd);
		assertEquals("pwd equals pwd", pwd, "pwd");

	}

	@Test
	public void testGetMail() {
		// assert getMail() delivers right userMail
		String mail = user.getMail();
		assertNotNull("mail ist not Null", mail);
		assertEquals("mail equals tester@test.de", mail, "tester@test.de");

	}

	@Test
	public void testGetLanguage() {

		// assert getMail() delivers right userMail
		int language = user.getLanguage();
		assertNotNull("language ist not Null", language);
		assertEquals("language equals 0", language, 0);

	}

	@Test
	public void testToString() {

		// assert that ToString delivers a String containing the userId and name

		String test = user.toString();
		assertNotNull("String ist not Null", test);
		assertEquals("test equals userId:name", test, "99: tester");

	}

	@Test
	public void testGetRootDir() {
		// assert rootDir is not Null and the same which was set
		int userId = user.getId();
		String stringUserId = String.valueOf(userId);
		String rootDir = user.getRootDir();
		assertNotNull("rootDir ist not Null", rootDir);
		String path = System.getProperty("user.dir") + "/" + stringUserId;
		assertEquals("rootDir equals userID", rootDir, path);

	}

	@After
	public void resetGlobal() {

		user = null;

	}
}