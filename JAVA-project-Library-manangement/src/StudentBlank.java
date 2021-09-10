import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentBlank extends JFrame {
    static StudentBlank statictobject;
    private JPanel Panel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JPasswordField passwordField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new StudentBlank();
                    statictobject.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public StudentBlank() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230, 450, 450);
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Panel);
        Panel.setBackground(Color.ORANGE);

        JLabel lblAddStudent = new JLabel("ADD NEW Student");
        lblAddStudent.setForeground(Color.blue);
        lblAddStudent.setFont(new Font("TimesRoman", Font.PLAIN, 22));

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.blue);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.blue);
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.blue);
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setForeground(Color.blue);
        JLabel lblCity = new JLabel("City:");
        lblCity.setForeground(Color.blue);
        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setForeground(Color.blue);
        textField = new JTextField();
        textField_1 = new JTextField();


        textField_2 = new JTextField();


        textField_3 = new JTextField();


        textField_4 = new JTextField();


        passwordField = new JPasswordField();

        JButton btnNewButton = new JButton("Add Student");


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=textField.getText();
                String password=String.valueOf(passwordField.getPassword());
                String email=textField_1.getText();
                String address=textField_2.getText();
                String city=textField_3.getText();
                String contact=textField_4.getText();

                int i= StudentDB.save(name, password, email, address, city, contact);
                if(i>0){
                    JOptionPane.showMessageDialog(StudentBlank.this,"Student added successfully!");
                    LibrarianPanel.main(new String[]{});
                    statictobject.dispose();

                }else{
                    JOptionPane.showMessageDialog(StudentBlank.this,"Sorry, unable to save!");
                }
            }

        });
        btnNewButton.setBackground(Color.darkGray);
        btnNewButton.setForeground(Color.cyan);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianPanel.main(new String[]{});
                statictobject.dispose();
            }
        });btnBack.setBackground(Color.darkGray);
        btnBack.setForeground(Color.cyan);
        GroupLayout gridLay = new GroupLayout(Panel);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGap(20)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                        .addComponent(lblName)
                                        .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblContactNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                        .addComponent(passwordField))
                                .addContainerGap(107, Short.MAX_VALUE))
                        .addGroup(gridLay.createSequentialGroup()
                                //.addContainerGap(151, Short.MAX_VALUE)
                                .addComponent(lblAddStudent)
                                .addGap(100))
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap(160, Short.MAX_VALUE)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGap(133))
                        .addGroup(gridLay.createSequentialGroup()
                                .addContainerGap(200, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(169))
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addComponent(lblAddStudent)
                                .addGap(18)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addComponent(lblName)
                                                .addGap(18)
                                                .addComponent(lblPassword))
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmail)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAddress)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCity)
                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblContactNo)
                                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(19))
        );
        Panel.setLayout(gridLay);
    }

}
