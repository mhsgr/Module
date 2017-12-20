package com.havemester.po.mapping.test;

import com.sap.aii.mapping.api.OutputHeader;


/**
 * Implementation class of OutputHeader
 * 
 * <p>Methods to access fields of the message header.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class OutputHeaderImpl extends OutputHeader {
	String contentType = null;

	/**
	 * Message objects have an attribute "content type". Use this method to set its
	 * value after the mapping. If this method is not used during the mapping, the
	 * content type of the message object remains unchanged after the mapping.
	 * 
	 * @param type content type of the message
	 */
	
	@Override
	public void setContentType(String type) {
		contentType = type;
		System.out.println("DEBUG: OutputHeader.setContentType: " + type);
	}
}
