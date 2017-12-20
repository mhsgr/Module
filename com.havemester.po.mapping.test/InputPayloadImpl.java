package com.havemester.po.mapping.test;

import java.io.InputStream;

import com.sap.aii.mapping.api.InputPayload;


/**
 * Implementation class of InputPayload
 * 
 * <p>Methods to access the input payload of the mapping.
 *
 * @author Michael Havemester
 * @version 1.0
 */

public class InputPayloadImpl extends InputPayload {
	private InputStream inputStream = null;
	
	/**
	 * Class constructor - InputPayloadImpl
	 * 
	 * <p>Set input payload as InputStream.
	 * 
	 * @param is InputStream
	 */
	
	public InputPayloadImpl(InputStream is) {
		inputStream = is;
	}

	
	/**
	 * Get payload as InputStream
	 * 
	 * @return payload InputStream
	 */
	
	@Override
	public InputStream getInputStream() {
		return (inputStream);
	}
}
