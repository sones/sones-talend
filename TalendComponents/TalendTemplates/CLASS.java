import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class CLASS
{
  protected static String nl;
  public static synchronized CLASS create(String lineSeparator)
  {
    nl = lineSeparator;
    CLASS result = new CLASS();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * sones GraphDB - OpenSource Graph Database - http://www.sones.com" + NL + " * Copyright (C) 2007-2011 sones GmbH" + NL + " *" + NL + " * This file is part of sones GraphDB OpenSource Edition." + NL + " *" + NL + " * sones GraphDB OSE is free software: you can redistribute it and/or modify" + NL + " * it under the terms of the GNU Affero General Public License as published by" + NL + " * the Free Software Foundation, version 3 of the License." + NL + " *" + NL + " * sones GraphDB OSE is distributed in the hope that it will be useful," + NL + " * but WITHOUT ANY WARRANTY; without even the implied warranty of" + NL + " * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the" + NL + " * GNU Affero General Public License for more details." + NL + " *" + NL + " * You should have received a copy of the GNU Affero General Public License" + NL + " * along with sones GraphDB OSE. If not, see <http://www.gnu.org/licenses/>." + NL + " */" + NL + " ";
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL + "\t\t\t\tsones_";
  protected final String TEXT_4 = ".resetInsertStmt();" + NL + "\t\t\t\tsones_";
  protected final String TEXT_5 = ".setInsertStmtVertexType();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tString ctype_";
  protected final String TEXT_7 = " = \"";
  protected final String TEXT_8 = "\";" + NL + "\t\t\t\t\tString clabel_";
  protected final String TEXT_9 = " = \"";
  protected final String TEXT_10 = "\";" + NL + "\t\t\t\t\tString value_";
  protected final String TEXT_11 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\t\tif(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " != null) {" + NL + "\t\t\t\t\t\tvalue_";
  protected final String TEXT_14 = " = \"\" + ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tsones_";
  protected final String TEXT_17 = ".addInsertStmtAttr(clabel_";
  protected final String TEXT_18 = ", value_";
  protected final String TEXT_19 = ", ctype_";
  protected final String TEXT_20 = ");\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t" + NL + "\t\t\t\tsones_";
  protected final String TEXT_22 = ".doInsert();\t\t" + NL + "\t\t\t\tsones_";
  protected final String TEXT_23 = ".printInsert();" + NL + "\t\t\t\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_24 = "++;" + NL + "" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_2);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		
		IMetadataTable metadata = metadatas.get(0);		
		List< ? extends IConnection> conns = node.getIncomingConnections();
		
			//The first connection
			IConnection conn = conns.get(0);
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			{
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    			
				for (IMetadataColumn column : metadata.getListColumns()) {
				
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getTalendType());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				}
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    	
			}
	}
		
    return stringBuffer.toString();
  }
}
