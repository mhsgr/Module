package com.havemester.po.mapping.test;

import java.util.HashMap;
import java.util.Map;

import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.UndefinedParameterException;
import com.sap.aii.mapping.api.WrongParameterTypeException;


/**
 * Access to output parameters of the mapping.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class OutputParametersImpl extends OutputParameters {
	private Map<String, Object> map = new HashMap<String, Object>();

	
	/**
	 * Returns true if the parameter list contains an entry for the
	 * specified name, and false otherwise.
	 * 
	 * @param name
	 * @return true / false
	 */

	public boolean exists(String name) {
		return map.containsKey(name);
	}

	
	/**
	 * Set the value of an integer parameter with the given name.
	 * 
	 * @param name parameter name
	 * @param value parameter value (int)
	 */
	
	@Override
	public void setInt(String name, int value)
			throws UndefinedParameterException, WrongParameterTypeException {
		map.put(name, value);
	}

	
	/**
	 * Set the value of a string parameter with the given name.
	 * 
	 * @param name parameter name
	 * @param value parameter value (string)
	 */
	
	@Override
	public void setString(String name, String value)
			throws UndefinedParameterException, WrongParameterTypeException {
		map.put(name, value);
	}

	
	/**
	 * Set the value of a parameter with the given name.
	 * 
	 * @param name parameter name
	 * @param value parameter value
	 */

	@Override
	public void setValue(String name, Object value)
			throws UndefinedParameterException, WrongParameterTypeException {
		map.put(name, value);
	}
}
