package com.havemester.po.mapping.test;

import com.sap.engine.interfaces.messaging.api.MessageKey;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditAccess;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditLogStatus;


/**
 * Implementation class for AuditAccess
 * 
 * <p>The AuditAccess interface offers methods to write an AuditLogEntry to the memory
 * audit store with the given status. For performance reasons all AuditLogEntry
 * objects, created with this method will by default be kept in the memory audit
 * store, till they are explicitly flushed to the DB for a specific MessageKey.
 * 
 * <p>This will usually be done automatically by the Messaging System, whenever
 * a message reached a final state (i.e. DELIVERED, NOT DELIVERED, FAILED).
 * AuditLogEntry objects are merged together from the memory audit store and
 * the BC_MSG_AUDIT DB table (and sorted), before they are getting returned to
 * the UI for displaying purpose, through the method getAuditEntryList
 * (PublicMessageKey msgKey) of the AuditLogManager class.
 * 
 * <p>There are several auditSuccess, auditWarning and auditError method signatures,
 * which allow to commit the PublicMesageKey, if not known and the parameters for
 * the text key, if available.
 *
 * <p>If third party Adapter developers want to use the offered AuditLog capabilities,
 * they are required to create a MessageKey (consisting of a GUID messageId and
 * a MessageDirection object) as early as possible and to pass that MessageKey to
 * the AdapterFramework, as part of the Message representation.
 * 
 * <p>Since flushing the AuditLogEntries for a specific MessageKey causes DB access
 * and therefore is a performance issue, it's up the application developers, when
 * and how often they need to call the flush method additionally, to avoid loosing
 * audit entries (especially in case of errors on sending side).
 *
 * @author Michael Havemester
 * @version 1.0
 * 

 */

public class AuditAccessImpl implements AuditAccess {
	
	/**
	 * Writes an AuditLogEntry to the memory audit store with the given status.
	 * 
	 * @param msgKey message key
	 * @param status audit log status
	 * @param text output text
	 */
	
	@Override
	public void addAuditLogEntry(MessageKey msgKey, AuditLogStatus status, String text) {
		System.err.println("AUDIT-LOG: " + msgKey + " (" + statusStr(status) + ") - " + text);
	}

	
	/**
	 * Writes an AuditLogEntry to the memory audit store with the given status.
	 * 
	 * @param msgKey message key
	 * @param status audit log status
	 * @param text output text
	 * @param parms additional parameters
	 */
	
	@Override
	public void addAuditLogEntry(MessageKey msgKey, AuditLogStatus status, String text, Object[] parms) {
		throw new RuntimeException ("AuditAccess.addAuditLogEntry(MessageKey, AuditLogStatus, String, Object[]) not implemented.");
	}

	
	/**
	 * This method is used to explicitly flush all AuditLogEntry
	 * objects stored in the memory audit store for a given MessagKey
	 * to the BC_MSG_AUDIT DB table.
	 * 
	 * @param msgKey message key
	 */
	
	@Override
	public void flushAuditLogEntries(MessageKey msgKey) {
		System.err.flush();
	}

	
	/**
	 * Return string representation of AuditLogStatus
	 * 
	 * @param status audit log status
	 * @return status string
	 */
	
	private String statusStr(AuditLogStatus status) {
		if (status == AuditLogStatus.SUCCESS) { return "SUCCESS"; }
		if (status == AuditLogStatus.ERROR)   { return "ERROR"; }
		if (status == AuditLogStatus.WARNING) { return "WARNING"; }
		
		return status.toString();
	}
}
