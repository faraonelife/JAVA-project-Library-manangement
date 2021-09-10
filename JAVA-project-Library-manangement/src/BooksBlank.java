import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BooksBlank extends JFrame {
	static BooksBlank statictobject;
	private JPanel Panel;
	private JTextField bknoF;
	private JTextField namF;
	private JTextField autF;
	private JTextField pubF;
	private JTextField quanF;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new BooksBlank();
					statictobject.setVisible(true);
					statictobject.setTitle("Books Blank ");
					statictobject.setIconImage(new ImageIcon("icons/book.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BooksBlank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 230, 450, 404);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);


		Panel.setBackground(Color.ORANGE);
		
		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setForeground(Color.blue);
		lblAddBooks.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		lblAddBooks.setForeground(Color.blue);
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setForeground(Color.blue);
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.blue);
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(Color.blue);
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setForeground(Color.blue);
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.blue);
		bknoF = new JTextField();
		namF = new JTextField();
		autF = new JTextField();
		pubF = new JTextField();
		quanF = new JTextField();
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.setForeground(Color.cyan);
		btnAddBooks.setBackground(Color.darkGray);
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String bookNO= bknoF.getText();
			String name= namF.getText();
			String author= autF.getText();
			String publisher= pubF.getText();
			String squantity= quanF.getText();
			int quantity=Integer.parseInt(squantity);
			int i= BookDB.save(bookNO, name, author, publisher, quantity);
			if(i>0){
				JOptionPane.showMessageDialog(BooksBlank.this,"You added books");
				LibrarianPanel.main(new String[]{});
				statictobject.dispose();
				
			}else{
				JOptionPane.showMessageDialog(BooksBlank.this,"Error,books were not added");
			}
			}
		});
		
		JButton btnBack = new JButton("Go...Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianPanel.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnBack.setForeground(Color.cyan);
		btnBack.setBackground(Color.darkGray);
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.TRAILING)
				.addGroup(gridLay.createSequentialGroup()
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addGroup(gridLay.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddBooks))
						.addGroup(gridLay.createSequentialGroup()
							.addGap(18)
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCallNo)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPublisher, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
								.addComponent(quanF, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(pubF, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(autF, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(namF, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(bknoF, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gridLay.createSequentialGroup()
					.addGap(161)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(Alignment.CENTER,gridLay.createSequentialGroup()
					//.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNo)
						.addComponent(bknoF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(namF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(autF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisher)
						.addComponent(pubF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(quanF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack)
					.addContainerGap(53, Short.MAX_VALUE)
						)
		);
		Panel.setLayout(gridLay);
	}

}
