package com.havemester.po.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * Methods for stream conversion
 * 
 * <p> InputStream, OutputStream, String, byte[], ...
 * 
 * @author Michael Havemester
 * @version 1.0
 */

public class StreamConversion {
	private static final int BUFFER_SIZE = 8192;	

	/**
	 * Convert InputStream to ByteArrayOutputStream
	 *
	 * @param InputStream
	 * @return ByteArrayOutputStream
	 */
	
	public static ByteArrayOutputStream toByteArrayOutputStream (InputStream inputStream) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		int read = 0;
		while ((read = inputStream.read(buffer, 0, BUFFER_SIZE)) != -1) {
			os.write(buffer, 0, read);
		}
		os.flush();
		
		return os;
	}
	
	
	/**
	 * Convert byte[] to ByteArrayOutputStream
	 *
	 * @param byte[] array of bytes
	 * @return ByteArrayOutputStream
	 * @throws IOException
	 */
	
	public static ByteArrayOutputStream toByteArrayOutputStream (byte[] bytes) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		os.write(bytes);
		os.flush();
		
		return os;
	}
	
	
	/**
	 * Convert String with given encoding to ByteArrayOutputStream
	 *
	 * @param String
	 * @param encoding
	 * @return ByteArrayOutputStream
	 * @throws IOException
	 */
	
	public static ByteArrayOutputStream toByteArrayOutputStream (String string, String encoding) throws IOException {
		return toByteArrayOutputStream(string.getBytes(encoding));
	}
	
	
	/**
	 * Convert String with "UTF-8" encoding to ByteArrayOutputStream
	 *
	 * @param String
	 * @return ByteArrayOutputStream
	 * @throws IOException
	 */
	
	public static ByteArrayOutputStream toByteArrayOutputStream (String string) throws IOException {
		return toByteArrayOutputStream(string.getBytes("UTF-8"));
	}

	
	/**
	 * Convert String with given encoding to ByteArrayInputStream
	 *
	 * @param String
	 * @param encoding
	 * @return ByteArrayInputStream
	 * @throws UnsupportedEncodingException
	 */
	
	public static ByteArrayInputStream toInputStream (String string, String encoding) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(string.getBytes(encoding));
	}

	
	/**
	 * Convert String with "UTF-8" encoding to ByteArrayInputStream
	 *
	 * @param String
	 * @return ByteArrayInputStream
	 * @throws UnsupportedEncodingException
	 */
	
	public static ByteArrayInputStream toInputStream (String string) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(string.getBytes("UTF-8"));
	}

	
	/**
	 * Convert byte[] to ByteArrayInputStream
	 *
	 * @param String
	 * @return ByteArrayInputStream
	 */
	
	public static ByteArrayInputStream toInputStream (byte[] bytes) {
		return new ByteArrayInputStream(bytes);
	}

	
	/**
	 * Convert InputStream to String with given encoding 
	 *
	 * @param InputStream
	 * @param enconding
	 * @return String
	 * @throws IOException
	 */

	public static String toString (InputStream inputStream, String encoding) throws IOException {
		return new String(toByteArrayOutputStream(inputStream).toByteArray(), encoding);
	}

	
	/**
	 * Convert InputStream to String with "UTF-8" encoding 
	 *
	 * @param InputStream
	 * @return String
	 * @throws IOException
	 */

	public static String toString (InputStream inputStream) throws IOException {
		return new String(toByteArrayOutputStream(inputStream).toByteArray(), "UTF-8");
	}
	

	/**
	 * Convert byte[] to String with given encoding 
	 *
	 * @param byte[] array of bytes
	 * @param enconding
	 * @return String
	 * @throws UnsupportedEncodingException
	 */

	public static String toString (byte[] bytes, String encoding) throws UnsupportedEncodingException {
		return new String(bytes, encoding);
	}
	

	/**
	 * Convert byte[] to String with "UTF-8" encoding 
	 *
	 * @param byte[] array of bytes
	 * @return String
	 * @throws UnsupportedEncodingException
	 */

	public static String toString (byte[] bytes) throws UnsupportedEncodingException {
		return new String(bytes, "UTF-8");
	}

	
	/**
	 * Convert InputStream to byte[] 
	 *
	 * @param InputStream
	 * @return byte[] array of bytes
	 * @throws IOException
	 */

	public static byte[] toBytes (InputStream inputStream) throws IOException {	
		return toByteArrayOutputStream(inputStream).toByteArray();
	}
	

	/**
	 * Convert String with given encoding to byte[] 
	 *
	 * @param String
	 * @param enconding
	 * @return byte[] array of bytes
	 * @throws UnsupportedEncodingException
	 */
	
	public static byte[] toBytes (String string, String encoding) throws UnsupportedEncodingException {
		return string.getBytes(encoding);
	}
	
	
	/**
	 * Convert String with "UTF-8" encoding to byte[] 
	 *
	 * @param String
	 * @return byte[] array of bytes
	 * @throws UnsupportedEncodingException
	 */
	
	public static byte[] toBytes (String string) throws UnsupportedEncodingException {
		return string.getBytes("UTF-8");
	}
}
