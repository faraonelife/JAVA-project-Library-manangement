import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class StudentDetailsAndBooksLook extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentDetailsAndBooksLook object = new StudentDetailsAndBooksLook();
                    object.setVisible(true);
                    object.setTitle("Student Details and borrowed Books look");
                    object.setIconImage(new ImageIcon("icons/student.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public StudentDetailsAndBooksLook() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(130, 230,1300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        String location[][]=null;
        String column[]=null;
        try{
            Connection con= DB.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT t.studenid,t.name,t.email,t.address,t.city,t.contact,d.id,d.bookBorNo,d.borrowdata,d.returndata  FROM Student t,borrowedB d WHERE t.studenid=d.studentid ",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet set=ps.executeQuery();

            ResultSetMetaData metadata=set.getMetaData();
            int cols=metadata.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=metadata.getColumnName(i);
            }

            set.last();
            int rows=set.getRow();
            set.beforeFirst();

            location=new String[rows][cols];
            int plus=0;
            while(set.next()){
                for(int i=1;i<=cols;i++){
                    location[plus][i-1]=set.getString(i);
                }
                plus++;
            }
            con.close();
        }catch(Exception e){System.out.println(e);}

        table = new JTable(location,column);
        JScrollPane scroll=new JScrollPane(table);

        contentPane.add(scroll, BorderLayout.CENTER);
    }
}
