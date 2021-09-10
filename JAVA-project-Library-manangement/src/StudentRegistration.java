import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentRegistration extends JFrame  {
    static StudentRegistration statictobject;
    private JPanel Panel;
    private JTextField usrfield;
    private JPasswordField passfld;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    statictobject = new StudentRegistration();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Student Registration");
                    statictobject.setIconImage(new ImageIcon("icons/student.png").getImage());
                } catch (Exception e) {e.printStackTrace();} } });
    }


    public StudentRegistration() throws SQLException {
        Connection con=DB.getConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230, 450, 300);
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(Panel);
        Panel.setBackground(Color.ORANGE);
        JLabel lblStudent = new JLabel("Student Registration");
        lblStudent.setForeground(Color.blue);
        lblStudent.setFont(new Font("TimesRoman", Font.BOLD, 22));

        JLabel lblusername = new JLabel("Insert Username->");
        lblusername.setForeground(Color.blue);
        JLabel lblPassword = new JLabel("Insert Password->");
        lblPassword.setForeground(Color.blue);
        usrfield = new JTextField();
        usrfield.setColumns(10);

        JButton btnGO = new JButton("GO");
        btnGO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username= usrfield.getText();
                String password=String.valueOf(passfld.getPassword());
                if(StudentDB.validate(username, password)){
                    StudentPanel.main(new String[]{});
                    statictobject.dispose();
                }else{
                    JOptionPane.showMessageDialog(StudentRegistration.this, "Error,something went wrong","Error", JOptionPane.ERROR_MESSAGE);
                    usrfield.setText("");
                    passfld.setText("");
                }
            }
        });
        btnGO.setForeground(Color.cyan);
        btnGO.setBackground(Color.darkGray);

        passfld = new JPasswordField();
        GroupLayout gridLay = new GroupLayout(Panel);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(124)
                                                .addComponent(lblStudent))
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(19)
                                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblusername)
                                                        .addComponent(lblPassword))
                                                .addGap(47)
                                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passfld)
                                                        .addComponent(usrfield, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                                .addContainerGap(107, Short.MAX_VALUE))
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap(187, Short.MAX_VALUE)
                                .addComponent(btnGO, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(151))
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addComponent(lblStudent)
                                .addGap(26)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblusername)
                                        .addComponent(usrfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(passfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnGO, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        Panel.setLayout(gridLay);
    }

}
