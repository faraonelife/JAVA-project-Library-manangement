import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class StudentLook extends JFrame {

    private JPanel Panel;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentLook object = new StudentLook();
                    object.setVisible(true);
                    object.setTitle("Student look");
                    object.setIconImage(new ImageIcon("icons/student.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public StudentLook() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(330, 230, 900, 300);
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        Panel.setLayout(new BorderLayout(0, 0));
        setContentPane(Panel);
        String data[][]=null;
        String column[]=null;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Student", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();

            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }

            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();
        }catch(Exception e){System.out.println(e);}

        table = new JTable(data,column);
        JScrollPane sp=new JScrollPane(table);

        Panel.add(sp, BorderLayout.CENTER);
    }

}
