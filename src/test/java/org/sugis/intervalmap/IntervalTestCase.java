package org.sugis.intervalmap;

import junit.framework.TestCase;

/**
 * Test case for the Interval class
 * @see Interval
 * @author Steven Schlansker
 */
public class IntervalTestCase extends TestCase {

	private Interval<Integer> test1 = new Interval<Integer>(1, 5),
		test2 = new Interval<Integer>(4, 6),
		test3 = new Interval<Integer>(7, 10);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test hashCode method
	 * @see Interval#hashCode()
	 */
	public void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test getLowerBound
	 * @see Interval#getLowerBound()
	 */
	public void testGetLowerBound() {
		fail("Not yet implemented");
	}

	/**
	 * Test getUpperBound
	 * @see Interval#getUpperBound()
	 */
	public void testGetUpperBound() {
		fail("Not yet implemented");
	}

	/**
	 * Test equals
	 * @see Interval#equals(Object)
	 */
	public void testEqualsObject() {
		fail("Not yet implemented");
	}
	
	public void testSwappedBounds() {
		assertEquals(new Interval<Integer>(1, 10),
				new Interval<Integer>(10,1));
	}

}
