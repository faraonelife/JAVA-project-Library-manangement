import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowBookDB {
	
public static boolean checkBook(String bookBorNo){
	boolean status=false;
	try{
		Connection con= DB.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM book where bookNO=?");
		ps.setString(1,bookBorNo);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}


public static int save(String bookBorNo,int studentid,String studentname,String borrowdata,String returndate){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(bookBorNo);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("INSERT INTO borrowedB(bookBorNo,studentid,studentname,borrowdata,returndata) VALUES(?,?,?,?,?)");
		ps.setString(1,bookBorNo);
		ps.setInt(2,studentid);
		ps.setString(3,studentname);
			ps.setString(4,borrowdata);
			ps.setString(5,returndate);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int updatebook(String bookBorNo){
	int status=0;
	int quantity=0,borrowed=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement(" SELECT quantity,borrowed FROM book WHERE bookNO=?");
		ps.setString(1,bookBorNo);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			borrowed=rs.getInt("borrowed");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("UPDATE book SET quantity=?,borrowed=? WHERE bookNO=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,borrowed+1);
		ps2.setString(3,bookBorNo);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
