/**
 * 
 */
package com.backbase.junit;

/**
 * @author M1040042
 *
 */
public class LoggingUtilities {
	private LoggingUtilities(){

	}

	public static void Print(String message){
		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
	    System.out.println("*********** " + element.getClassName() + " " + element.getMethodName() + "() " + message + " *************");
	}

}
