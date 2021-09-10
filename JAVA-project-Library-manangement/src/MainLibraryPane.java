import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainLibraryPane  extends JFrame{
    static MainLibraryPane statictobject;
    private JPanel Panel;


    public static void main(String[] args)  {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new MainLibraryPane();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Library Panel");
                    statictobject.setIconImage(new ImageIcon("icons/library.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public MainLibraryPane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230, 450, 350);
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Panel);
Panel.setBackground(Color.ORANGE);
        JLabel lblLibraryManagement = new JLabel("Library Management");
        lblLibraryManagement.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        lblLibraryManagement.setForeground(Color.BLUE.darker());

        JButton btnAdministratorRegistration = new JButton("Administrator");
        btnAdministratorRegistration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdministratorRegistration.main(new String[]{});
                statictobject.dispose();
            }
        });
        btnAdministratorRegistration.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        // LIbrarian login
        JButton btnLibrarianLogin = new JButton("Librarian");
        btnLibrarianLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    LibrarianRegistration.main(new String[]{});
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnLibrarianLogin.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        //Student login
        JButton btnStudentLogin = new JButton("Student");
        btnStudentLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentRegistration.main(new String[]{});
            }
        });
        btnStudentLogin.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        btnAdministratorRegistration.setBackground(Color.darkGray);
        btnLibrarianLogin.setBackground(Color.darkGray);
        btnStudentLogin.setBackground(Color.darkGray);

        btnAdministratorRegistration.setForeground(Color.CYAN);
        btnLibrarianLogin.setForeground(Color.CYAN);
        btnStudentLogin.setForeground(Color.CYAN);

        GroupLayout gridLay = new GroupLayout(Panel);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(101)
                                                .addComponent(lblLibraryManagement))
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(140)
                                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(btnLibrarianLogin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAdministratorRegistration, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(btnStudentLogin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLibraryManagement)
                                .addGap(32)
                                .addComponent(btnAdministratorRegistration, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addGap(15)
                                .addComponent(btnStudentLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        Panel.setLayout(gridLay);
    }
}
