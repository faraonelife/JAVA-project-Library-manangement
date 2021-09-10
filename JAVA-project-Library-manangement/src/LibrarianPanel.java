import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianPanel extends JFrame {
	static LibrarianPanel statictobject;
	private JPanel Panel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new LibrarianPanel();
					statictobject.setVisible(true);
					statictobject.setTitle("Librarian Panel");
					statictobject.setIconImage(new ImageIcon("icons/library.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LibrarianPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 85, 450, 650);
		Panel = new JPanel();

		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setBackground(Color.ORANGE);
		
		JLabel lblLibrarianSection = new JLabel("Librarian Panel");
		lblLibrarianSection.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		lblLibrarianSection.setForeground(Color.blue);
		JButton btnNewButton = new JButton("ADD Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BooksBlank.main(new String[]{});
			statictobject.dispose();
			}
		});
		btnNewButton.setBackground(Color.darkGray);
		btnNewButton.setForeground(Color.cyan);
		btnNewButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		
		JButton btnlookBooks = new JButton("Show Books info");
		btnlookBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BooksLook.main(new String[]{});
			}
		});
		btnlookBooks.setBackground(Color.darkGray);
		btnlookBooks.setForeground(Color.cyan);
		btnlookBooks.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		JButton btnDeletebook = new JButton("Delete Book");
		btnDeletebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookDelete.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnDeletebook.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		btnDeletebook.setBackground(Color.darkGray);
		btnDeletebook.setForeground(Color.cyan);
		JButton btnborrowBook = new JButton("Borrow Book");
		btnborrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBookBlank.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnborrowBook.setBackground(Color.darkGray);
		btnborrowBook.setForeground(Color.cyan);
		btnborrowBook.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		
		JButton btnlookborrowedBooks = new JButton("Show borrowed books");
		btnlookborrowedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowedBooksLook.main(new String[]{});
			}
		});
		btnlookborrowedBooks.setBackground(Color.darkGray);
		btnlookborrowedBooks.setForeground(Color.cyan);
		btnlookborrowedBooks.setFont(new Font("TimesRoman", Font.PLAIN, 15));


		JButton btnNeButton = new JButton("ADD Student");
		btnNeButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		btnNeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentBlank.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnNeButton.setBackground(Color.darkGray);
		btnNeButton.setForeground(Color.cyan);
		btnNeButton.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		JButton btnlookStudent = new JButton("Show Student info");
		btnlookStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentLook.main(new String[]{});
			}
		});
		btnlookStudent.setBackground(Color.darkGray);
		btnlookStudent.setForeground(Color.cyan);
		btnlookStudent.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnDeleteStudent.setBackground(Color.darkGray);
		btnDeleteStudent.setForeground(Color.cyan);

		btnDeleteStudent.setFont(new Font("TimesRoman", Font.PLAIN, 15));

		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnReturnBook.setBackground(Color.darkGray);
		btnReturnBook.setForeground(Color.cyan);
		btnReturnBook.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainLibraryPane.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnExit.setBackground(Color.darkGray);
		btnExit.setForeground(Color.cyan);
		btnExit.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gridLay.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(lblLibrarianSection)
					.addGap(120))
				.addGroup(gridLay.createSequentialGroup()
					.addGap(132)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnlookborrowedBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDeletebook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnborrowBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnlookBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNeButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnlookStudent, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLibrarianSection)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnlookBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
						.addComponent(btnDeletebook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
					.addComponent(btnborrowBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnlookborrowedBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNeButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnlookStudent, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		Panel.setLayout(gridLay);
	}

}
