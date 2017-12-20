package com.havemester.po.mapping.test;

import java.util.HashMap;
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
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;
import com.sap.aii.mappingtool.tf7.rt.GlobalContainer;


/**
 * Implementation class of GlobalContainer
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
 * <p>To get a global container object, call the method Container.getGlobalContainer().
 *
 * @author Michael Havemester
 * @version 1.0
 */ 
 
public class GlobalContainerImpl implements GlobalContainer {
	private HashMap<String,Object> parameters = new HashMap<String,Object>();
	private TraceImpl              trace      = new TraceImpl();
	private TransformationInput    ti         = null;
	private TransformationOutput   to         = null;
	
	/**
	 * Class constructor - ContainerImpl
	 * 
	 * <p>Initialize container objects
	 */
	
	public GlobalContainerImpl() {
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
	
	public GlobalContainerImpl(InputHeader   ih, InputParameters   ip,
							   InputPayload  il, InputAttachments  ia,
							   OutputHeader  oh, OutputParameters  op,
							   OutputPayload ol, OutputAttachments oa) {
		ti = new TransformationInputImpl  (ih, ip, il, ia);
		to = new TransformationOutputImpl (oh, op, ol, oa);
	}
	
	
	/**
	 * Returns the mapping trace object that can be used to add trace messages.
	 * 
	 * @return trace object 
	 */
	
	@Override
	public AbstractTrace getTrace() {
		return trace;
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
		return parameters.get(key);
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
		parameters.put(key, value);
	}

	
	/**
	 * Returns the access to the message header input parameters, like
	 * sender system , receiver system, etc.
	 * 
	 * @return message header input parameters
	 */
	
	@Override
	public InputHeader getInputHeader() {
		return ti.getInputHeader();
	}
	
	
	/**
	 * Returns the access to the message header output parameters.
	 * 
	 * @return message header output parameters
	 */
	
	@Override
	public OutputHeader getOutputHeader() {
		return to.getOutputHeader();
	}
	
	
	/**
	 * Returns the access to the import parameters which have been defined
	 * in the signature tab of the message mapping editor.
	 * 
	 * @return message input parameters
	 */
	
	@Override
	public InputParameters getInputParameters() {
		return ti.getInputParameters();
	}
	
	
	/**
	 * Returns the access to the export parameters which have been defined
	 * in the signature tab of the message mapping editor.
	 * 
	 * @return message output parameters
	 */
	
	@Override
	public OutputParameters getOutputParameters() {
		return to.getOutputParameters();
	}
	
	
	/**
	 * Copy alls input attachments to output attachments
	 */
	
	@Override
	public void copyInputAttachments() {
		to.copyInputAttachments();
	}
	

	/**
	 * Returns input attachments
	 * 
	 * @return input attachments
	 */
	
	@Override
	public InputAttachments getInputAttachments() {
		return ti.getInputAttachments();
	}
	
	
	/**
	 * Returns output attachments
	 * 
	 * @return output attachments
	 */
	
	@Override
	public OutputAttachments getOutputAttachments() {
		return to.getOutputAttachments();
	}
	
	
	/**
	 * Deprecated. Use getInputParameters() instead.
	 * 
	 * @throws RuntimeException
	 */
	
	@Override
	public Map<String,Object> getParameters() {
		throw new RuntimeException ("GlobalContianer.getParameters() is deprecated. Use getInputParameters() instead");
	}
}
