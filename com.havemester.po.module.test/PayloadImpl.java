package com.havemester.po.module.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sap.engine.interfaces.messaging.api.Payload;


/**
 * Implementation class of Payload
 * 
 * @author Michael Havemester
 * @version 1.0
 */


public class PayloadImpl implements Payload {
	private Map<String,String> attributes = new HashMap<String,String>();
	private byte[]				content		= null;
	private String				contentType	= null;
	private String				description	= null;
	private String				name		= null;

	
	/**
	 * Removes all currently present payload attributes.
	 */
	
	@Override
	public void clearAttributes() {
		attributes = new HashMap<String, String>();
	}


	/**
	 * Gets the specified payload attribute value for
	 * the given content attribute name, like
	 * e.g. content-type or content-disposition.
	 * 
	 * @param name attribute name
	 * @return value attribute value
	 */
	
	@Override
	public String getAttribute(String name) {
		return attributes.get(name);
	}


	/**
	 * Get list of payload attribute names
	 * 
	 * @return attributeNames
	 */
	
	@Override
	public Set<String> getAttributeNames() {
		return attributes.keySet();
	}


	/**
	 * Removes the specified payload attribute value
	 * for the given content attribute name, like
	 * e.g. content-type or content-disposition.
	 * 
	 * @param name
	 */
	
	@Override
	public void removeAttribute(String name) {
		attributes.remove(name);
	}


	/**
	 * Sets the specified payload attribute value for
	 * the given content attribute name, like
	 * e.g. content-type or content-disposition.
	 * 
	 * @param name attribute name
	 * @param value attribute value
	 */
	
	@Override
	public void setAttribute(String name, String value) {
		attributes.put(name, value);
	}


	/**
	 * Returns the content of this payload as a byte array.
	 * 
	 * return byte[] payload
	 */
	
	@Override
	public byte[] getContent() {
		return content;
	}


	/**
	 * Returns the content type of the payload.
	 * 
	 * @return contentType
	 */
	
	@Override
	public String getContentType() {
		return contentType;
	}


	/**
	 * Returns a description of the payload.
	 * 
	 * @return description
	 */
	
	@Override
	public String getDescription() {
		return description;
	}


	/**
	 * Returns an InputStream to the content of this payload.
	 * 
	 * @return InputStream
	 */
	
	@Override
	public InputStream getInputStream() {
		return new ByteArrayInputStream(content);
	}


	/**
	 * Returns the logical name of this payload.
	 * 
	 * @return name payload name
	 */
	
	@Override
	public String getName() {
		return name;
	}


	/**
	 * Set content as byte array into payload.
	 * 
	 * @param content
	 */
	
	@Override
	public void setContent(byte[] content) {
		this.content = content;
	}


	/**
	 * Sets the content type of the payload.
	 * 
	 * @param contentType
	 */
	
	@Override
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	/**
	 * Sets a description of the payload.
	 * 
	 * @param description
	 */
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Sets the name of this payload.
	 * 
	 * @param name payload name
	 */
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
