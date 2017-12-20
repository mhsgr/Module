package com.havemester.po.mapping.test;

import java.util.HashMap;
import java.util.Map;

import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.lookup.Channel;


/**
 * Implementation class of InputAttachments
 * 
 * <p>Methods to access input parameters of the mapping.
 *
 * @author Michael Havemester
 * @version 1.0
 */

public class InputParametersImpl extends InputParameters {
	private Map<String,Object> map = new HashMap<String,Object>();
	
	/**
	 * Class constructor - InputParametersImpl
	 * 
	 * @param input parameters
	 */

	public InputParametersImpl(Map<String, Object> ip) {
		this.map = ip;
	}

	
	/**
	 * Returns the channel with the given name.  
	 * 
	 * @return channel 
	 */

	@Override
	public Channel getChannel(String name) {
		return (Channel) map.get(name);
	}


	/**
	 * Returns the value of an integer parameter with the given name.
	 * 
	 * @return parameter value (int)
	 */

	@Override
	public int getInt(String name) {
		return (Integer) map.get(name);
	}

	
	/**
	 * Returns the value of a string parameter with the given name.
	 * 
	 * @return parameter value (string)
	 */

	@Override
	public String getString(String name) {
		return (String) map.get(name);
	}

	
	/**
	 * Returns the value of a parameter with the given name.
	 * 
	 * @return parameter value
	 */

	@Override
	public Object getValue(String name) {
		return map.get(name);
	}
}
