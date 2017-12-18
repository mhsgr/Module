package com.havemester.po.module.utils;

import com.sap.aii.af.lib.mp.module.ModuleContext;
import com.sap.aii.af.lib.mp.module.ModuleException;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditLogStatus;


/**
 * Helper class for access to SAP PI / PO module parameters
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class ParameterHelper {
	private final ModuleContext  moduleContext;
	private final AuditLogHelper auditLog;

	
	/**
	 * Class constructor - initialize module context and audit log
	 *  
	 * @param moduleContext SAP adapter module context
	 * @param auditLog access to message audit log
	 */
	
	public ParameterHelper (ModuleContext moduleContext, AuditLogHelper auditLog) {
		this.moduleContext = moduleContext;
		this.auditLog      = auditLog;
	}

	
	/**
	 * Get module parameter by key. Return default value, if parameter not found. 
	 * Add entry to audit log, if debug is set to true.
	 *  
	 * @param key parameter name
	 * @param def default value
	 * @param debug 
	 * @return parameter value
	 */
	
	public String getParameter (String key, String def, Boolean debug) {
		String value = moduleContext.getContextData(key);
		
		if (value == null) {
			value = def;
			auditLog.add (AuditLogStatus.SUCCESS, debug, "Parameter '" + key + "' not found, using default value: " + value);
		} else {
			auditLog.add (AuditLogStatus.SUCCESS, debug, "Parameter " + key + ": " + value);
		}

		return value;
	}

	
	/**
	 * Get module parameter by key. Throw ModuleException, if parameter not found. 
	 * Add entry to audit log, if debug is set to true.
	 *  
	 * @param key parameter name
	 * @param debug 
	 * @return parameter value
	 * @throws ModuleException
	 */
	
	public String getParameter (String key, Boolean debug) throws ModuleException {
		String value = moduleContext.getContextData(key);
		
		if (value == null) {
			auditLog.add (AuditLogStatus.ERROR, debug, "Mandatory parameter '" + key + "' not found.");
			throw new ModuleException ("Mandatory parameter '" + key + "' not found.");
		} else {
			auditLog.add (AuditLogStatus.SUCCESS, debug, "Parameter " + key + ": " + value);
		}
		
		return value;
	}
	
	
	/**
	 * Get module parameter by key. Return default value, if parameter not found. 
	 * Add entry to audit log.
	 *  
	 * @param key parameter name
	 * @param def default value
	 * @return parameter value
	 */
	
	public String getParameter (String key, String def) throws ModuleException {
		return getParameter(key, def, true);
	}

	
	/**
	 * Get module parameter by key. Throw ModuleException, if parameter not found. 
	 * Add entry to audit log.
	 *  
	 * @param key parameter name
	 * @return parameter value
	 * @throws ModuleException
	 */

	public String getParameter (String key) throws ModuleException {
		return getParameter(key, true);
	}
	
	
	/**
	 * Get module integer parameter by key. Return default value, if parameter not found. 
	 * Add entry to audit log, if debug is set to true.
	 *  
	 * @param key parameter name
	 * @param def default value
	 * @param debug 
	 * @return integer parameter value
	 * @throws ModuleException, if parameter value is not an integer
	 */

	public int getIntParameter (String key, int def, Boolean debug) throws ModuleException {
		String value = getParameter(key, Integer.toString(def), debug);

		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			auditLog.add (AuditLogStatus.ERROR, debug, "Parameter " + key + ": " + value);
			throw new ModuleException("Only integers allowed for "+ key + " (" + value + ")");
		}
	}

	
	/**
	 * Get module integer parameter by key. Throw ModuleException, if parameter is
	 * not found or is not an integer value. Add entry to audit log, if debug is
	 * set to true.
	 *  
	 * @param key parameter name
	 * @param debug 
	 * @return integer parameter value
	 * @throws ModuleException, if parameter is not found or value is not an integer
	 */

	public int getIntParameter (String key, boolean debug) throws ModuleException {
		String value = getParameter(key, debug);
		
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			auditLog.add (AuditLogStatus.ERROR, debug, "Parameter " + key + ": " + value);
			throw new ModuleException("Only integers allowed for "+ key + " (" + value + ")");
		}
	}

	
	/**
	 * Get module integer parameter by key. Throw ModuleException, if parameter is
	 * not found or is not an integer value. Add entry to audit log.
	 *  
	 * @param key parameter name
	 * @return integer parameter value
	 * @throws ModuleException, if parameter is not found or value is not an integer
	 */

	public int getIntParameter (String key) throws ModuleException {
		return getIntParameter(key, true);
	}

	
	/**
	 * Get module boolean parameter by key. Return default value, if parameter not found. 
	 * Add entry to audit log, if debug is set to true.
	 *  
	 * @param key parameter name
	 * @param def default value
	 * @param debug 
	 * @return integer parameter value
	 * @throws ModuleException, if parameter value is not a boolean
	 */

	public boolean getBooleanParameter (String key, boolean def, Boolean debug) throws ModuleException {
		String value = getParameter(key, Boolean.toString(def), debug);

		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			auditLog.add (AuditLogStatus.ERROR, debug, "Parameter " + key + ": " + value);
			throw new ModuleException("Only boolean allowed for "+ key + " (" + value + ")");
		}
	}
	
	
	/**
	 * Get module boolean parameter by key. Throw ModuleException, if parameter is
	 * not found or is not an integer value. Add entry to audit log, if debug is
	 * set to true.
	 *  
	 * @param key parameter name
	 * @param debug 
	 * @return integer parameter value
	 * @throws ModuleException, if parameter is not found or value is not a boolean
	 */

	public boolean getBooleanParameter (String key, boolean debug) throws ModuleException {
		String value = getParameter(key, debug);
		
		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			auditLog.add (AuditLogStatus.ERROR, debug, "Parameter " + key + ": " + value);
			throw new ModuleException("Only boolean allowed for "+ key + " (" + value + ")");
		}
	}

	
	/**
	 * Get module boolean parameter by key. Throw ModuleException, if parameter is
	 * not found or is not an integer value. Add entry to audit log.
	 *  
	 * @param key parameter name
	 * @return integer parameter value
	 * @throws ModuleException, if parameter is not found or value is not a boolean
	 */

	public boolean getBooleanParameter (String key) throws ModuleException {
		return getBooleanParameter(key, true);
	}
}
