package com.havemester.po.mapping.test;

import javax.xml.bind.DatatypeConverter;

import com.sap.aii.mapping.api.Attachment;

/**
 * 
 * Implementation class for Attachment
 * 
 * @author Michael Havemester
 * @version 1.0
 * 
 * int	hashCode()
 * Uses the content IDs hashCode.
 * 
 * String	toString() 
 */

public class AttachmentImpl implements Attachment {
	private String contentId   = null;
	private String contentType = null;
	private byte[] content     = null;

	
	/**
	 * Class constructor - attachment
	 * 
	 * @param contentId
	 * @param content
	 */
	
	public AttachmentImpl(String contentId, byte[] content) {
		this.contentId   = contentId;
		this.contentType = null;
		this.content     = content;
	}

	
	/**
	 * Class constructor - attachment
	 * 
	 * @param contentId
	 * @param contentType
	 * @param content
	 */
	
	public AttachmentImpl(String contentId, String contentType, byte[] content) {
		this.contentId   = contentId;
		this.contentType = contentType;
		this.content     = content;
	}

	
	/**
	 * Return the actual content of the attachment as
	 * Base64-encoded String.
	 */
	
	public String getBase64EncodedContent() {
		return DatatypeConverter.printBase64Binary(content);
	}

	
	/**
	 * Return the actual content of the attachment as byte array.
	 */
	
	public byte[] getContent() {
		return content;
	}
	
	
	/**
	 * Get the ContentId of the attachment. 
	 */
	
	public String getContentId() {
		return contentId;
	}
	
	
	/**
	 * Get the type of the attachment.
	 */
	
	public String getContentType() {
		return contentType;
	}

	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true / false
	 */
	
	public boolean equals(Object object) {
		if (object instanceof Attachment) {
			return contentId.equals(((Attachment) object).getContentId());
		}
		return false;
	}
	
	
	/**
	 * Return hashCode for attachment (use hashCode of contentId)
	 * 
	 * @return hash code
	 */
	
	public int hashCode() { return contentId.hashCode(); }
	
	
	/**
	 * Returns a string representation of the object.
	 * 
	 * @return String
	 */
	
	public String toString() {
		return "ContentId: " + contentId + "\n" +
			   "ContentType: " + contentType + "\n" +
			   "Content (hashcode): " + content.hashCode();
	}
}
