package com.havemester.po.mapping.test;

import com.sap.aii.mapping.api.DynamicConfiguration;
import com.sap.aii.mapping.api.InputAttachments;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.InputPayload;
import com.sap.aii.mapping.api.StreamTransformationConstants;
import com.sap.aii.mapping.api.TransformationInput;


/**
 * Implementation class of TransformationInput
 * 
 * <p>Methods to access all input data of the mapping.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class TransformationInputImpl extends TransformationInput {
	private InputHeader      inputHeader      = null;
	private InputParameters  inputParameters  = null;
	private InputPayload     inputPayload     = null;
	private InputAttachments inputAttachments = null;

	
	/**
	 * Class constructor - TransformationInputImpl
	 * 
	 * <p>Initialize tranformation input objects
	 */

	public TransformationInputImpl() {
	}
	
	
	/**
	 * Class constructor - TransformationInputImpl
	 * 
	 * <p>Initialize tranformation input objects
	 * 
	 * @param ih input header
	 * @param ip input parameters
	 * @param il input payload
	 * @param ia input attachments
	 */
	
	public TransformationInputImpl(InputHeader ih, InputParameters ip, InputPayload il, InputAttachments ia) {
		inputHeader      = ih;
		inputParameters  = ip;
		inputPayload     = il;
		inputAttachments = ia;
	}

	
	/**
	 * Returns a handler for processing the dynamic configuration
	 * of the source message.
	 * 
	 * @return DynamicConfiguration
	 */
	
	@Override
	public DynamicConfiguration getDynamicConfiguration() {
		if (inputHeader != null) {
			return (DynamicConfiguration) inputHeader.get(StreamTransformationConstants.DYNAMIC_CONFIGURATION);
		}
		return null;
	}
	
	
	/**
	 * Returns a handler for processing the attachments
	 * of the source message.
	 * 
	 * @return InputAttachments
	 */
	
	@Override
	public InputAttachments getInputAttachments() {
		return inputAttachments;
	}


	/**
	 * Returns a handler for processing the input header
	 * of the source message.
	 * 
	 * @return InputHeader
	 */

	@Override
	public InputHeader getInputHeader() {
		return inputHeader;
	}

	
	/**
	 * Returns a handler for processing the input parameters
	 * of the source message.
	 * 
	 * @return InputParameters
	 */

	@Override
	public InputParameters getInputParameters() {
		return inputParameters;
	}
	
	
	/**
	 * Returns a handler for processing the input payload
	 * of the source message.
	 * 
	 * @return InputPayload
	 */
	
	@Override
	public InputPayload getInputPayload() {
		return inputPayload;
	}
}
