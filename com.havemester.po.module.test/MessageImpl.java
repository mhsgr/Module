package com.havemester.po.module.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sap.engine.interfaces.messaging.api.AckType;
import com.sap.engine.interfaces.messaging.api.Action;
import com.sap.engine.interfaces.messaging.api.DeliverySemantics;
import com.sap.engine.interfaces.messaging.api.ErrorInfo;
import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessageClass;
import com.sap.engine.interfaces.messaging.api.MessageDirection;
import com.sap.engine.interfaces.messaging.api.MessageKey;
import com.sap.engine.interfaces.messaging.api.MessagePropertyKey;
import com.sap.engine.interfaces.messaging.api.Party;
import com.sap.engine.interfaces.messaging.api.Payload;
import com.sap.engine.interfaces.messaging.api.Service;
import com.sap.engine.interfaces.messaging.api.TextPayload;
import com.sap.engine.interfaces.messaging.api.XMLPayload;


/**
 * Implementation class of Message
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class MessageImpl implements Message {
	private static final long 		serialVersionUID	= -8507636257040651852L;

	private Map<String,Payload> attachments				= new HashMap<String,Payload>();
	private HashMap<MessagePropertyKey,String> hm		= null;
	private Set<MessagePropertyKey> msgPropertyKeys		= null;
	private Payload					payload				= null;
	private String					correlationId		= null;
	private DeliverySemantics		deliverySemantics	= null;
	private String					description			= null;
	private ErrorInfo				errorInfo			= null;
	private String					refToMessageId		= null;
	private String					sequenceId			= null;
	private Action					action				= null;
	private Party					fromParty			= null;
	private Party					toParty				= null;
	private Service					fromService			= null;
	private Service					toService			= null;
	private MessageClass			messageClass		= null;
	private MessageDirection		messageDirection	= null;
	private String					messageId			= null;
	private MessageKey				messageKey			= null;
	private String					protocol			= null;
	private String					serializationContext= null;
	private long					timeReceived;
	private long					timeSent;

	
	/**
	 * Class constructor - MessageImpl
	 * 
	 * <p>Initialize message properties
	 * 
	 * @param fromParty
	 * @param fromService
	 * @param action
	 * @param toParty
	 * @param toService
	 * @param messageClass
	 * @param messageDirection
	 * @param messageId
	 * @param protocol
	 * @param serializationContext
	 */
	
	public MessageImpl(String fromParty, String fromService, String action,
						String toParty, String toService, MessageClass messageClass,
						MessageDirection messageDirection, String messageId, String protocol,
						String serializationContext) {
		this.fromParty				= new Party(fromParty);
		this.fromService			= new Service(fromService);
		this.action					= new Action(action);
		this.toParty				= new Party(toParty);
		this.toService				= new Service(toService);
		this.messageClass			= messageClass;
		this.messageDirection		= messageDirection;
		this.messageId				= messageId;
		this.messageKey				= new MessageKey(messageId, messageDirection);
		this.protocol				= protocol;
		this.serializationContext	= serializationContext;
		this.hm						= new HashMap<MessagePropertyKey, String>();
		this.msgPropertyKeys		= new HashSet<MessagePropertyKey>();
	}

	
	/**
	 * Adds an attachment to the message.
	 * 
	 * @param attachment
	 */
	
	@Override
	public void addAttachment(Payload attachment) {
		attachments.put(attachment.getName(), attachment);
	}

	
	/**
	 * Returns the number of attachments in this message.
	 * 
	 * @return number of attachments
	 */
	
	@Override
	public int countAttachments() {
		return attachments.size();
	}

	
	/**
	 * Returns an attachment by name if the XML message protocol used
	 * for this message supports attachment names.
	 *
	 * @param name attachment name
	 * @return attachment
	 */
	
	@Override
	public Payload getAttachment(String name) {
		return attachments.get(name);
	}

	
	/**
	 * Returns an iterator to iterate over the attachments.
	 * 
	 *  @return iterator of attachments
	 */
	
	@Override
	public Iterator<Payload> getAttachmentIterator() {
		return attachments.values().iterator();
	}

	
	/**
	 * Removes an attachment by name if the XML message protocol
	 * used for this message supports attachment names.
	 * 
	 * @param name name of attachment to be removed
	 */

	@Override
	public void removeAttachment(String name) {
		attachments.remove(name);
	}

	
	/**
	 * Returns the value of an additional message property with
	 * the given key, in case that such an value exists.
	 * 
	 * @param MessagePropertyKey
	 * @return messageProperty
	 */

	@Override
	public String getMessageProperty(MessagePropertyKey msgPropertyKey) {
		return this.hm.get(msgPropertyKey);
	}

	
	/**
	 * Returns the value of an additional message property with
	 * the given namespace / name, in case that such an value exists.
	 * 
	 * <p>Deprecated.
	 * <p>Use getMessageProperty(MessagePropertyKey), instead.
	 */

	@Override
	public String getMessageProperty(String namespace, String name) {
		throw new RuntimeException("Message.getMessageProperty(namespace, name) is deprecated. Use getMessageProperty(msgPropertyKey) instead");
	}

	
	/**
	 * Returns all keys of existing additional message property,
	 * which can be used to retrieve the corresponding values.
	 * 
	 * @return Set of MessagePropertyKey
	 */

	@Override
	public Set<MessagePropertyKey> getMessagePropertyKeys() {
		return this.msgPropertyKeys;
	}

	
	/**
	 * Removes the entry of an additional message property,
	 * in case that such an entry exists.
	 * 
	 * @param msgPropertyKey
	 */

	@Override
	public void removeMessageProperty(MessagePropertyKey msgPropertyKey) {
		if (this.msgPropertyKeys.contains(msgPropertyKey)) {
			this.msgPropertyKeys.remove(msgPropertyKey);
			this.hm.remove(msgPropertyKey);
		}
	}

	
	/**
	 * Sets an additional message field, if supported
	 * by the Message protocol implementation.
	 * 
	 * @param MessagePropertyKey
	 * @param value
	 */

	@Override
	public void setMessageProperty(MessagePropertyKey msgPropertyKey,
			String value) {
		// Check if Property already exists
		if (this.msgPropertyKeys.contains(msgPropertyKey)) {
			if (value == null) {
				this.msgPropertyKeys.remove(msgPropertyKey);
				this.hm.remove(msgPropertyKey);
			} else {
				// Update the property value
				this.hm.put(msgPropertyKey, value);
			}
		} else {
			this.msgPropertyKeys.add(msgPropertyKey);
			this.hm.put(msgPropertyKey, value);
		}
	}

	
	/**
	 * Sets an additional message field, if supported
	 * by the Message protocol implementation.
	 * 
	 * <p>Deprecated.
	 * <p>Use setMessageProperty(MessagePropertyKey, String), instead.
	 */

	@Override
	public void setMessageProperty(String namespace, String name, String value) {
		throw new RuntimeException("Message.setMessageProperty(namespace, name, value) is deprecated. Use setMessageProperty(msgPropertyKey, value) instead");
	}

	
	/**
	 * Creates a new protocol implementation specific version
	 * of the ErrorInfo container interface and returns it.
	 * 
	 * @return ErrorInfo
	 */

	@Override
	public ErrorInfo createErrorInfo() {
		return new ErrorInfoImpl();
	}

	
	/**
	 * Creates an empty binary payload.
	 * 
	 * @return empty binary payload
	 */

	@Override
	public Payload createPayload() {
		return new PayloadImpl();
	}

	
	/**
	 * Creates an empty text payload.
	 * 
	 * @return empty text payload
	 */

	@Override
	public TextPayload createTextPayload() {
		return new TextPayloadImpl();
	}

	
	/**
	 * Creates an empty XML payload.
	 * 
	 * @return empty XML payload
	 */

	@Override
	public XMLPayload createXMLPayload() {
		return new XMLPayloadImpl();
	}

	
	/**
	 * Returns the Action in the service that shall process
	 * this message.
	 * 
	 * @return Action
	 */

	@Override
	public Action getAction() {
		return this.action;
	}

	
	/**
	 * Returns the correlation ID that identifies a sequence
	 * messages, which semantically belong together.
	 * 
	 * @return correlationId
	 */

	@Override
	public String getCorrelationId() {
		return this.correlationId;
	}

	
	/**
	 * Returns the delivery semantics (QoS) of the message.
	 * 
	 * @return deliverySemantics
	 */

	@Override
	public DeliverySemantics getDeliverySemantics() {
		return this.deliverySemantics;
	}

	
	/**
	 * Returns a descriptive text for the message.
	 * 
	 * @return description
	 */

	@Override
	public String getDescription() {
		return this.description;
	}

	
	/**
	 * Returns the main document as XMLPayload.
	 * 
	 * @return XMLPayload
	 */

	@Override
	public XMLPayload getDocument() {
		return (XMLPayload) this.payload;
	}

	
	/**
	 * Returns the ErrorInfo container of the
	 * current message, if available.
	 * 
	 * @return ErrorInfo
	 */

	@Override
	public ErrorInfo getErrorInfo() {
		return this.errorInfo;
	}

	
	/**
	 * Returns the Party object that represents the sender.
	 * 
	 * @return fromParty
	 */

	@Override
	public Party getFromParty() {
		return this.fromParty;
	}

	
	/**
	 * Returns the Service object that represents the
	 * service that originally sent this message.
	 * 
	 * @return fromService
	 */

	@Override
	public Service getFromService() {
		return this.fromService;
	}

	
	/**
	 * Returns the main payload.
	 * 
	 * @return Payload
	 */

	@Override
	public Payload getMainPayload() {
		return this.payload;
	}

	
	/**
	 * Returns the message class of this message.
	 * 
	 * @return MessageClass
	 */

	@Override
	public MessageClass getMessageClass() {
		return this.messageClass;
	}

	
	/**
	 * Returns the direction of the message.
	 * 
	 * @return MessageDirection
	 */

	@Override
	public MessageDirection getMessageDirection() {
		return this.messageDirection;
	}

	
	/**
	 * Returns the unique message ID.
	 * 
	 * @return messageId
	 */

	@Override
	public String getMessageId() {
		return this.messageId;
	}

	
	/**
	 * Returns the MessageKey.
	 * 
	 * @return MessageKey
	 */

	@Override
	public MessageKey getMessageKey() {
		return this.messageKey;
	}

	
	/**
	 * Returns the protocol of this message
	 * (i.e. message format)
	 * 
	 * @return protocol
	 */

	@Override
	public String getProtocol() {
		return this.protocol;
	}

	
	/**
	 * Returns the ID of the message that this
	 * message refers to (or is in response to).
	 * 
	 * @return refToMessageId
	 */

	@Override
	public String getRefToMessageId() {
		return this.refToMessageId;
	}

	
	/**
	 * Returns the ID that identifies the sequence
	 * of an EOIO message exchange.
	 * 
	 * @return sequenceId
	 */

	@Override
	public String getSequenceId() {
		return this.sequenceId;
	}

	
	/**
	 * This method returns the message protocol specific
	 * serialization context value, for this message.
	 * 
	 * @return serializationContext
	 */

	@Override
	public String getSerializationContext() {
		return this.serializationContext;
	}

	
	/**
	 * Returns the time when the message was received.
	 * 
	 * @return timeReceived
	 */

	@Override
	public long getTimeReceived() {
		return this.timeReceived;
	}

	
	/**
	 * Returns the time when the message was sent.
	 * 
	 * @return timeSent
	 */

	@Override
	public long getTimeSent() {
		return this.timeSent;
	}

	
	/**
	 * Returns the Party object that represents the receiver.
	 * 
	 * @return Party
	 */

	@Override
	public Party getToParty() {
		return this.toParty;
	}

	
	/**
	 * Returns the Service object that represents the service
	 * that will ultimately process this message.
	 * 
	 * @return Service
	 */

	@Override
	public Service getToService() {
		return this.toService;
	}

	
	/**
	 * Returns if the current message is an acknowledgement
	 * message.
	 * 
	 * @return true / false
	 */

	@Override
	public boolean isAck() {
		return false;
	}

	
	/**
	 * Returns if the current message is an acknowledgement
	 * message of the specified type.
	 * 
	 * @param ackType
	 * @return true / false
	 */

	@Override
	public boolean isAck(AckType ackType) {
		return false;
	}

	
	/**
	 * Returns if for the current message an acknowledgement
	 * message is requested.
	 * 
	 * @return true / false
	 */

	@Override
	public boolean isAckRequested() {
		return false;
	}

	
	/**
	 * Returns if for the current message an acknowledgement
	 * message of the specified type is requested.
	 *
	 * @param ackType
	 * @return true / false
	 */

	@Override
	public boolean isAckRequested(AckType ackType) {
		return false;
	}

	
	/**
	 * Sets the correlation ID that identifies a sequence
	 * of message, which sematically belong together.
	 * 
	 * @param correlationId
	 */

	@Override
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	
	/**
	 * Sets the delivery semantics (QoS) of the outgoing
	 * message.
	 * 
	 * @param deliverySemantics
	 */

	@Override
	public void setDeliverySemantics(DeliverySemantics deliverySemantics) {
		this.deliverySemantics = deliverySemantics;
	}


	/**
	 * Sets the description of the message.
	 * 
	 * @param description
	 */

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * Sets the main document.
	 * 
	 * @param XMLPayload
	 */

	@Override
	public void setDocument(XMLPayload payload) {
		this.payload = payload;
	}

	
	/**
	 * Sets the ErrorInfo container for the current message,
	 * that was created with createErrorInfo method before.
	 * 
	 * @param ErrorInfo
	 */

	@Override
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	
	/**
	 * Set the main payload.
	 * 
	 * @param payload
	 */
	
	@Override
	public void setMainPayload(Payload payload) {
		this.payload = payload;
	}

	
	/**
	 * Sets the ID that indicates which message this message
	 * refers to.
	 * 
	 * @param refToMessageId
	 */
	
	@Override
	public void setRefToMessageId(String refToMessageId) {
		this.refToMessageId = refToMessageId;
	}

	
	/**
	 * Sets the ID that identifies the sequence of an EOIO
	 * message exchange.
	 * 
	 * @param sequenceId
	 */
	
	@Override
	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}
}
