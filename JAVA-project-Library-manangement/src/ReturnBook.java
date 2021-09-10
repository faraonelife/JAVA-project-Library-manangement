import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame {
	static ReturnBook staticobject;
	private JPanel Panel;
	private JTextField bookNOField;
	private JTextField stdidField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staticobject = new ReturnBook();
					staticobject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); }
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 230, 516, 413);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(Panel);
		Panel.setBackground(Color.ORANGE);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setForeground(Color.blue);
		lblReturnBook.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		JLabel lblbookNO = new JLabel("Book NO#->");
		lblbookNO.setForeground(Color.blue);
		JLabel lblStdId = new JLabel("Student ID->");
		lblStdId.setForeground(Color.blue);
		bookNOField = new JTextField();
		stdidField = new JTextField();
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookNO= bookNOField.getText();
				int studentid=Integer.parseInt(stdidField.getText());
				int i= ReturnBookDB.delete(bookNO, studentid);
				if(i>0){
					JOptionPane.showMessageDialog(ReturnBook.this,"Book returned");
					LibrarianPanel.main(new String[]{});
					staticobject.dispose();
				}else{
					JOptionPane.showMessageDialog(ReturnBook.this,"Impossible to return");
				}
			}
		});
		btnReturnBook.setBackground(Color.darkGray);
		btnReturnBook.setForeground(Color.cyan);
		JButton btnBack = new JButton("GO...Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianPanel.main(new String[]{});
				staticobject.dispose();
			}
		});
		btnBack.setBackground(Color.darkGray);
		btnBack.setForeground(Color.cyan);
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.TRAILING)
				.addGroup(gridLay.createSequentialGroup()
					.addGap(36)
					.addGroup(gridLay.createParallelGroup(Alignment.TRAILING, true)
						.addComponent(lblStdId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblbookNO, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addComponent(stdidField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNOField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.CENTER,gridLay.createSequentialGroup()

						.addGap(30)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)

						)
				.addGroup(gridLay.createSequentialGroup()

					.addComponent(lblReturnBook)
					.addGap(160))
				.addGroup(gridLay.createSequentialGroup()
					.addGap(19)

					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(Alignment.CENTER,gridLay.createSequentialGroup()

						.addGap(66)
					.addComponent(btnBack)
					.addGap(46))
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReturnBook)
					.addGap(32)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblbookNO)
						.addComponent(bookNOField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStdId)
						.addComponent(stdidField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGap(72))
		);
		Panel.setLayout(gridLay);
	}

}
