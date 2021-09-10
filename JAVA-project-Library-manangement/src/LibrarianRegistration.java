import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LibrarianRegistration extends JFrame {
	static LibrarianRegistration statictobject;
	private JPanel Panel;
	private JTextField usrnameFld;
	private JPasswordField passFld;


	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new LibrarianRegistration();
					statictobject.setVisible(true);
					statictobject.setTitle("Librarian Registration");
					statictobject.setIconImage(new ImageIcon("icons/librarian.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LibrarianRegistration() throws SQLException {
		DB.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 230, 450, 300);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(Panel);
		Panel.setBackground(Color.ORANGE);
		
		JLabel lblLibrarian = new JLabel("Librarian Registration");
		lblLibrarian.setForeground(Color.blue);
		lblLibrarian.setFont(new Font("TimesRoman", Font.PLAIN, 18));

		JLabel lblEnterName = new JLabel("Insert Username->");
		lblEnterName.setForeground(Color.blue);
		JLabel lblEnterPassword = new JLabel("Insert Password->");
		lblEnterPassword.setForeground(Color.blue);
		usrnameFld = new JTextField();
		usrnameFld.setColumns(10);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String username= usrnameFld.getText();
			String password=String.valueOf(passFld.getPassword());

			if(LibrarianDB.check(username, password)){
				LibrarianPanel.main(new String[]{});
				statictobject.dispose();
			}else{
				JOptionPane.showMessageDialog(LibrarianRegistration.this, "Error,something went wrong ","Error!", JOptionPane.ERROR_MESSAGE);
				usrnameFld.setText("");
				passFld.setText("");
			}
			}
		});
		btnGo.setBackground(Color.darkGray);
		btnGo.setForeground(Color.cyan);
		
		passFld = new JPasswordField();
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.TRAILING)
				.addGroup(gridLay.createSequentialGroup()
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addGroup(gridLay.createSequentialGroup()
							.addGap(124)
							.addComponent(lblLibrarian))
						.addGroup(gridLay.createSequentialGroup()
							.addGap(19)
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING, true)
								.addComponent(passFld)
								.addComponent(usrnameFld, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addComponent(lblLibrarian)
					.addGap(26)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(usrnameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		Panel.setLayout(gridLay);
	}
}
