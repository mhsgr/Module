package com.havemester.po.mapping.test;

import java.util.HashMap;
import java.util.Map;

import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.InputHeader;


/**
 * Implementation class of InputHeader
 * 
 * <p>Methods to access fields of the message header.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class InputHeaderImpl extends InputHeader {
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * Class constructor - InputHeaderImpl
	 */

	public InputHeaderImpl() {
		DynamicConfiguration dc = new DynamicConfigurationImpl();
		map.put("DynamicConfiguration", dc);
	}

	
	/**
	 * Get message properties with the given name
	 * 
	 * @param name
	 *            property name
	 * @return property value
	 */

	@Override
	public Object get(String name) {
		return map.get(name);
	}

	
	
	/**
	 * Get map of all message properties.
	 * 
	 * @return map of all message properties
	 */

	public Map<String, Object> getMap() {
		return map;
	}

	
	
	/**
	 * Get a cloned map of all message properties.
	 * 
	 * @return map of all message properties
	 */

	@Override
	public Map<String, Object> getAll() {
		Map<String, Object> cloneMap = new HashMap<String, Object>(map);

		return cloneMap;
	}

	
	/**
	 * Return the conversation id.
	 * 
	 * @return conversation id
	 */

	@Override
	public String getConversationId() {
		return (String) map.get("ConversationId");
	}

	
	/**
	 * Return the name of the sender interface.
	 * 
	 * @return sender interface name
	 */

	@Override
	public String getInterface() {
		return (String) map.get("Interface");
	}

	
	/**
	 * Return the namespace of the sender interface.
	 * 
	 * @return sender interface namespace
	 */

	@Override
	public String getInterfaceNamespace() {
		return (String) map.get("InterfaceNamespace");
	}

	
	/**
	 * Return the direction of the message.
	 * 
	 * @return direction of the message
	 */

	@Override
	public String getMessageClass() {
		return (String) map.get("MessageClass");
	}

	
	/**
	 * Return the message id.
	 * 
	 * @return message id
	 */

	@Override
	public String getMessageId() {
		return (String) map.get("MessageId");
	}

	
	/**
	 * Return the processing mode of the message: synchronous or asynchronous.
	 * 
	 * @return processing mode
	 */

	@Override
	public String getProcessingMode() {
		return (String) map.get("ProcessingMode");
	}

	
	/**
	 * Return the name of the receiver interface.
	 * 
	 * @return receiver interface name
	 */

	@Override
	public String getReceiverInterface() {
		return (String) map.get("ReceiverInterface");
	}

	
	/**
	 * Return the namespace of the receiver interface.
	 * 
	 * @return receiver interface namespace
	 */

	@Override
	public String getReceiverInterfaceNamespace() {
		return (String) map.get("ReceiverInterfaceNamespace");
	}

	
	/**
	 * Return the name of the receiver party.
	 * 
	 * @return receiver party
	 */

	@Override
	public String getReceiverParty() {
		return (String) map.get("ReceiverParty");
	}

	
	/**
	 * Return the agency of the receiver party.
	 * 
	 * @return receiver party agency
	 */

	@Override
	public String getReceiverPartyAgency() {
		return (String) map.get("ReceiverPartyAgency");
	}

	
	/**
	 * Return the scheme of the receiver party.
	 * 
	 * @return receiver party scheme
	 */

	@Override
	public String getReceiverPartyScheme() {
		return (String) map.get("ReceiverPartyScheme");
	}

	
	/**
	 * Return the receiver service.
	 * 
	 * @return receiver service
	 */

	@Override
	public String getReceiverService() {
		return (String) map.get("ReceiverService");
	}

	
	/**
	 * Return the ID of the referred message
	 * 
	 * @return referred message id
	 */

	@Override
	public String getRefToMessageId() {
		return (String) map.get("RefToMessageId");
	}

	
	/**
	 * Return the name of the sender interface
	 * 
	 * @return sender interface name
	 */

	@Override
	public String getSenderInterface() {
		return (String) map.get("SenderInterface");
	}

	
	/**
	 * Return the namespace of the sender interface
	 *
	 * @return sender interface namespace
	 */

	@Override
	public String getSenderInterfaceNamespace() {
		return (String) map.get("SenderInterfaceNamespace");
	}

	
	/**
	 * Return the sender party.
	 * 
	 * @return sender party
	 */

	@Override
	public String getSenderParty() {
		return (String) map.get("SenderParty");
	}

	
	/**
	 * Return the scheme of the sender party.
	 *
	 * @return sender party scheme
	 */

	@Override
	public String getSenderPartyScheme() {
		return (String) map.get("SenderPartyScheme");
	}

	
	/**
	 * Return the agency of the sender party.
	 * 
	 * @return sender party agency
	 */

	@Override
	public String getSenderParytAgency() {
		return (String) map.get("SenderPartyAgency");
	}

	
	/**
	 * Return the sender service.
	 * 
	 * @return sender service
	 */

	@Override
	public String getSenderService() {
		return (String) map.get("SenderService");
	}

	
	/**
	 * Return the time the message has been sent.
	 * 
	 * @return time sent 
	 */

	@Override
	public String getTimeSent() {
		return (String) map.get("TimeSent");
	}

	
	/**
	 * Return the major version number.
	 * 
	 * @return major version number 
	 */

	@Override
	public String getVersionMajor() {
		return (String) map.get("VersionMajor");
	}

	
	/**
	 * Return the minor version number.
	 * 
	 * @return minor version number
	 */

	@Override
	public String getVersionMinor() {
		return (String) map.get("VersionMinor");
	}
}
