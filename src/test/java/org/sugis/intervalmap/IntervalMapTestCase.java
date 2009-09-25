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

	private static final String ZEROFIVESTRING = "zerofive";
	private static final String MINUSFIVETENSTRING = "minusfiveten";
	private static final String THREEFIVESTRING = "threefive";
	private static final String FIVETENSTRING = "fiveten";
	private static final Interval<Integer> ZEROFIVEINTERVAL = new Interval<Integer>(0, 5);
	private static final Interval<Integer> MINUSFIVETENINTERVAL = new Interval<Integer>(10, -5);
	private static final Interval<Integer> THREEFIVEINTERVAL = new Interval<Integer>(3, 5);
	private static final Interval<Integer> FIVETENINTERVAL = new Interval<Integer>(5, 10);
	private IntervalMap<Integer, String> test = new IntervalMap<Integer, String>();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		test.put(FIVETENINTERVAL, FIVETENSTRING);
		test.put(THREEFIVEINTERVAL, THREEFIVESTRING);
		test.put(MINUSFIVETENINTERVAL, MINUSFIVETENSTRING);
		test.put(ZEROFIVEINTERVAL, ZEROFIVESTRING);
	}

	/**
	 * Test getContaining
	 * @see IntervalMap#getContaining(Comparable)
	 */
	public void testGetContaining() {
		IntervalMap<Integer, String> result = test.getContaining(0);
		assertTrue(result.containsValue(MINUSFIVETENSTRING));
		assertTrue(result.containsValue(ZEROFIVESTRING));
		assertFalse(result.containsValue(FIVETENSTRING));
		assertFalse(result.containsValue(THREEFIVESTRING));
	}

	/**
	 * Test clear
	 * @see IntervalMap#clear()
	 */
	public void testClear() {
		test.clear();
		assertEquals(0, test.size());
		assertFalse(test.containsKey(THREEFIVEINTERVAL));
		assertFalse(test.containsValue(ZEROFIVESTRING));
	}

	/**
	 * Test containsKey
	 * @see IntervalMap#containsKey(Object)
	 */
	public void testContainsKey() {
		assertTrue(test.containsKey(THREEFIVEINTERVAL));
		assertTrue(test.containsKey(FIVETENINTERVAL));
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
		assertTrue(test.containsValue(FIVETENSTRING));
		assertTrue(test.containsValue(THREEFIVESTRING));
		assertTrue(test.containsValue(MINUSFIVETENSTRING));
		assertTrue(test.containsValue(ZEROFIVESTRING));
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
		assertEquals(test.get(THREEFIVEINTERVAL), THREEFIVESTRING);
		assertEquals(test.get(FIVETENINTERVAL), FIVETENSTRING);
		assertEquals(test.get(new Interval<Integer>(5, 0)), ZEROFIVESTRING);
		assertEquals(test.get(new Interval<Integer>(-5, 10)), MINUSFIVETENSTRING);
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
		Set<Interval<Integer>> keySet = test.keySet();
		assertEquals(test.size(), keySet.size());
		for (Interval<Integer> key : keySet) {
			assertTrue(test.containsKey(key));
		}
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
		test.remove(FIVETENINTERVAL);
		assertEquals(3, test.size());
	}

	/**
	 * Test values
	 * @see IntervalMap#values()
	 */
	public void testValues() {
		Collection<String> values = test.values();
		assertTrue(values.contains(FIVETENSTRING));
		assertTrue(values.contains(THREEFIVESTRING));
		assertTrue(values.contains(MINUSFIVETENSTRING));
		assertTrue(values.contains(ZEROFIVESTRING));
		assertEquals(4, values.size());
	}

}
