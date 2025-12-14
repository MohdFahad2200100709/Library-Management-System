import java.sql.PreparedStatement;
public class AddBookDao
{
	public static void save(Book book,PreparedStatement psSave)
	{
		try
		{
		     psSave.setInt(1, book.getId());
		     psSave.setString(2, book.getTitle());
		     psSave.setString(3, book.getAuthor());
		     psSave.setBoolean(4, book.isIssued());
		     psSave.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
