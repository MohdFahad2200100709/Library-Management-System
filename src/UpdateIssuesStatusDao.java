import java.sql.PreparedStatement;

public class UpdateIssuesStatusDao
{
	public static void update(int id,PreparedStatement psUpdate,boolean status)
	{
		try
		{
			psUpdate.setBoolean(1, status);
			psUpdate.setInt(2, id);
			psUpdate.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
