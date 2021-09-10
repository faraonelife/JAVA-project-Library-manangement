import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianBlank extends JFrame {
	static LibrarianBlank statictobject;
	private JPanel Panel;
	private JTextField nameField;
	private JPasswordField pasdFld;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new LibrarianBlank();
					statictobject.setVisible(true);
					statictobject.setTitle("Librarian Blank ");
					statictobject.setIconImage(new ImageIcon("icons/library.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LibrarianBlank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 310, 450, 260);
		Panel = new JPanel();
		Panel.setBackground(Color.ORANGE);
		Panel.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(Panel);
		
		JLabel lblAddLibrarian = new JLabel("ADD Librarian");
		lblAddLibrarian.setForeground(Color.BLUE);
		lblAddLibrarian.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblPassword = new JLabel("Password:");

		nameField = new JTextField();

		pasdFld = new JPasswordField();
		
		JButton btnNewButton = new JButton("ADD Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name= nameField.getText();
			String password=String.valueOf(pasdFld.getPassword());


			int i= LibrarianDB.preserve(name, password);
			if(i>0){
				JOptionPane.showMessageDialog(LibrarianBlank.this,"Librarian created!");
				AdministratorPanel.main(new String[]{});
				statictobject.dispose();
				
			}else{
				JOptionPane.showMessageDialog(LibrarianBlank.this,"Impossible to create");
			}
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.CYAN);
		
		JButton btnBack = new JButton("GO...Back");
		btnBack.setBackground(Color.darkGray);
		btnBack.setForeground(Color.green.darker());
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdministratorPanel.main(new String[]{});
			statictobject.dispose();
			}
		});
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.TRAILING)
				.addGroup(gridLay.createSequentialGroup()
					.addGap(20)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(lblName)
						)
					.addGap(58)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING, false)

						.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(pasdFld))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gridLay.createSequentialGroup()

					.addComponent(lblAddLibrarian)
				.addGap(114)
				)
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(145))
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addComponent(lblAddLibrarian)
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addGroup(gridLay.createSequentialGroup()
							.addComponent(lblName)
							.addGap(18)
							.addComponent(lblPassword))
						.addGroup(gridLay.createSequentialGroup()
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pasdFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))

						.addGap(19)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)

						.addGap(19)
					.addComponent(btnBack)
					.addGap(19))
		);
		Panel.setLayout(gridLay);
	}

}
