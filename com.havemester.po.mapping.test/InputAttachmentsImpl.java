package com.havemester.po.mapping.test;

import java.util.Collection;
import java.util.LinkedList;

import com.sap.aii.mapping.api.Attachment;
import com.sap.aii.mapping.api.InputAttachments;


/**
 * Implementation class of InputAttachments
 * 
 * Methods to read the attachments of the SAP PI / PO
 * message in the mapping.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class InputAttachmentsImpl implements InputAttachments {
	private Collection<Attachment> attachments = new LinkedList<Attachment>();

	/**
	 * Class constructor - InputAttachmentImpl
	 * 
	 * @param attachments collection of Attachment(s)
	 */
	
	public InputAttachmentsImpl(Collection<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	
	/**
	 * Returns true, if the attachments can be accessed in the mapping.
	 * 
	 * @return true or false
	 */
	
	@Override
	public boolean areAttachmentsAvailable() {
		return !attachments.isEmpty();
	}

	
	/**
	 * Get the content IDs of all attachments of the source message.
	 * 
	 * @param withRemoved include removed attachments
	 * @return collection of IDs
	 */
	
	@Override
	public Collection<String> getAllContentIds(boolean withRemoved) {
		Collection<String> ids = new LinkedList<String>();
		
		for (Attachment at: attachments) {
			ids.add(at.getContentId());
		}
		
		return ids;
	}

	
	/**
	 * Returns the attachment with the given contentId, provided there exists
	 * an attachment with this contentId. 
	 * 
	 * @param contentId
	 * @return attachment
	 */
	
	@Override
	public Attachment getAttachment(String contentId) {
		for (Attachment at: attachments) {
			if (at.getContentId().equals(contentId)) {
				return at;
			}
		}
		
		return null;
	}
}
