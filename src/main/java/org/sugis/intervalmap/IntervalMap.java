package org.sugis.intervalmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

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

	public IntervalMap<K, V> getContaining(K point) {
		return null;
	}
	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Map.Entry<Interval<K>, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Interval<K>> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V put(Interval<K> key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends Interval<K>, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
