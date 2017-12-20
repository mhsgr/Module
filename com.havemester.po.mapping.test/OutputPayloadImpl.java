package com.havemester.po.mapping.test;

import java.io.OutputStream;

import com.sap.aii.mapping.api.OutputPayload;


/**
 * Access to the output payload of the mapping.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class OutputPayloadImpl extends OutputPayload {
	private OutputStream outputStream = null;
	
	/**
	 * Class constructor - OutputPayloadImpl
	 * 
	 * <p>Set output payload as OutputStream.
	 * 
	 * @param os OutputStream
	 */
	
	public OutputPayloadImpl(OutputStream os) {
		outputStream = os;
	}

	
	/**
	 * Get payload as OutputStream
	 * 
	 * @return payload OutputStream
	 */

	@Override
	public OutputStream getOutputStream() {
		return (outputStream);
	}
}
