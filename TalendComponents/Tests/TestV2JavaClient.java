import java.util.Random;

public class TestV2JavaClient {

	
	//A temp. table
	private static java.util.ArrayList<java.util.HashMap<String, String>> values = new java.util.ArrayList<java.util.HashMap<String, String>>();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		//Test parameters
		String host = "localhost";
		String user = "test";
		String password = "test";
		int port = 9975;
		String vertexType = "UserProfile";
		
				
		for (int i = 0; i<10; i++)
		{
			insertTest(host, user, password, port, vertexType);
		}

		selectionTest(host, user, password, port, vertexType);
	}

	
	public static void insertTest(String host, String user, String password, int port, String vertexType)
	{
		Random generator = new Random();
		
		String insertStr = "INSERT INTO " + vertexType + " VALUES ( name = 'hello" + generator.nextInt() + "', age = " + generator.nextInt() + " )";

        try {           

        		de.sones.GraphDBClient.GraphDBClient restClient = new de.sones.GraphDBClient.GraphDBClient(host, user, password, port);


        		de.sones.GraphDBClient.QueryResult.QueryResult result  = restClient.Query(insertStr);

                if (result.getResultType() != de.sones.GraphDBClient.QueryResult.ResultType.Successful)
                {
                	System.out.println(result.getErrorMessage());
                }
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
	}
	
	
	public static void selectionTest(String host, String user, String password, int port, String vertexType) throws Exception
	{		
		de.sones.GraphDBClient.GraphDBClient restClient = new de.sones.GraphDBClient.GraphDBClient(host, user, password, port);
		
        String queryStr = "FROM " + vertexType + " SELECT *";

        de.sones.GraphDBClient.QueryResult.QueryResult result  = restClient.Query(queryStr);

        if (result.getResultType() == de.sones.GraphDBClient.QueryResult.ResultType.Successful)
        {
                for (de.sones.GraphDBClient.Objects.Vertex vertex : result.getVertexViewList())
                {
                        java.util.HashMap<String, String> row = new java.util.HashMap<String, String>();

                        
                        for (de.sones.GraphDBClient.Objects.Property attribute : vertex.getProperties())
                        {
                        	String attributeName = attribute.getId();

                        	boolean isSimpleAttribute = ( !attributeName.equals("VertexID") &&
                        								   !attributeName.equals("VertexTypeID") &&
                        								   !attributeName.equals("VertexTypeName") &&
                        								   !attributeName.equals("Revision") &&
                        								   !attributeName.equals("Edition") &&
                        								   !attributeName.equals("CreationDate") &&
                        								   !attributeName.equals("ModificationDate") &&
                        								   !attributeName.equals("Comment")
                        								 );
                        	
                        	if (isSimpleAttribute)
                        	{
                        	
                        		String attributeValue = "" + attribute.getValue();
                        
                        		System.out.println(attributeName + " = " + attributeValue);
                        	
                        		row.put(attributeName, attributeValue);
                        	}
                        }
                        
                        values.add(row);
                }
        }
        else
        {
                System.out.println(result.getErrorMessage());
        }
		
	}
	
}

