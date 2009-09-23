package org.sugis.intervalmap;

import junit.framework.TestCase;

/**
 * Test case for the Interval class
 * @see Interval
 * @author Steven Schlansker
 */
public class IntervalTestCase extends TestCase {

	private Interval<Integer> test1 = new Interval<Integer>(1, 4),
		test2 = new Interval<Integer>(4, 5),
		test3 = new Interval<Integer>(5, 10);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test hashCode method
	 * @see Interval#hashCode()
	 */
	public void testHashCode() {
		assertNotSame(test1.hashCode(), test2.hashCode());
		assertNotSame(test2.hashCode(), test3.hashCode());
		assertNotSame(test1.hashCode(), test3.hashCode());
	}

	/**
	 * Test getLowerBound
	 * @see Interval#getLowerBound()
	 */
	public void testGetLowerBound() {
		assertEquals(test1.getLowerBound().intValue(), 1);
		assertEquals(test3.getLowerBound().intValue(), 5);
	}

	/**
	 * Test getUpperBound
	 * @see Interval#getUpperBound()
	 */
	public void testGetUpperBound() {
		assertEquals(test1.getUpperBound(), test2.getLowerBound());
		assertEquals(test2.getUpperBound(), test3.getLowerBound());
	}

	/**
	 * Test equals
	 * @see Interval#equals(Object)
	 */
	public void testEqualsObject() {
		assertEquals(test1, new Interval<Integer>(1, 4));
		assertEquals(test2, new Interval<Integer>(4, 5));
		assertNotEquals(test1, test2);
	}
	
	private void assertNotEquals(Object a, Object b) {
		if (a.equals(b)) fail();
	}

	/**
	 * Test swapped bounds
	 * @see Interval#Interval(Comparable, Comparable)
	 */
	public void testSwappedBounds() {
		assertEquals(new Interval<Integer>(1, 10),
				new Interval<Integer>(10, 1));
		assertEquals(new Interval<Double>(.6, .888),
				new Interval<Double>(.888, .6));
	}
	
	/**
	 * Test overlaps
	 * @see Interval#overlapsWith(Interval)
	 */
	public void testOverlapsWith() {
		assertTrue(test1.overlapsWith(test2));
		assertTrue(test2.overlapsWith(test3));
		assertFalse(test1.overlapsWith(test3));
	}

}
