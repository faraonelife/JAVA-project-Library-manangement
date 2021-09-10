import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BorrowBookBlank extends JFrame {
	static BorrowBookBlank statictobject;
	private JPanel Panel;
	private JTextField borField;
	private JTextField stdidField;
	private JTextField stdnameField;

	private JFormattedTextField formatText;
	private JFormattedTextField retformatText;





	private MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new BorrowBookBlank();
					statictobject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	public BorrowBookBlank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 230, 600, 500);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(12, 12, 8, 12));
		setContentPane(Panel);
		Panel.setBackground(Color.ORANGE);
		JLabel lblNewLabel = new JLabel("Borrow Book ");
		lblNewLabel.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.blue);
		JLabel lblBookName = new JLabel("Book N#:");
		borField = new JTextField();
		stdidField = new JTextField();
		stdnameField = new JTextField();

		lblBookName.setForeground(Color.blue);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setForeground(Color.blue);
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setForeground(Color.blue);

		JLabel lblDATA = new JLabel("DATA");
		lblDATA.setForeground(Color.blue);
		JLabel lblreturnDATA = new JLabel("Return DATA");
		lblreturnDATA.setForeground(Color.blue);

		JButton btnbrwBook = new JButton("Borrow Book");
		btnbrwBook.setForeground(Color.blue);

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);

		formatText = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));

		formatText.setText(dateString);


		SimpleDateFormat retformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, 7);

		String returndateString = retformatter.format(c.getTime());

		retformatText = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));
		retformatText.setColumns(20);
		retformatText.setText(returndateString);



		btnbrwBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookBorNo= borField.getText();
			int studentid=Integer.parseInt(stdidField.getText());
			String studentname= stdnameField.getText();
			String borrowdata=formatText.getText();
			String returndata=formatText.getText();
			if(BorrowBookDB.checkBook(bookBorNo)){


			int i= BorrowBookDB.save(bookBorNo, studentid, studentname,borrowdata,returndata);
			if(i>0){
				JOptionPane.showMessageDialog(BorrowBookBlank.this,"Book was borrowed");
				LibrarianPanel.main(new String[]{});
				statictobject.dispose();
				
			}else{
				JOptionPane.showMessageDialog(BorrowBookBlank.this,"Impossible to borrow book");
			}

			}else{
				JOptionPane.showMessageDialog(BorrowBookBlank.this,"Oh,There are no books in DB like this");
			}
			
			}
		});
		btnbrwBook.setForeground(Color.cyan);
		btnbrwBook.setBackground(Color.darkGray);
		JButton btnBack = new JButton("GO..BACK");
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
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addGroup(gridLay.createSequentialGroup()
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName)
								.addComponent(lblStudentId)
								.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDATA)
									.addComponent(lblreturnDATA))
							.addGap(10)
							.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
								.addComponent(stdidField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(borField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(stdnameField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)

									.addComponent(formatText, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addComponent(retformatText, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, gridLay.createSequentialGroup()
							.addGap(20)
							.addGroup(gridLay.createParallelGroup(Alignment.TRAILING)

								.addGroup(gridLay.createSequentialGroup()
									.addComponent(btnbrwBook, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(btnBack)))
							.addGap(100))))
				.addGroup(Alignment.CENTER,gridLay.createSequentialGroup()
					.addGap(61)
					.addComponent(lblNewLabel)

						)
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.CENTER)
				.addGroup(gridLay.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(gridLay.createParallelGroup(Alignment.CENTER)
						.addComponent(lblBookName)
						.addComponent(borField, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(stdidField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(stdnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
						.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDATA)
								.addComponent(formatText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblreturnDATA)
								.addComponent(retformatText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
					.addGroup(gridLay.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnbrwBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					)
		);
		Panel.setLayout(gridLay);
	}
}
