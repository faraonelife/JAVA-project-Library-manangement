import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdministratorRegistration extends JFrame {
    static AdministratorRegistration statictobject;
    private JPanel MainPanelofAdmin;
    private JTextField usernameField;
    private JPasswordField PASSField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new AdministratorRegistration();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Administrator Registration");
                    statictobject.setIconImage(new ImageIcon("icons/ad.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AdministratorRegistration() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230,550, 300);
        MainPanelofAdmin = new JPanel();
        MainPanelofAdmin.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(MainPanelofAdmin);
        Border line = new LineBorder(Color.RED.brighter(), 4, false);
        MainPanelofAdmin.setBorder(line);
        MainPanelofAdmin.setBackground(Color.ORANGE);


        JLabel lblAdminLoginForm = new JLabel("Administrator Registration");
        lblAdminLoginForm.setForeground(Color.blue);
        lblAdminLoginForm.setFont(new Font("TimesRoman", 3, 18));

        JLabel lblEnterName = new JLabel("Insert Admin name:");

        JLabel lblEnterPassword = new JLabel("Insert Admin  password:");
lblEnterName.setForeground(Color.blue);
        lblEnterPassword.setForeground(Color.blue);
        usernameField = new JTextField();
        usernameField.setColumns(20);

        JButton btnGo = new JButton("GO...");
        btnGo.setBackground(Color.cyan.brighter());
        btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username= usernameField.getText();
                String password=String.valueOf(PASSField.getPassword());
                if(username.equals("admin")&&password.equals("admin")){
                    AdministratorPanel.main(new String[]{});
                    statictobject.dispose();
                }else{
                    JOptionPane.showMessageDialog(AdministratorRegistration.this, "Error,something went wrong","Error", JOptionPane.ERROR_MESSAGE);
                    usernameField.setText("");
                    PASSField.setText("");
                }
            }
        });

        PASSField = new JPasswordField();
        GroupLayout gridLay = new GroupLayout(MainPanelofAdmin);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(224)
                                                .addComponent(lblAdminLoginForm))
                                        .addGroup(gridLay.createSequentialGroup()
                                                .addGap(19)
                                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(lblEnterName)
                                                        .addComponent(lblEnterPassword))
                                                .addGap(47)
                                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.CENTER, true)
                                                        .addComponent(PASSField)
                                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                                .addContainerGap(107, Short.MAX_VALUE)
                                )
                        .addGroup(gridLay.createSequentialGroup()
                                        .addGap(121)
                                .addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)

                                )
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(gridLay.createSequentialGroup()
                                .addComponent(lblAdminLoginForm)
                                .addGap(26)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblEnterName)
                                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblEnterPassword)
                                        .addComponent(PASSField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnGo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)

                        )
        );
        MainPanelofAdmin.setLayout(gridLay);
    }
}
