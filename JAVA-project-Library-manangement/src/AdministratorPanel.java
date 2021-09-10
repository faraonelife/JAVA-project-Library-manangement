import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorPanel extends JFrame{
    static AdministratorPanel statictobject;
    private JPanel MainPanelofAdmin;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new AdministratorPanel();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Administrator Panel");
                    statictobject.setIconImage(new ImageIcon("icons/ad.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AdministratorPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 85, 500, 760);
        MainPanelofAdmin = new JPanel();
        MainPanelofAdmin.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(MainPanelofAdmin);
        MainPanelofAdmin.setBackground(Color.ORANGE);
        JLabel lblAdminSection = new JLabel("Administrator Panel");
        lblAdminSection.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        lblAdminSection.setForeground(Color.BLUE);

        JButton btnAddbook = new JButton("ADD Books");
        btnAddbook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BooksBlank.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnAddbook.setFont(new Font("TimesRoman", Font.PLAIN, 13));

        JButton btnShowBook = new JButton("Show Books");
        btnShowBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                BooksLook.main(new String[]{});
            }
        }); btnShowBook.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        JButton btnDeletebook = new JButton("Delete book");
        btnDeletebook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookDelete.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnDeletebook.setFont(new Font("TimesRoman", Font.PLAIN, 15));



        JButton btnaddLib = new JButton("ADD Librarian");
        btnaddLib.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        btnaddLib.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianBlank.main(new String[]{});
                statictobject.dispose();
            }
        });

        JButton btnShowLibrarian = new JButton("Show Librarian");
        btnShowLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LibrarianLook.main(new String[]{});
            }
        });
        btnShowLibrarian.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        JButton btnDeleteLibrarian = new JButton("Delete Librarian");
        btnDeleteLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibDelete.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnDeleteLibrarian.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        JButton btnaddStd = new JButton("ADD Student");
        btnaddStd.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        btnaddStd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentBlank.main(new String[]{});
                statictobject.dispose();
            }
        });
        JButton btnShowStudent = new JButton("Show Student");
        btnShowStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentLook.main(new String[]{});
            }
        });
        btnShowStudent.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        JButton btnDeleteStudent = new JButton("Delete Student");
        btnDeleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteStudent.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnDeleteStudent.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    MainLibraryPane.main(new String[]{});
                } catch (Exception e) {
                    e.printStackTrace();
                }
                statictobject.dispose();
            }
        });
        btnAddbook.setBackground(Color.darkGray);
        btnaddLib.setBackground(Color.darkGray);
        btnaddStd.setBackground(Color.darkGray);
        btnDeletebook.setBackground(Color.darkGray);
        btnDeleteLibrarian.setBackground(Color.darkGray);
        btnDeleteStudent.setBackground(Color.darkGray);
        btnShowBook.setBackground(Color.darkGray);
        btnShowLibrarian.setBackground(Color.darkGray);
        btnShowStudent.setBackground(Color.darkGray);
        btnExit.setBackground(Color.darkGray);

        btnAddbook.setForeground(Color.CYAN);
        btnaddLib.setForeground(Color.CYAN);
        btnaddStd.setForeground(Color.CYAN);
        btnDeletebook.setForeground(Color.CYAN);
        btnDeleteLibrarian.setForeground(Color.CYAN);
        btnDeleteStudent.setForeground(Color.CYAN);
        btnShowBook.setForeground(Color.CYAN);
        btnShowLibrarian.setForeground(Color.CYAN);
        btnShowStudent.setForeground(Color.CYAN);
        btnExit.setForeground(Color.CYAN);
        btnExit.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        GroupLayout gridLay = new GroupLayout(MainPanelofAdmin);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap(120, Short.MAX_VALUE)
                                .addComponent(lblAdminSection, GroupLayout.DEFAULT_SIZE, 151, GroupLayout.DEFAULT_SIZE)
                                .addGap(155)
                                )
                        .addGroup(GroupLayout.Alignment.LEADING, gridLay.createSequentialGroup()
                                .addGap(134)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAddbook, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowBook, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeletebook, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnaddLib, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnaddStd, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowStudent, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(109, Short.MAX_VALUE))
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addComponent(btnAddbook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnShowBook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnDeletebook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnaddLib, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnShowLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnaddStd, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnShowStudent, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        MainPanelofAdmin.setLayout(gridLay);
    }
    }
