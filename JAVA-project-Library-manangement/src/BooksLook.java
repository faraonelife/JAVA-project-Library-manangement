import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BooksLook extends JFrame {

	private JPanel Panel;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksLook object = new BooksLook();
					object.setVisible(true);
					object.setTitle("Books Tabel ");
					object.setIconImage(new ImageIcon("icons/book.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BooksLook() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(530, 230, 600, 300);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		Panel.setLayout(new BorderLayout(0, 0));
		setContentPane(Panel);
		Panel.setBackground(Color.ORANGE);
		
		String location[][]=null;
		String column[]=null;
		try{
			Connection con= DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM book ",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
			int count=0;
			while(set.next()){
				for(int i=1;i<=cols;i++){
					location[count][i-1]=set.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(location,column);
		JScrollPane scroll=new JScrollPane(table);
		
		Panel.add(scroll, BorderLayout.CENTER);
	}

}
