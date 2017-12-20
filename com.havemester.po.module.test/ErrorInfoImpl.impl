package com.havemester.po.module.test;

import java.util.HashMap;
import java.util.Map;

import com.sap.engine.interfaces.messaging.api.ErrorInfo;

/**
 * Implementation class of ErrorInfo
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class ErrorInfoImpl implements ErrorInfo {
	private Map<String,String> attributes = new HashMap<String,String>();	

	/**
	 * Returns the requested ErrorInfo attribute.
	 * 
	 * @param name attribute name
	 * @return value attribute value
	 */
	@Override
	public String getAttribute(String name) {
		return attributes.get(name);
	}

	
	/**
	 * Protocol specific ErrorInfo container implementations to
	 * specify, which attribute names are known by the setAttribute
	 * method.
	 * 
	 * @return String[] attribute names
	 */
	
	@Override
	public String[] getSupportedAttributeNames() 		{
		throw new RuntimeException("ErrorInfo.getSupportedAttributeNames() not implemented.");
	}

	
	/**
	 * Sets the ErrorInfo attribute given by name.
	 * 
	 * @param name ErrorInfo attribute name
	 * @value value ErrorInfo attribute value
	 */
	
	@Override
	public void setAttribute(String name, String value) {
		attributes.put(name, value);
	}
}
