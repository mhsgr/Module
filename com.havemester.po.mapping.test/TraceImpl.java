package com.havemester.po.mapping.test;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mappingtool.tf.rt.ResultListImpl;


/**
 * Implementation class of AbstractTrace
 * 
 * <p>A mapping can use an instance of AbstractTrace to add messages to the
 * trace. There are three trace levels info, warning and debug. You can
 * display the messages that you write to the trace with these methods in
 * the test environment of interface mappings, for example. Since you can
 * also set a trace level for each pipeline in the Integration Engine, it
 * depends on this setting if trace messages are written to the trace header
 * of the message at runtime. For details see online documentation.

 * @author Michael Havemester
 * @version 1.0
 */

public class TraceImpl extends AbstractTrace {
	
	/**
	 * Add a message with trace level debug to the trace.
	 * 
	 * @param message trace message
 	 */
	
	@Override
	public void addDebugMessage (String message) {
		addTrace ("DEBUG", message, null);
	}

	
	/**
	 * Add a message with trace level debug to the trace and the
	 * stacktrace of throwable.
	 * 
	 * @param message trace message
	 * @param throwable exception
 	 */
	
	@Override
	public void addDebugMessage (String message, Throwable throwable) {
		addTrace ("DEBUG", message, throwable);
	}
	
	
	/**
	 * Add a message with trace level info to the trace.
	 * 
	 * @param message trace message
	 */
	
	@Override
	public void addInfo (String message) {
		addTrace ("INFO", message, null);
	}
	
	
	/**
	 * Add a message with trace level info to the trace and the
	 * stacktrace of throwable.
	 * 
	 * @param message trace message
	 * @param throwable exception
	 */
	
	@Override
	public void addInfo (String message, Throwable throwable) {
		addTrace ("INFO", message, throwable);
	}

	
	/**
	 * Add only in test mode a message with trace level debug to the trace.
	 * 
	 * @param message trace message
	 */
	
	@Override
	public void addTestMessage (String message) {
		addTrace ("TEST", message, null);
	}
	
	
	/**
	 * Add only in test mode a message with trace level debug to the trace
	 * and the stacktrace of throwable.
	 * 
	 * @param message trace message
	 * @param throwable exception
	 */

	public void addTestMessage (String message, Throwable throwable) {
		addTrace ("TEST", message, throwable);
	}

	
	/**
	 * Add a message with trace level warning to the trace.
	 * 
	 * @param message trace message
	 */
	
	@Override
	public void addWarning (String message) {
		addTrace ("WARNING", message, null);
	}

	
	/**
	 * Add a message with trace level warning to the trace and
	 * the stacktrace of throwable.
	 * 
	 * @param message for info trace
	 * @param throwable exception
	 */
	
	@Override
	public void addWarning (String message, Throwable throwable) {
		addTrace ("WARNING", message, throwable);
	}
	
	
	/**
	 * Returns if the trace logs the message or not.
	 * (always true for test purposes)
	 * 
	 * @return true (always)
	 */
	
	@Override
	public boolean isLogging() {
		return true;
	}
	
	
	/**
	 * Add a message with trace level "level" to the trace and
	 * the stacktrace of throwable.
	 *  
	 * @param level trace level
	 * @param message trace message
	 * @param throwable exception
	 */
	
	private void addTrace (String level, String message, Throwable throwable) {
		System.out.println("Trace (" + level + "): " + message);
		
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
	
	
	/**
	 * Print ResultList to stdout
	 *  
	 * @param message trace message
	 * @param result ResultList
	 */
	
	public void result (String message, ResultListImpl result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Trace (INFO): " + message + "[" + (i + 1) + "]: " + result.get(i));
		}
		result.clear();
	}
	
	
	/**
	 * Print time in milli / micro seconds to stdout
	 * 
	 * @param message text
	 * @param time 
	 */
	
	public void timeMS(String message, long time) {
		long milli = time / 1000000;
		long micro = (time / 1000) - (milli * 1000);
		
		System.out.format(message + " %8d.%03d ms\n", milli, micro);
	}
}
