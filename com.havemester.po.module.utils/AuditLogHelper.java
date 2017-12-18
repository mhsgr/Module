package com.havemester.po.module.utils;

import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessageKey;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccessFactory;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditAccess;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditLogStatus;
import com.sap.engine.interfaces.messaging.api.exception.MessagingException;


/**
 * Helper class for SAP PI / PO audit log access
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class AuditLogHelper {
	private AuditAccess	auditLog	= null;
	private MessageKey	messageKey	= null;

	/**
	 * Class constructor - initialize AuditAccess and MessageKey used by SAP PI / PO
	 * messaging API
	 * 
	 * @param message SAP PI / PO message
	 */
	
	public AuditLogHelper (Message message){
		// get message key for audit log access
		messageKey = new MessageKey(message.getMessageId(), message.getMessageDirection());
		
		// Get audit log
		try {
			auditLog = PublicAPIAccessFactory.getPublicAPIAccess().getAuditAccess();						
		} catch (MessagingException e) {
			auditLog = null;
			System.out.println("AUDIT: Audit log not available for standalone testing, using stdout instead.");
			System.out.flush();
		}
	}

	
	/**
	 * Add entry to SAP PI / PO message audit log depending on
	 * parameter logging
	 * 
	 * @param status	ERROR, SUCCESS, WARNING
	 * @param logging	boolean, add entry to audit log if set to true
	 * @param message	log message
	 */
	
	public void add (AuditLogStatus status, Boolean logging, String message) {
		String statusString = "SUCCESS";
		
		if (logging) {
			if (auditLog != null) {
				auditLog.addAuditLogEntry(messageKey, status, message);	
			} else {
				if (status.equals(AuditLogStatus.ERROR)) {
					statusString = "ERROR";
				} else if (status.equals(AuditLogStatus.WARNING)) {
					statusString = "WARNING";
				}
				
				System.out.println( "AUDIT (" + statusString + "): " + message);
				System.out.flush();
			}
		}
	}


	/**
	 * Add entry to SAP PI / PO message audit log
	 * 
	 * @param status	ERROR, SUCCESS, WARNING
	 * @param message	log message
	 */

	public void add (AuditLogStatus status, String message) {
		this.add(status, true, message);
	}
}
