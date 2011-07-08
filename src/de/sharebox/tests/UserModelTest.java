package de.sharebox.tests;

import junit.framework.Assert;

import org.junit.Test;

import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

public class UserModelTest {

	@Test
	public void test() {

		User user = new User("test", 1, 200, "123", "test@test.de", 0);

		UserModel userModel = new UserModel(user);

		User modelUser = userModel.getUser();

		// assert that the user model does not change the user
		Assert.assertEquals(user, modelUser);
	}

}
