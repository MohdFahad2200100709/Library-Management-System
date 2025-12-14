import java.util.Scanner;
public class LibraryApp
{
	public static void main(String[] args)
	{
    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    
    while (true)
    {
    	System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM =====");
    	System.out.println("1. Add Book");
    	System.out.println("2. View All Book");
    	System.out.println("3. Search Book");
    	System.out.println("4. Issue Book");
    	System.out.println("5. Return Book");
    	System.out.println("6. exit");
    	System.out.println("Enter choice");
    	
    	int choice = Integer.parseInt(sc.nextLine());
    	
    	switch (choice)
    	{
    	case 1:
    		Book book=new Book();
    		System.out.println("Enter Book Id");
    		book.setId(Integer.parseInt(sc.nextLine()));
    		System.out.print("Enter Book Title");
    		book.setTitle(sc.nextLine());
    		System.out.print("Enter Book Author");
    		book.setAuthor(sc.nextLine());
    		library.addBook(book);
    		break;
    		
    	case 2:
    		library.viewBooks();
    		break;
    	
    	case 3:
    		System.out.println("Enter Book Id");
    		Book book1 = library.search(Integer.parseInt(sc.nextLine()));
    		if(book1 == null) 
    			System.out.println("Book not found");
    		else
    			System.out.println("Book");
    		break;
    		
    	case 4:
    		System.out.println("Enter Book Id to issue:");
    		library.issueBook(Integer.parseInt(sc.nextLine()));
    		break;
    		
    	case 5:
    		System.out.println("Enter Book Id to return:");
    		library.returnBook(Integer.parseInt(sc.nextLine()));
    		break;
    		
    	case 6:
    		System.out.println("Exiting....Goodbye");
    		sc.close();
    		System.exit(0);
    		
    		default:
    			System.out.println("Invalid choice");
    	}
      }
	}
}
    