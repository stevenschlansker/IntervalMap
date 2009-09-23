package org.sugis.intervalmap;

import junit.framework.TestCase;

/**
 * IntervalMap test case
 * @see IntervalMap
 * @author Steven Schlansker
 */
public class IntervalMapTestCase extends TestCase {

	private IntervalMap<Integer, String> test = new IntervalMap<Integer, String>();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		test.put(new Interval<Integer>(5, 10), "fiveten");
		test.put(new Interval<Integer>(3, 5), "threefive");
		test.put(new Interval<Integer>(10, -5), "minusfiveten");
		test.put(new Interval<Integer>(0, 5), "zerofive");
	}

	/**
	 * Test getContaining
	 * @see IntervalMap#getContaining(Comparable)
	 */
	public void testGetContaining() {
		IntervalMap<Integer, String> result = test.getContaining(0);
		assertTrue(result.containsValue("minusfiveten"));
		assertTrue(result.containsValue("zerofive"));
		assertFalse(result.containsValue("fiveten"));
		assertFalse(result.containsValue("threefive"));
	}

	/**
	 * Test clear
	 * @see IntervalMap#clear()
	 */
	public void testClear() {
		test.clear();
		assertEquals(0, test.size());
		assertFalse(test.containsKey(new Interval<Integer>(3, 5)));
		assertFalse(test.containsValue("zerofive"));
	}

	/**
	 * Test containsKey
	 * @see IntervalMap#containsKey(Object)
	 */
	public void testContainsKey() {
		assertTrue(test.containsKey(new Interval<Integer>(3, 5)));
		assertTrue(test.containsKey(new Interval<Integer>(5, 10)));
		assertTrue(test.containsKey(new Interval<Integer>(5, 0)));
		assertTrue(test.containsKey(new Interval<Integer>(-5, 10)));
		assertFalse(test.containsKey(new Interval<Integer>(2, 5)));
		assertFalse(test.containsKey(new Interval<Integer>(3, 6)));
		assertFalse(test.containsKey(new Interval<Integer>(-5, 11)));
	}

	/**
	 * Test containsValue
	 * @see IntervalMap#containsValue(Object)
	 */
	public void testContainsValue() {
		assertTrue(test.containsValue("fiveten"));
		assertTrue(test.containsValue("threefive"));
		assertTrue(test.containsValue("minusfiveten"));
		assertTrue(test.containsValue("zerofive"));
		assertFalse(test.containsValue("blahblah"));
		assertFalse(test.containsValue(new Interval<Integer>(-5, 10)));
	}

	public void testEntrySet() {
		fail("Not yet implemented");
	}

	public void testGet() {
		fail("Not yet implemented");
	}

	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	public void testKeySet() {
		fail("Not yet implemented");
	}

	public void testPut() {
		fail("Not yet implemented");
	}

	public void testPutAll() {
		fail("Not yet implemented");
	}

	public void testRemove() {
		fail("Not yet implemented");
	}

	public void testSize() {
		fail("Not yet implemented");
	}

	public void testValues() {
		fail("Not yet implemented");
	}

}
