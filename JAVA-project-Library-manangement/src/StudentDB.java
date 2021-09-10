import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDB {
    public static int save(String name,String password,String email,String address,String city,String contact){
        int status=0;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO Student(name,password,email,address,city,contact) VALUES(?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,address);
            ps.setString(5,city);
            ps.setString(6,contact);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static boolean validate(String name,String password){
        boolean status=false;
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Student WHERE name=? and password=?");
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE  FROM Student WHERE studenid=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

}
