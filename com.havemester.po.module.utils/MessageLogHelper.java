package com.havemester.po.module.utils;

import com.sap.engine.interfaces.messaging.api.APIAccessFactory;
import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.exception.MessagingException;
import com.sap.engine.interfaces.messaging.api.logger.MessageLogger;

/**
 * Helper class for SAP PI / PO message log access
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class MessageLogHelper {
	private       MessageLogger  messageLog;
	private final String         location;

	/**
	 * Initialize access to message log of SAP PI / PO messaging API
	 * 
	 * @param location log location
	 */
	
	public MessageLogHelper(String location) {
		this.location = location;
		
		try {
			this.messageLog = APIAccessFactory.getAPIAccess().getMessageLogger(this.location);
		} catch (MessagingException e) {
			this.messageLog = null;
			System.out.println("MSGLOG: MessageLogger not available for standalone testing, using stdout instead.");
			System.out.flush();
		}
	}

	
	/**
	 * Add entry to SAP PI / PO message log depending
	 * 
	 * @param message	log message
	 */
	
	public void add(Message message) {
		if (messageLog != null) {
			messageLog.log(message);
		} else {
			System.out.println( "MSGLOG: " + message);
			System.out.flush();
		}
	}
}
