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
 * This class helps to handle literal symbols in the input which was passed by the input form of a Talend component
 * 
 * @author david.maier@sones.de
 *
 */
public class LitHelper {

	/**
	 * Gets the text which was encapsulated by single quotes. So if you passed "'text'" then the result is just "text". If the text does not not start and end with a
	 * single qoute then the result is the text itself.
	 * @param text
	 * @return
	 */
	public String trimSingleQuote(String text)
	{
		String result = text.trim();
					
		if (result.startsWith("'") && result.endsWith("'"))
		{	
				result = result.substring(1);
				result = result.substring(0, result.length()-1);
		}
		else
		{
			result = text;
		}
		
		return result;
	}
}
