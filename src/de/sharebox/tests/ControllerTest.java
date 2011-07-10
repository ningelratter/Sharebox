package de.sharebox.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.services.FileService;
import de.sharebox.services.HistoryService;
import de.sharebox.services.UserService;

public class ControllerTest {

	private Controller controller;
	private UserService userService;

	private HistoryService historyService;

	private FileService fileService;
	private User loggedInUser;
	private final String password = "password";
	private User user, user2;

	@Before
	public void setUp() throws Exception {
		controller = new Controller();
		userService = new UserService();
		historyService = new HistoryService();
		fileService = new FileService();
		user = new User();
		user2 = new User();

	}

	@Test
	public void testCreateUser() {
		User user = controller.createUser("Tester", password, "tester@test.de");
		assertNotNull("user was created", user);
		assertEquals("userName equals set userName", user.getName(), "Tester");

	}

	@Test
	public void testRemoveUser() {
		// assert that user was correctly deleted
		user = controller.createUser("Tester2", password, "tester@test1.de");
		assertNotNull("user was created", user);
		controller.removeUser(user);
		assertNull("user was removed", controller.getUser("tester@test1.de"));
		assertNull("user was removed", controller.getUser("Tester", password));

	}

	@Test
	public void testLogin() {
		// assert
		user = controller.createUser("Tester3", password, "tester@test2.de");
		assertNotNull("user was created", user);
		loggedInUser = controller.login(user.getName(), user.getPassword());
		assertNotNull("loggedInUser contains data of user", loggedInUser);
		assertEquals("logged in User is created user", loggedInUser.getName(), user.getName());

	}

	@Test
	public void testLogout() {
		// assert logout is working properly
		user = controller.createUser("test", password, "test@web.de");
		User loggedInUser = controller.login(user.getName(), user.getPassword());
		assertEquals("loggedInUser equals created user", loggedInUser.getName(), "test");
		loggedInUser = controller.logout();
		assertNull("loggedInUser sucessfully loggedout", loggedInUser);

	}

	@Test
	public void testGetUserStringString() {
		// assert getUser by name&password works properly
		user = controller.createUser("testlauf", password, "testlauf@web.de");
		assertNotNull("user contains data", user);
		user2 = controller.getUser("testlauf", "password");
		assertEquals("user equals user2", user, user2);

	}

	@Test
	public void testGetUserString() {
		// assert getUser by mail works properly
		user = controller.createUser("testlauf2", password, "testlauf2@web.de");
		assertNotNull("user contains data", user);
		user2 = controller.getUser("testlauf2@web.de");
		assertEquals("user equals user2", user, user2);

	}

	@Test
	public void testSaveData() {

	}

	@Test
	public void testSetUserName() {

		user = controller.createUser("testlauf2", password, "testlauf2@web.de");
		controller.setUserName("martin");
		String image = user.getName();
		assertEquals("right name was set", image, "martin");
	}

	@Test
	public void testSetUserPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserLimit() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHistory() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTextFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRootDir() {
		fail("Not yet implemented");
	}

	public void resetGlobal() {
		controller = null;
		userService = null;
		historyService = null;
		fileService = null;
		controller.removeUser(loggedInUser);
		controller.removeUser(user);
		controller.removeUser(user2);
	}
}
