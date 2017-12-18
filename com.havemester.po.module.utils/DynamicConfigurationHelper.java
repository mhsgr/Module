package com.havemester.po.module.utils;

import java.util.Set;

import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessagePropertyKey;
import com.sap.engine.interfaces.messaging.api.exception.InvalidParamException;

/**
 * Helper class for access to SAP PI / PO dynamic configuration
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class DynamicConfigurationHelper {
	private final Message message;
	
	/**
	 * Initialize helper class for access to dynamic configuration
	 * 
	 * @param message SAP PI / PO message
	 */
	
	public DynamicConfigurationHelper (Message message) {
		this.message = message;
	}
	
	
	/**
	 * Get dynamic configuration attribute
	 * 
	 * @param namespace name space
	 * @param attribute name
	 * 
	 * @return value of dynamic configuration attribute or null if attribute was not found
	 */
	
	public String get(String namespace, String attribute) {
		return message.getMessageProperty(new MessagePropertyKey(attribute, namespace));		
	}

	
	/**
	 * Get dynamic configuration attribute
	 * 
	 * @param key MessagePropertyKey
	 * 
	 * @return value of dynamic configuration attribute or null if attribute was not found
	 */
	public String get(MessagePropertyKey key) {
		return message.getMessageProperty(key);		
	}

	
	/**
	 * Get all dynamic configuration attributes
	 * 
	 * @return set of all dynamic configuration attributes and values
	 */
	
	public Set<MessagePropertyKey> getAll() {
		return message.getMessagePropertyKeys();
	}

	
	/**
	 * Add dynamic configuration attribute
	 * 
	 * @param namespace name space
	 * @param attribute name
	 * @param value of attribute
	 * @throws InvalidParamException
	 */
	
	public void add(String namespace, String attribute, String value) throws InvalidParamException {
		message.setMessageProperty(new MessagePropertyKey(attribute, namespace), value );
	}

	
	/**
	 * Change dynamic configuration attribute
	 * 
	 * @param namespace name space
	 * @param attribute name
	 * @param value new value of attribute
	 * @throws InvalidParamException
	 */
	
	public void change(String namespace, String attribute, String value) throws InvalidParamException {
		MessagePropertyKey key = new MessagePropertyKey(attribute, namespace);
		
		message.removeMessageProperty(key);
		message.setMessageProperty(key, value);
	}

	
	/**
	 * Delete dynamic configuration attribute
	 * 
	 * @param namespace name space
	 * @param attribute name
	 */
	
	public void delete(String namespace, String attribute) {
		message.removeMessageProperty(new MessagePropertyKey(attribute, namespace));
	}
}
