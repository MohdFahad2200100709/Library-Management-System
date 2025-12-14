import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewBooksDao
{
	public static List<Book> getBooks(Statement st)
	{
		List<Book> books=new ArrayList<Book>();
		try
		{
			ResultSet rst=st.executeQuery("select * from books");
    		books.clear();
        	while(rst.next())
    		{
    			// Adding books in collection
    			Book book=new Book(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getBoolean(4));
    			books.add(book);
    		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return books;
	}
}
