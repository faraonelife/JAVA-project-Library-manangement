import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibrarianDB {

	
	public static int preserve(String name, String password){
		int status=0;
		try{
			Connection con= DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO Librarian(name,password) VALUES(?,?)");
			ps.setString(1,name);
			ps.setString(2,password);

			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE  FROM Librarian WHERE id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean check(String name, String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Librarian WHERE name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
