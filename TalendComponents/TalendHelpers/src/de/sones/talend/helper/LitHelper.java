/*
 * sones GraphDB - OpenSource Graph Database - http://www.sones.com
 * Copyright (C) 2007-2011 sones GmbH
 *
 * This file is part of sones GraphDB OpenSource Edition.
 *
 * sones GraphDB OSE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * sones GraphDB OSE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with sones GraphDB OSE. If not, see <http://www.gnu.org/licenses/>.
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
