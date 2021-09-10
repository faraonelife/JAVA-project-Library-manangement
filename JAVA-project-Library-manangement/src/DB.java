import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	private static DB instance;
	private static Connection con;


	 private static String DATABASE_URL="jdbc:derby:./database/AlldataBase";

	private PreparedStatement getAllStmt;
	 DB() throws SQLException {
		 con=DriverManager.getConnection(DATABASE_URL);

	 }


	public static DB getInstance() throws SQLException {
		if(instance==null){
			instance=new DB();
		}
		return instance;
	}
	public static Connection getConnection() throws SQLException {
	 	try{ Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection(DATABASE_URL);
			return con;
		}catch(Exception e){System.out.println(e);}
		return null;

	}

}
