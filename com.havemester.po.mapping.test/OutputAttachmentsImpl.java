package com.havemester.po.mapping.test;

import java.util.HashMap;
import java.util.Map;

import com.sap.aii.mapping.api.Attachment;
import com.sap.aii.mapping.api.OutputAttachments;


/**
 * Implementation of class OutputAttachments
 * 
 * <p>Methods to set, change, or remove attachments of the XI message
 * in the mapping. You can always use these methods, even if the Operation
 * Mapping declares that it does not read attachments.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

/*
 * Adds a new attachment.
 */

public class OutputAttachmentsImpl implements OutputAttachments {
	private Map<String,Attachment> map = new HashMap<String,Attachment>();

	/**
	 * Creates a new attachment with the given content id and content.
	 * 
	 * @param contentId attachment content id
	 * @param content attachment content
	 * @return attachment
	 */
	
	@Override
	public Attachment create(String contentId, byte[] content) {
		return new AttachmentImpl(contentId, content);
	}


	/**
	 * Creates a new attachment with the given content id, content type
	 * and content.
	 * 
	 * @param contentId attachment content id
	 * @param contentType attachment content type
	 * @param content attachment content
	 * @return attachment
	 */
	
	@Override
	public Attachment create(String contentId, String contentType, byte[] content) {
		return new AttachmentImpl(contentId, contentType, content);
	}

	/**
	 * Removes the attachment with the given content id.
	 * 
	 * @param contentId attachment content id
	 */
	
	@Override
	public void removeAttachment(String contentId) {
		map.remove(contentId);
	}

	
	/**
	 * Adds a new attachment.
	 *
	 * @param attachment
	 */
	
	@Override
	public void setAttachment(Attachment attachment) {
		map.put(attachment.getContentId(), attachment);
	}
}
