package com.havemester.po.mapping.test;

import java.util.Map;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.InputAttachments;
import com.sap.aii.mapping.api.InputHeader;
import com.sap.aii.mapping.api.InputParameters;
import com.sap.aii.mapping.api.InputPayload;
import com.sap.aii.mapping.api.OutputAttachments;
import com.sap.aii.mapping.api.OutputHeader;
import com.sap.aii.mapping.api.OutputParameters;
import com.sap.aii.mapping.api.OutputPayload;
import com.sap.aii.mappingtool.tf7.rt.Container;
import com.sap.aii.mappingtool.tf7.rt.GlobalContainer;


/**
 * Implementation class of Container
 * 
 * <p>An instance of this class enables you to cache the values that you want
 * to read again when you next call any user-defined function in the same
 * message mapping. A message mapping has exactly one global container
 * during the execution.
 *
 * <p>Furthermore, in the same as for Container , you can also access the fields
 * of the message header by using the GlobalContainer object.
 *
 * <p>Note that the sequence in which user-defined functions are called is
 * predefined. It depends on the position of the target fields that the
 * function was assigned to. Imagine a target structure in the mapping editor
 * in which all the structure nodes have been expanded. The fields are
 * processed from top to bottom, starting at the root node.
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class ContainerImpl implements Container {
	private GlobalContainer globalContainer = null;

	/**
	 * Class constructor - ContainerImpl
	 * 
	 * <p>Initialize container objects
	 */
	
	public ContainerImpl () {
		globalContainer = new GlobalContainerImpl();
	}

	
	/**
	 * Class constructor - ContainerImpl
	 * 
	 * <p>Initialize container objects
	 * 
	 * @param ih input header
	 * @param ip input parameters
	 * @param il input payload
	 * @param ia input attachments
	 * @param oh output header
	 * @param op output parameters
	 * @param ol output payload
	 * @param oa output attachments
	 */
	
	public ContainerImpl (InputHeader   ih, InputParameters   ip,
			              InputPayload  il, InputAttachments  ia,
			              OutputHeader  oh, OutputParameters  op,
			              OutputPayload ol, OutputAttachments oa) {
		globalContainer = new GlobalContainerImpl (ih, ip, il, ia, oh, op, ol, oa);
	}
	
	
	/**
	 * Class constructor - ContainerImpl
	 * 
	 * <p>Initialize container objects
	 * 
	 * @param ih input header
	 * @param ip input parameters
	 * @param oh output header
	 * @param op output parameters
	 */
	
	public ContainerImpl (InputHeader   ih, InputParameters   ip,
                          OutputHeader  oh, OutputParameters  op) {
		globalContainer = new GlobalContainerImpl (ih, ip, null, null, oh, op, null, null);
	}

	
	/**
	 * Returns the global container for storing objects which should be
	 * accessible in other user defined functions.
	 * 
	 * @return global container
	 */
	
	@Override
	public GlobalContainer getGlobalContainer() {
		return globalContainer;
	}
	
	
	/**
	 * Returns the mapping trace object that can be used to add trace messages.
	 * 
	 * @return trace object
	 */
	
	@Override
	public AbstractTrace getTrace() {
		return globalContainer.getTrace();
	}
	
	
	/**
	 * Returns the parameter that was saved under the given name in this
	 * user-specific function by using setParameter(String, Object) method.
	 * 
	 * @param key parameter name
	 * @return parameter value
	 */
	
	@Override
	public Object getParameter(String key) {
		return globalContainer.getParameter(key);
	}
	
	
	/**
	 * Saves an object under the given name in a container for a user-specific
	 * function.
	 * 
	 * @param key parameter name
	 * @param value parameter value
	 */
	
	@Override
	public void setParameter(String key, Object value) {
		globalContainer.setParameter(key, value);
	}

	
	/**
	 * Returns the access to the message header input parameters, like
	 * sender system , receiver system, etc.
	 * 
	 * @return message header input parameters
	 */
	
	@Override
	public InputHeader getInputHeader() {
		return globalContainer.getInputHeader();
	}
	
	
	/**
	 * Returns the access to the import parameters which have been defined
	 * in the signature tab of the message mapping editor.
	 * 
	 * @return message input parameters
	 */
	
	@Override
	public InputParameters getInputParameters() {
		return globalContainer.getInputParameters();
	}
	
	
	/**
	 * Returns the access to the message header output parameters.
	 * 
	 * @return message header output parameters
	 */
	
	@Override
	public OutputHeader getOutputHeader() {
		return globalContainer.getOutputHeader();
	}
	
	
	/**
	 * Returns the access to the export parameters which have been defined
	 * in the signature tab of the message mapping editor.
	 * 
	 * @return message output parameters
	 */
	
	@Override
	public OutputParameters getOutputParameters() {
		return globalContainer.getOutputParameters();
	}


	/**
	 * Deprecated. Use getInputParameters() instead.
	 * 
	 * @throws RuntimeException
	 */
	
	@Override
	public Map<String,Object> getTransformationParameters() {
		throw new RuntimeException ("Contianer.getTransformationParameters() is deprecated. Use getInputParameters() instead");
	}
}
