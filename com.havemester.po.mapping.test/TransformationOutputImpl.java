package com.havemester.po.mapping.test;

import com.sap.aii.mapping.api.OutputAttachments;
import com.sap.aii.mapping.api.OutputHeader;
import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.OutputPayload;
import com.sap.aii.mapping.api.TransformationOutput;


/**
 * Implementation class of TransformationOutput
 * 
 * <p>Methods to access all output data of the mapping.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class TransformationOutputImpl extends TransformationOutput {
	private OutputHeader      outputHeader      = null;
	private OutputParameters  outputParameters  = null;
	private OutputPayload     outputPayload     = null;
	private OutputAttachments outputAttachments = null;

	
	/**
	 * Class constructor - TransformationOutputImpl
	 * 
	 * <p>Initialize tranformation output objects
	 */
	
	public TransformationOutputImpl() { }
	
	
	/**
	 * Class constructor - TransformationOutputImpl
	 * 
	 * <p>Initialize tranformation output objects
	 * 
	 * @param oh output header
	 * @param op output parameters
	 * @param ol output payload
	 * @param oa output attachments
	 */
	
	public TransformationOutputImpl(OutputHeader ih, OutputParameters ip, OutputPayload il, OutputAttachments ia) {
		outputHeader      = ih;
		outputParameters  = ip;
		outputPayload     = il;
		outputAttachments = ia;
	}

	
	/**
	 * Returns a handler for processing the attachments
	 * of the target message.
	 * 
	 * @return OutputAttachments
	 */

	@Override
	public OutputAttachments getOutputAttachments() {
		return outputAttachments;
	}

	
	/**
	 * Returns a handler for processing the output header
	 * of the target message.
	 * 
	 * @return OutputHeader
	 */
	
	@Override
	public OutputHeader getOutputHeader() {
		return outputHeader;
	}

	
	/**
	 * Returns a handler for processing the output parameters
	 * of the target message.
	 * 
	 * @return OutputParameters
	 */
	
	@Override
	public OutputParameters getOutputParameters() {
		return outputParameters;
	}

	
	/**
	 * Returns a handler for processing the output payload
	 * of the target message.
	 * 
	 * @return OutputPayload
	 */
	
	@Override
	public OutputPayload getOutputPayload() {
		return outputPayload;
	}

	
	/**
	 * Copy all original attachments of the source message
	 * to the attachment list of the target message.
	 */
	
	@Override
	public void copyInputAttachments() {
		throw new RuntimeException("TransformationOutput.copyInputAttachments not implemented");
	}
}
