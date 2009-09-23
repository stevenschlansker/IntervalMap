package org.sugis.intervalmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * An IntervalMap represents a map of Interval objects to values,
 * with the additional ability to query with a single parameter
 * and find the values of all intervals that contain it.
 * @author Steven Schlansker
 * @param <K> the type of the intervals' bounds
 * @param <V> the type of the values stored in the Map
 */
@NotThreadSafe
public class IntervalMap<K extends Comparable<K>, V> implements Map<Interval<K>, V> {
	
	private class IntervalNode {
		Interval<K> interval;
		K maxChildValue;
		V value;
		IntervalNode left, right;
	}
	
	private abstract class Traversal<R, A> {
		A accumulator;
		A getAccumulator() { return accumulator; }
		/** return null to continue traversal */
		abstract R visit(IntervalNode node);
	}
	
	private IntervalNode root;
	
	/**
	 * @param point
	 * @return
	 */
	public IntervalMap<K, V> getContaining(K point) {
		throw new AssertionError();
	}
	
	public void clear() {
		root = null;
	}

	public boolean containsKey(Object key) {
		if (! (key instanceof Interval<?>) || root == null) return false;
		throw new AssertionError();
	}

	public boolean containsValue(final Object value) {
		Boolean result = traverse(new Traversal<Boolean, Void>() {
			@Override
			Boolean visit(IntervalNode node) {
				if (node.value.equals(value)) return true;
				return null;
			}
		});
		if (result == true) return true; /* necessary because result could be null! */
		return false;
	}

	public Set<Map.Entry<Interval<K>, V>> entrySet() {
		final Set<Entry<Interval<K>, V>> result = new HashSet<Entry<Interval<K>,V>>();
		traverse(new Traversal<Void, Void>() {
			@Override
			Void visit(final IntervalNode node) {
				result.add(new Entry<Interval<K>, V>() {
					public Interval<K> getKey() {
						return node.interval;
					}
					public V getValue() {
						return node.value;
					}
					public V setValue(V value) {
						return node.value = value;
					}
				});
				return null;
			}
		});
		return result;
	}

	public V get(Object key) {
		throw new AssertionError();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Set<Interval<K>> keySet() {
		final Set<Interval<K>> result = new HashSet<Interval<K>>();
		traverse(new Traversal<Void, Void>() {
			@Override
			Void visit(final IntervalNode node) {
				result.add(node.interval);
				return null;
			}
		});
		return result;
	}

	public V put(Interval<K> key, V value) {
		throw new AssertionError();
	}

	public void putAll(Map<? extends Interval<K>, ? extends V> m) {
		for (Entry<? extends Interval<K>, ? extends V> e : m.entrySet()) {
			put(e.getKey(), e.getValue());
		}
	}

	public V remove(Object key) {
		throw new AssertionError();
	}

	public int size() {
		Traversal<Void, Integer> t = new Traversal<Void, Integer>() {
			@Override
			Void visit(IntervalNode node) {
				accumulator = accumulator + 1;
				return null;
			}
		};
		traverse(t);
		return t.getAccumulator();
	}

	public Collection<V> values() {
		final Collection<V> result = new ArrayList<V>();
		traverse(new Traversal<Void, Void>() {
			@Override
			Void visit(final IntervalNode node) {
				result.add(node.value);
				return null;
			}
		});
		return result;
	}
	
	private <R> R traverse(Traversal<R, ?> t) {
		Deque<IntervalNode> queue = new LinkedList<IntervalNode>();
		queue.offerFirst(root);
		while (!queue.isEmpty()) {
			IntervalNode node = queue.pop();
			if (node == null) continue;
			R result = t.visit(node);
			if (result != null) return result;
			queue.offerFirst(node.left);
			queue.offerFirst(node.right);
		}
		return null;
	}

}
