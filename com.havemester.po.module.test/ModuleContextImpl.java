package com.havemester.po.module.test;

import java.util.Enumeration;
import java.util.Hashtable;

import com.sap.aii.af.lib.mp.module.ModuleContext;
import com.sap.aii.af.service.cpa.Channel;


/**
 * Implementation class of ModuleContext
 * 
 * <p>Methods to access the module context.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class ModuleContextImpl implements ModuleContext {
	private static final long serialVersionUID = 5173280226823344290L;

	protected Hashtable<String,String>	contextData	= null;
	protected String					channelID	= null;
	protected Channel					channel		= null;
	
	public ModuleContextImpl(String channelID, Hashtable<String, String> contextData) {
		this.channelID		= channelID;
		this.contextData	= contextData;
	}

	
	/**
	 * Returns the id of the currently processed channel.
	 * 
	 * @param channelID
	 * @param contextData
	 */
	
	public String getChannelID() {
		return this.channelID;
	}

	
	/**
	 * Returns a value of a module configuration parameter with
	 * the given name.
	 * 
	 * @param name parameter name
	 * @return String parameter value
 	 */
	
	public String getContextData(String name) {
		return (String) this.contextData.get(name);
	}
	

	/**
	 * Returns the value of a module configuration parameter with.
	 * the given name.
	 * 
	 * <p>If fallback is true and the parameter cannot be found in
	 * the module configuration it is tried to read it from the
	 * channel configuration data.
	 *
	 * @param name parameter name
	 * @param fallback true / false
	 * @return String parameter value 
	 */
	
	public String getContextData(String name, boolean fallback) {
		String val = (String) contextData.get(name);
		
		if (val != null) {
			return val;
		}

		if (fallback == true) {
			System.err.println("ModuleContext.getContextData fallback = true not implemented.");
		}

		return val;
	}


	/**
	 * Get all configuration parameter keys (names) of this channel
	 * 
	 * @return keys Enumeration of Strings 
	 */
	
	public Enumeration<String> getContextDataKeys() {
		return this.contextData.keys();
	}

	
	/**
	 * Get all configuration parameters with given namespace
	 * of this module in this channel
	 * 
	 * @param namespace parameter namespace
	 * @return parameters Hashtable<String,String> of configuration parameters.
	 */
	
	public Hashtable<String, String> resolveNamespace (String nameSpace) {
		String 						search		= nameSpace + ".";
		Hashtable<String, String>	hashtable	= new Hashtable<String, String>();
		Enumeration<String>			dataKeys	= getContextDataKeys();

		while (dataKeys.hasMoreElements()) {
			String data = (String) dataKeys.nextElement();
			
			if (data.startsWith(search)) {
				String key = data.substring(search.length());
				hashtable.put(key, getContextData(data));
			}
		}
		
		return hashtable;
	}
}
