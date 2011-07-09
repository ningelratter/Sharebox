package de.sharebox.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.sharebox.entities.History;

public class HistoryTest {
	private History history;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		history = new History(87, date, "Aktion");

	}

	@Test
	public void testSetUserId() {
		// assert that userId is set correctly
		int userId = history.getUserId();
		history.setUserId(userId);
		assertEquals("set correct userId", userId, history.getUserId());
	}

	@Test
	public void testSetDate() {
		// assert that date is set correctly
		Date date = history.getDate();
		history.setDate(date);
		assertEquals("set correct date", date, history.getDate());
	}

	@Test
	public void testSetActivity() {
		// assert that date is set Activity
		String activity = history.getActivity();
		history.setActivity(activity);
		assertEquals("set correct activity", activity, history.getActivity());
	}

	@Test
	public void testGetUserId() {
		// assert delivers right userId
		int userId = 40;
		history.setUserId(userId);
		assertEquals("delivers correct userId", userId, history.getUserId());

	}

	@Test
	public void testGetDate() {
		// assert delivers right Date
		history.setDate(date);
		assertEquals("delivers correct Date", date, history.getDate());
	}

	@Test
	public void testGetActivity() {
		// assert delivers right activity
		String activity = "Testfallschreiben";
		history.setActivity(activity);
		assertEquals("delivers correct Activity", activity,
				history.getActivity());
	}

	@After
	public void resetGlobal() {
		date = null;
		history = null;
	}

}
