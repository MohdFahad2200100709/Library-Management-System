import java.sql.*;
import java.util.*;

public class Library 
{
    private PreparedStatement psSave,psSearch,psUpdate;
    private Statement st;
    public Library()
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","Fahad@123");	
		    psSave=cn.prepareStatement("insert into books values(?,?,?,?)");
		    st = cn.createStatement();
		    psSearch=cn.prepareStatement("select * from books where bookId=?");
		    psUpdate=cn.prepareStatement("update books set issued=? where bookId=?");

    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
    
    // Add book
    public void addBook(Book book)
    {
    	    AddBookDao.save(book, psSave);
    		System.out.println("\nBook added successfully");
    }
    
    // View all books
    public void viewBooks()
    {
    		List<Book> books=ViewBooksDao.getBooks(st);
    		if(books.isEmpty())
        	System.out.println("\n No books available");
    		for(Book book:books)
    		System.out.println(book);
        	return;
    }
    
    // Search book
    public Book search(int id)
    {
        Book book=SearchBookDao.getBook(id, psSearch);
        return book;
    }
    
    // Issue book
    public void issueBook(int id)
    {
    	Book book = search(id);
    	if(book == null)
    		System.out.println("Book not found");
    	else if (book.isIssued())
    		System.out.println("Book already issued");
    	else
    	{
    		UpdateIssuesStatusDao.update(id, psUpdate, true);
    		System.out.println("Book issued successfully");
    	}
    }
    
    // return book
    public void returnBook(int id)
    {
    	Book book = search(id);
    	if(book == null)
    	System.out.println("Book not found");
    	else if (book.isIssued())
    		System.out.println("Book was not issued");
    	else
    	{
    			UpdateIssuesStatusDao.update(id, psUpdate, false);
    			System.out.println("Book returned successfully");
    		
    	}
    }
}