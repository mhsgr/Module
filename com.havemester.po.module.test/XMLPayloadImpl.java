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

import com.sap.engine.interfaces.messaging.api.XMLPayload;


/**
 * Implementation class of XMLPayload
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class XMLPayloadImpl implements XMLPayload {
	private Map<String,String> attributes = new HashMap<String,String>();
	private byte[]				content		= null;
	private String				encoding	= null;
	private String				contentType	= null;
	private String				description	= null;
	private String				name		= null;
	private String				schema		= null;
	private String				version		= null;

	
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
	 * Sets the content as byte array into payload,
	 * also specifying the encoding.
	 * 
	 * @param content payload as byte[]
	 * @param encoding encoding of payload
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
	 * Sets the content as String, with the given
	 * encoding.
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
	public String getAttribute(String attributeName) {
		return attributes.get(attributeName);
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
	public void removeAttribute(String attributeName) {
		attributes.remove(attributeName);
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
	public void setAttribute(String attributeName, String value) {
		attributes.put(attributeName, value);
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
	 * Returns a description of the papyload.
	 * 
	 * @return description
	 */
	
	@Override
	public String getDescription() {
		return this.description;
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
	 * Returns XML document schema URL.
	 * 
	 * @return schema
	 */
	
	@Override
	public String getSchema() {
		return this.schema;
	}


	/**
	 * Returns the version of this payload.
	 * 
	 * @return version
	 */
	
	@Override
	public String getVersion() {
		return this.version;
	}


	/**
	 * Set content as byte array into payload.
	 * 
	 * @param content byte[]
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

	/**
	 * Sets the parameter containing a URL to an XML
	 * document schema.
	 * 
	 * @param schema
	 */
	
	@Override
	public void setSchema(String schema) {
		this.schema = schema;
	}

	
	/**
	 * Sets the version of this payload.
	 * 
	 * @param version
	 */
	
	@Override	public void setVersion(String version) {
		this.version = version;
	}
}
