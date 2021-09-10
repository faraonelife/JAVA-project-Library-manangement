import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class LibrarianLook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLook object = new LibrarianLook();
					object.setVisible(true);
					object.setTitle("Librarian Look ");
					object.setIconImage(new ImageIcon("icons/library.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibrarianLook() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(530, 230, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String location[][]=null;
		String column[]=null;
		try{
			Connection con= DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet dat=ps.executeQuery();
			
			ResultSetMetaData metaData=dat.getMetaData();
			int cols=metaData.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=metaData.getColumnName(i);
			}
			
			dat.last();
			int rows=dat.getRow();
			dat.beforeFirst();

			location=new String[rows][cols];
			int plus=0;
			while(dat.next()){
				for(int i=1;i<=cols;i++){
					location[plus][i-1]=dat.getString(i);
				}
				plus++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(location,column);
		JScrollPane scrol=new JScrollPane(table);
		
		contentPane.add(scrol, BorderLayout.CENTER);
	}

}
