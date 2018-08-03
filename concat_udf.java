//Importing Hive Exec Jar
import org.apache.hadoop.hive.ql.exec.UDF;
//Importing ArrayList from Java Utility
import java.util.ArrayList;

//Declaring a public class concat_udf that inherits property of UDF main class
public class concat_udf extends UDF
{
	//Declaration & definition of function evaluate.
	//Takes two parameters, a separator & another array of String which would be separated by the separator provided
	public String evaluate (String SEP, ArrayList<String> array) 
	{
		//Checking if separator or array is empty or not provided.
		//The program would abort by returning, how to run this program.
		if (SEP == null || array == null) 
		{
			return "Provide a separator followed by an array of column name";
		}
		
		//Declaring an empty string to store the value of final result
		String element="";
		
		//Iterating through input array by checking till the last element
		for(int i=0; i<array.size();i++)
		{
			// Fetching array element by array.get(i) at the i'th index & storing it to process further.
			element=element+array.get(i);
			
			//Checking if array contains at least two elements for a separator to be used.
			if(i<array.size()-1)
			{	
				//If array size is greater than 1 then concatenating the separator to element.
				element=element+SEP;
			}
		}
		//returning the concatenated Array elements as a String.
		return element;
	}
}