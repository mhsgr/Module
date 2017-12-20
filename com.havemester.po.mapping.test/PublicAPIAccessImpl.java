package com.havemester.po.mapping.test;

import com.sap.engine.interfaces.messaging.api.MessageFactory;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccess;
import com.sap.engine.interfaces.messaging.api.ack.AckFactory;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditAccess;
import com.sap.engine.interfaces.messaging.api.exception.InvalidParamException;
import com.sap.engine.interfaces.messaging.api.exception.MessagingException;
import com.sap.engine.interfaces.messaging.api.pmi.PMIAccess;


/**
 * Implementation class of PublicAPIAccess
 * 
 * <p>The PublicAPIAccess interface defines the public (SAP external) access
 * to the Messaging System.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class PublicAPIAccessImpl implements PublicAPIAccess {
	private static AuditAccess auditAccess = new AuditAccessImpl();

	/**
	 * Creates a AckFactory instance.
	 * 
	 * @return AckFactory
	 */
	
	@Override
	public AckFactory createAckFactory() {
		throw new RuntimeException("PublicAPIAccess.createAckFactory() not implemented.");
	}

	
	/**
	 * Creates a MessageFactory instance for the given protocol.
	 * 
	 * @param protocol
	 * @return MessageFactory
	 */
	
	@Override
	public MessageFactory createMessageFactory(String protocol)
			throws InvalidParamException, MessagingException {
		throw new RuntimeException("PublicAPIAccess.createMessageFactory() not implemented.");
	}

	
	/**
	 * Return access to AuditAccess.
	 * 
	 * @return AuditAccess
	 */
	
	@Override
	public AuditAccess getAuditAccess() {
		return auditAccess;
	}

	
	/**
	 * Return access to PMIAccess.
	 * 
	 * @return PMIAccess
	 */
	
	@Override
	public PMIAccess getPMIAccess() {
		throw new RuntimeException("PublicAPIAccess.getPMIAccess() not implemented.");
	}
}
