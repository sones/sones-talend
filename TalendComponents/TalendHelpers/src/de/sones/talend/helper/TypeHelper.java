/*
* sones GraphDB Talend Client Library 
* Copyright (C) 2007-2011 sones GmbH - http://www.sones.com
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/

package de.sones.talend.helper;

/**
 * It figures out that Talend handles the data like in 'tables'. Because we store it in vertices, we temporarily store it in a values table 'java.util.ArrayList<java.util.HashMap<String, String>> values'.
 * There may be a discussion point if string is the right 'generic' type to store the data, but because the data is sent as Text via REST (XML or JSON) it seems to be OK.
 *
 * This helper allows us to convert a string value back to the right data type. It also contains a map which stores the information which data type needs to be wrapped by string
 * literals.
 * 
 * The sones GraphDB supports Integer, Double, String, Boolean and DateTime .
 * 
 * @author david.maier@sones.de
 *
 */
public class TypeHelper {
	
	private java.util.HashMap<String, String> typeToLitMap = new java.util.HashMap<String, String>();
	
	/**
	 * Constructor - initializes the map to decide which type needs to be wrapped by string literals
	 */
	public TypeHelper()
	{
		//Map types to literal characters
		typeToLitMap.put("id_String", "'");
		typeToLitMap.put("id_Long","");
		typeToLitMap.put("id_Double","");
		typeToLitMap.put("id_Integer","");
		typeToLitMap.put("id_Date","'");
		typeToLitMap.put("id_Float","");
		typeToLitMap.put("id_Boolean","");
	}
	
	/**
	 * Getter for the String literal map
	 * @return
	 */
	public java.util.HashMap<String, String> getTypeToLitMap()
	{
		return this.typeToLitMap;
	}
	
	/**
	 * To convert a string value to Integer
	 * @param value
	 * @return
	 */
	public int strToInt(String value)
	{
		return Integer.valueOf(value).intValue();
	}

	/**
	 * To convert a String value to Long
	 * @param value
	 * @return
	 */
	public long strToLong(String value)
	{
		return Long.valueOf(value).longValue();
	}

	/**
	 * To convert a String value to Float
	 * @param value
	 * @return
	 */
	public float strToFloat(String value)
	{
		return Float.valueOf(value).floatValue();
	}

	/**
	 * To convert a String value to Double
	 * @param value
	 * @return
	 */
	public double strToDouble(String value)
	{
		return Double.valueOf(value).doubleValue();
	}

	/**
	 * To convert a String value to Boolean
	 * @param value
	 * @return
	 */
	public boolean strToBoolean(String value)
	{
		return Boolean.valueOf(value).booleanValue();
	}

	/**
	 * To convert a String value to Date - This is date format dependent
	 * @param value
	 * @return
	 */
	public java.util.Date strToDate(String value)
	{
		java.util.Date result = new java.util.Date();
	
		//The format is like: Fri Dec 24 00:00:00 CET 2010
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	
		try {
		
			result = format.parse(value);
		}
		catch (Exception e)
		{
			System.err.println("Could not parse date value.");
		}
	
		return result; 	
	}	
}
