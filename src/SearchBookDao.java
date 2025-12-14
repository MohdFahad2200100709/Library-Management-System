import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SearchBookDao 
{
	public static Book getBook(int id,PreparedStatement psSearch)
	{
		Book book=null;
		try
		{
		psSearch.setInt(1, id);
		ResultSet rst=psSearch.executeQuery();
    	if(rst.next())
		{
			 book=new Book(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getBoolean(4));
		}
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	return book;
	}
}