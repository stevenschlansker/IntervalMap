package org.sugis.intervalmap;

import java.util.Collection;
import java.util.Set;
import java.util.Map.Entry;

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

	/**
	 * Test entrySet
	 * @see IntervalMap#entrySet()
	 */
	public void testEntrySet() {
		Set<Entry<Interval<Integer>, String>> eSet = test.entrySet();
		assertEquals(test.size(), test.entrySet().size());
		for (Entry<Interval<Integer>, String> e : eSet) {
			assertTrue(test.containsKey(e.getKey()));
			assertTrue(test.containsValue(e.getValue()));
		}
	}

	/**
	 * Test get
	 * @see IntervalMap#get(Object)
	 */
	public void testGet() {
		assertEquals(test.get(new Interval<Integer>(3, 5)), "threefive");
		assertEquals(test.get(new Interval<Integer>(5, 10)), "fiveten");
		assertEquals(test.get(new Interval<Integer>(5, 0)), "zerofive");
		assertEquals(test.get(new Interval<Integer>(-5, 10)), "minusfiveten");
	}

	/**
	 * Test isEmpty
	 * @see IntervalMap#isEmpty()
	 */
	public void testIsEmpty() {
		assertFalse(test.isEmpty());
		test.clear();
		assertTrue(test.isEmpty());
	}

	/**
	 * Test keySet
	 * @see IntervalMap#keySet()
	 */
	public void testKeySet() {
		fail("Not yet implemented");
	}

	/**
	 * Test put
	 * @see IntervalMap#put(Interval, Object)
	 */
	public void testPut() {
		int oldHashCode = test.hashCode();
		assertEquals(4, test.size());
		test.put(new Interval<Integer>(4,5), "fourfive");
		assertEquals(5, test.size());
		assertNotSame(test.hashCode(), oldHashCode);
	}

	/**
	 * Test remove
	 * @see IntervalMap#remove(Object)
	 */
	public void testRemove() {
		assertEquals(4, test.size());
		test.remove(new Interval<Integer>(5,10));
		assertEquals(3, test.size());
	}

	/**
	 * Test values
	 * @see IntervalMap#values()
	 */
	public void testValues() {
		Collection<String> values = test.values();
		assertTrue(values.contains("fiveten"));
		assertTrue(values.contains("threefive"));
		assertTrue(values.contains("minusfiveten"));
		assertTrue(values.contains("zerofive"));
		assertEquals(4, values.size());
	}

}
