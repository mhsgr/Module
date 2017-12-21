package com.havemester.po.module.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sap.engine.interfaces.messaging.api.TextPayload;


/**
 * Implementation class of TextPayload
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class TextPayloadImpl implements TextPayload {
	private Map<String,String> attributes = new HashMap<String,String>();
	private byte[]				content		= null;
	private String				contentType	= null;
	private String				description	= null;
	private String				encoding	= null;
	private String				name		= null;

	
	/**
	 * Returns the content of this payload as a String.
	 * 
	 * return payload
	 */

	@Override
	public String getText() {
		try {
			return new String(this.content, this.encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * Set content as byte array into payload.
	 * 
	 * @param content payload as byte[]
	 * @param enconding enconding of payload
	 */

	@Override
	public void setContent(byte[] content, String encoding) {
		this.content = content;
		this.encoding = encoding;
	}

	
	/**
	 * Set content as String into payload.
	 * 
	 * @param text payload as String
	 */

	@Override
	public void setText(String text) {
		this.content = text.getBytes();
		this.encoding = new OutputStreamWriter(new ByteArrayOutputStream()).getEncoding();
	}

	
	/**
	 * Set content as String into payload.
	 * 
	 * @param text payload as String
	 * @param encoding encoding of payload 
	 */

	@Override
	public void setText(String text, String encoding) throws IOException {
		this.content = text.getBytes(encoding);
		this.encoding = encoding;
	}

	
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
	 * @param name name of attribute to be removed
	 */

	@Override
	public void removeAttribute(String name) {
		attributes.remove(name);
	}

	
	/**
	 * Sets the specified payload attribute value for
	 * the given content attribute name, like e.g.
	 * content-type or content-disposition.
	 * 
	 * @param name name of attribute to be removed
	 * @param value attribute value
	 */

	@Override
	public void setAttribute(String name, String value) {
		attributes.put(name, value);
	}

	
	/**
	 * Returns the encoding of the input stream you can
	 * get with getInputStream or the content you can get
	 * with getContent.
	 * 
	 * @return enconding
	 */

	@Override
	public String getEncoding() {
		return this.encoding;
	}

	
	/**
	 * Returns the content of this payload as a byte array.
	 * 
	 * @return byte[] payload
	 */

	@Override
	public byte[] getContent() {
		return this.content;
	}

	
	/**
	 * Returns the content type of the payload.
	 * 
	 * @return contentType
	 */

	@Override
	public String getContentType() {
		return this.contentType;
	}

	
	/**
	 * Returns a description of the payload.
	 * 
	 * @return description
	 */

	@Override
	public String getDescription() {
		return this.description;
	}

	
	/**
	 * Returns an InputStream to the content of this payload.
	 * 
	 * @return InputStream of payload
	 */

	@Override
	public InputStream getInputStream() {
		return new ByteArrayInputStream(this.content);
	}

	
	/**
	 * Returns the logical name of this payload.
	 * 
	 * @return payload name
	 */

	@Override
	public String getName() {
		return this.name;
	}

	
	/**
	 * Returns a Reader to the content of this payload.
	 * 
	 * @return InputStreamReader
	 */

	@Override
	public Reader getReader() {
		return new InputStreamReader(new ByteArrayInputStream(content));
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
