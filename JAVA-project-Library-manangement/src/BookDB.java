import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDB {
public static int save(String bookNO,String name,String author,String publisher,int quantity){
	int status=0;
	try{
		Connection con= DB.getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO book(bookNO, name, author, publisher, quantity) VALUES(?,?,?,?,?)");
		ps.setString(1,bookNO);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
	public static int delete(int id){
		int status=0;
		try{
			Connection con= DB.getConnection();
			PreparedStatement statement=con.prepareStatement("DELETE  FROM book WHERE id=?");
			statement.setInt(1,id);
			status=statement.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
