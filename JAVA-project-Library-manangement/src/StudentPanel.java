import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPanel extends JFrame{
    static StudentPanel statictobject;
    private JPanel Panel;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new StudentPanel();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Student Panel");
                    statictobject.setIconImage(new ImageIcon("icons/student.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public StudentPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 185, 450, 433);
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Panel);
        Panel.setBackground(Color.ORANGE);

        JLabel lblSTD = new JLabel("Student Panel ");
        lblSTD.setFont(new Font("TimesRoman", Font.PLAIN, 22));

lblSTD.setForeground(Color.blue);

        JButton btnlookBooks = new JButton("Show per/data & books");
        btnlookBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentDetailsAndBooksLook.main(new String[]{});
            }
        });
        btnlookBooks.setFont(new Font("TimesRoman", Font.PLAIN, 13));

btnlookBooks.setBackground(Color.darkGray);
btnlookBooks.setForeground(Color.cyan);


        JButton btnLookBRWDBooks = new JButton("Show borrowed books");
        btnLookBRWDBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorrowedBooksLook.main(new String[]{});
            }
        });
        btnLookBRWDBooks.setFont(new Font("TimesRoman", Font.PLAIN, 13));
btnLookBRWDBooks.setBackground(Color.darkGray);
btnLookBRWDBooks.setForeground(Color.cyan);
        JButton btnReturnBook = new JButton("Return Book");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnforSTD.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnReturnBook.setBackground(Color.darkGray);
        btnReturnBook.setForeground(Color.cyan);
        btnReturnBook.setFont(new Font("TimesRoman", Font.PLAIN, 13));

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainLibraryPane.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnExit.setBackground(Color.darkGray);
        btnExit.setForeground(Color.cyan);
        btnExit.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        GroupLayout gridLay = new GroupLayout(Panel);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gridLay.createSequentialGroup()
                                .addContainerGap(81, Short.MAX_VALUE)
                                .addComponent(lblSTD)
                                .addGap(130))
                        .addGroup(gridLay.createSequentialGroup()
                                .addGap(132)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLookBRWDBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnlookBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                       )
                                .addContainerGap(101, Short.MAX_VALUE))
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSTD)
                                .addGap(18)
                                .addGap(18)
                                .addComponent(btnlookBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnLookBRWDBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        Panel.setLayout(gridLay);
    }
}
