package com.havemester.po.utils;

/**
 * Contains methods to generate and convert UUIDs
 * from / to SAP PI / PO message ids.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class UUID {
	private java.util.UUID UUID = null;

	/**
	 * Class constructor - UUID
	 * 
	 * <p>Generate new random UUID
	 */
	
	public UUID() {
		this.UUID = java.util.UUID.randomUUID();
	}
	

	/**
	 * Class constructor - UUID
	 * 
	 * <p>Set UUID to given id. Convert SAP PI / PO message id to UUID
	 * upfront
	 * 
	 * @param id UUID or message id
	 */
	
	public UUID (String messageId) {
		if(messageId.length() == 32) {
			messageId = messageId.substring(0, 8)   + "-" + messageId.substring(8, 12)  + "-" +   
						messageId.substring(12, 16) + "-" + messageId.substring(16, 20) + "-" +
						messageId.substring(20, 32);
		}
		
		this.UUID = java.util.UUID.fromString(messageId);
	}
	
	
	/**
	 * Returns the id formated as UUID (e.g. f119f2f8-2e43-488a-8655-bfc753eeb027)
	 * 
	 * @return UUID
	 */
	
	public String getUUID() {
		return UUID.toString();
	}
	
	/**
	 * Returns the id formated as SAP PI / PO message id
	 * (UUID without hyphens)
	 * 
	 * @return message id
	 */

	public String getMessageId() {
		return UUID.toString().replaceAll("-", "");
	}
}
