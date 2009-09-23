package org.sugis.intervalmap;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * An Interval is an immutable range over any Comparable
 * types - they do not necessarily need to be numbers.
 * @author Steven Schlansker
 * @param <K> the type of the bounds on the interval
 */
@Immutable
public class Interval<K extends Comparable<K>> {

	/* begin <= end */
	private final K lower, upper;
	
	/**
	 * Construct a new Interval
	 * @param lower_in the beginning of the interval
	 * @param upper_in the end of the interval
	 */
	public Interval(@Nonnull K lower_in, @Nonnull K upper_in) {
		if (lower_in.compareTo(upper_in) > 0) {
			lower = upper_in;
			upper = lower_in;
		} else {
			lower = lower_in;
			upper = upper_in;
		}
	}
	
	/**
	 * @return the lower bound given at construction
	 */
	public K getLowerBound() { return lower; }
	
	/**
	 * @return the upper bound given at construction
	 */
	public K getUpperBound() { return upper; }
	
	@Override
	public String toString() {
		return "Interval[" + lower + "," + upper + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Interval<?>) )
			return false;
		Interval<?> other = (Interval<?>) obj;
		return other.upper.equals(upper) && other.lower.equals(lower);
	}
	
	@Override
	public int hashCode() {
		return lower.hashCode() ^ upper.hashCode();
	}
	
}