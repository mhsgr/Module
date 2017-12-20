package com.havemester.po.mapping.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.DynamicConfigurationKey;


/**
 * Implementation class of DynamicConfiguration
 * 
 * <p>A DynamicConfiguration is a map containing adapter specific message
 * attributes. It associates DynamicConfigurationKeys with string values.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class DynamicConfigurationImpl extends DynamicConfiguration {
	private Map<DynamicConfigurationKey,String> map = new HashMap<DynamicConfigurationKey,String>();
	
	/**
	 * Returns true if this map contains an entry for the specified key, and
	 * false otherwise.
	 * 
	 * @param key
	 * @return true / false
	 */
	
	@Override
	public boolean containsKey(DynamicConfigurationKey key) {
		return map.containsKey(key);
	}

	
	/**
	 * Returns the value for the specified key.
	 * 
	 * @param key
	 * @return value
	 */
	
	@Override
	public String get(DynamicConfigurationKey key) {
		String value = map.get(key);
		return value;
	}

	
	/**
	 * Returns an iterator over all keys of this DynamicConfiguration.
	 * 
	 * @return iterator
	 */
	
	@Override
	public Iterator<DynamicConfigurationKey> getKeys() {
		return map.keySet().iterator();
	}

	
	/**
	 * Returns an iterator over the keys with the specified namespace.
	 * 
	 * @param name namespace of entries
	 * @return iterator
	 */
	
	@Override
	public Iterator<DynamicConfigurationKey> getKeys(String name) {
		Set<DynamicConfigurationKey> set = new HashSet<DynamicConfigurationKey>();
		
		for (DynamicConfigurationKey key: map.keySet()) {
			if (key.getNamespace().equals(name)) {
				set.add(key);
			}
		}
		
		return set.iterator();
	}

	
	/**
	 * Associates the specified value with the specified key.
	 * Return previous value
	 * 
	 * @param key dynamic configuration key
	 * @param value dynamic configuration value
	 * @return previous value
	 */
	
	@Override
	public String put(DynamicConfigurationKey key, String value) {
		String previous = map.get(key);
		map.put(key, value);
		System.out.println("DEBUG: DynamicConfiguration.put - key: " + key + "  value: " + value);
		return previous;
	}


	/**
	 * Removes the entry for this key if it is present.
	 * Return previous value.
	 * 
	 * @param key dynamic configuration key
	 * @return previous value
	 */
	
	@Override
	public String remove(DynamicConfigurationKey key) {
		String previous = map.get(key);
		map.remove(key);
		System.out.println("DEBUG: DynamicConfiguration.remove - key: " + key);
		return previous;
	}

	
	/**
	 * Removes all entries from the DynamicConfiguration.
	 */
	
	@Override
	public void removeAll() {
		map.clear();
	}

	
	/**
	 * Removes the entries whose keys have the specified namespace.
	 * 
	 * @param name namespace of entries
	 */
	
	@Override
	public void removeNamespace(String name) {
		Iterator<DynamicConfigurationKey> keys = this.getKeys(name);
		
		while(keys.hasNext()) {
			DynamicConfigurationKey key = keys.next();
			map.remove(key);
			System.out.println("DEBUG: DynamicConfiguration.removeNamespace(" + name + ")  removing: " + key);
		}
	}


	/**
	 * Returns the number of entries of this DynamicConfiguration.
	 * 
	 * @return number of entries
	 */
	
	@Override
	public int size() {
		return map.size();
	}

	
	/**
	 * Returns the number of entries with the specified namespace.
	 *
	 * @param name namespace of entries
	 * @return number of entries
	 */
	
	@Override
	public int size(String name) {
		int count = 0;
		
		Iterator<DynamicConfigurationKey> keys = this.getKeys(name);
		
		while(keys.hasNext()) {
			keys.next();
			count++;
		}
		
		return count;
	}
}
