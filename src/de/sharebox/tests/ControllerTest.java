package de.sharebox.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.sharebox.controller.Controller;
import de.sharebox.entities.History;
import de.sharebox.entities.User;

public class ControllerTest {

	private Controller controller;

	private User loggedInUser;
	private final String password = "password";
	private User user, user2, user3, user4;

	@Before
	public void setUp() throws Exception {
		controller = new Controller();
		user = new User("Tester", 90, 100, password, "tester@test.de", 0);
		loggedInUser = new User();

	}

	@Test
	public void testCreateUser() {
		// assert that user was created
		user2 = controller.createUser("Tester2", password, "tester2@test.de");
		assertNotNull("user was created", user2);
		assertEquals("userName equals set userName", user2.getName(), "Tester2");
	}

	@Test
	public void testRemoveUser() {
		// assert that user was correctly deleted
		user2 = controller.createUser("Tester2", password, "tester2@test.de");
		controller.removeUser(user2);
		assertNull("user was removed", controller.getUser("tester2@test.de"));
		assertNull("user was removed", controller.getUser("Tester2", password));

	}

	@Test
	public void testLogin() {
		// assert loggedInUser is the right user
		user3 = controller.createUser("testfall", password, "testfall@test.de");
		loggedInUser = controller.login(user3.getName(), user3.getPassword());
		assertEquals("logged in User is created user", loggedInUser.getName(),
				user3.getName());
		controller.removeUser(user3);
	}

	@Test
	public void testLogout() {
		// assert logout is working properly

		user3 = controller.createUser("testfall", password, "testfall@test.de");
		loggedInUser = controller.login(user3.getName(), user3.getPassword());
		assertEquals("logged in User is created user", loggedInUser.getName(),
				user3.getName());

		loggedInUser = controller.logout();
		assertNull("loggedInUser sucessfully loggedout", loggedInUser);

	}

	@Test
	public void testGetUserStringString() {
		// assert getUser by name&password works properly
		user4 = controller.createUser("testfall32", password,
				"testfall22@test.de");
		loggedInUser = controller.getUser(user4.getName(), user4.getPassword());
		assertEquals("user4 equals loggedInUser", user4.getName(),
				loggedInUser.getName());
	}

	@Test
	public void testGetUserString() {
		// assert getUser by mail works properly
		user2 = controller.createUser("testfall312", password,
				"testfall232@test.de");
		user = controller.getUser(user2.getMail());
		assertEquals("user equals user2", user.getName(), user2.getName());
	}

	@Test

	public void testSetUserName() {
		// assert changing userName works correctly
		user = controller.createUser("testlauf", password, "testlauf2@web.de");
		controller.setUserName("martin");
		String image = user.getName();
		assertEquals("right name was set", image, "martin");
	}

	@Test
	public void testSetUserPassword() {
		// assert changing user password works correctly
		user = controller.createUser("testlauf", password, "testlauf2@web.de");
		controller.setUserPassword(user, "password2");
		String image = user.getPassword();
		assertEquals("right password was set", image, "password2");
	}

	@Test
	public void testSetUserEmail() {
		// assert changing userMail works correctly
		user = controller.createUser("testlauf", password, "testlauf2@web.de");
		controller.setUserEmail(user, "testlauflauf");
		String image = user.getMail();
		assertEquals("right mail was set", image, "testlauflauf");
	}

	@Test
	public void testSetUserLimit() {
		// assert changing userLimit works correctly
		user = controller.createUser("testlauf", password, "testlauf2@web.de");
		controller.setUserLimit(user, 200);
		int limit = user.getLimit();
		assertEquals("right limit was set", limit, 200);
	}

	@Test
	public void testGetHistory() {
		// asserts that history can be shown
		List<History> list = controller.getHistory(user.getId());
		assertNotNull("list contains data", list);
	}

	public void resetGlobal() {
		controller = null;
		user = null;
		user2 = null;
		user3 = null;
		user4 = null;
		loggedInUser = null;
	}
}
