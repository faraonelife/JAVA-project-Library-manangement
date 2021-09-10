import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BorrowedBooksLook extends JFrame {

	private JPanel MainPanelofAdmin;
	private JTable Tablelook;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowedBooksLook brwdbook = new BorrowedBooksLook();
					brwdbook.setVisible(true);
					brwdbook.setTitle("Borrowed Books look  ");
					brwdbook.setIconImage(new ImageIcon("icons/book.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BorrowedBooksLook() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 230,880, 300);
		MainPanelofAdmin = new JPanel();
		MainPanelofAdmin.setBorder(new EmptyBorder(12, 12, 12, 12));
		MainPanelofAdmin.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanelofAdmin);
		
		String information[][]=null;
		String location[]=null;
		try{
			Connection con= DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM borrowedB",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultset=ps.executeQuery();
			
			ResultSetMetaData metadata=resultset.getMetaData();
			int loc=metadata.getColumnCount();
			location=new String[loc];
			for(int i=1;i<=loc;i++){
				location[i-1]=metadata.getColumnName(i);}
			resultset.last();
			int rows=resultset.getRow();
			resultset.beforeFirst();

			information=new String[rows][loc];
			int plus=0;
			while(resultset.next()){
				for(int i=1;i<=loc;i++){
					information[plus][i-1]=resultset.getString(i);
				}
				plus++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		Tablelook = new JTable(information,location);
		JScrollPane scrole=new JScrollPane(Tablelook);
		
		MainPanelofAdmin.add(scrole, BorderLayout.CENTER);
	}

}
