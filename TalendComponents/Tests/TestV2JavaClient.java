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
                        	String attributeValue = "" + attribute.getValue();
                        
                        	row.put(attributeName, attributeValue);
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
