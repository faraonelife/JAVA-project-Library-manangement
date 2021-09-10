import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent  extends  JFrame{
    static DeleteStudent statictobject;
    private JPanel contentPane;
    private JTextField textField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new DeleteStudent();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Student Delete ");
                    statictobject.setIconImage(new ImageIcon("icons/student.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public DeleteStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230,500, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.ORANGE);

        JLabel lblEnterId = new JLabel("Insert Student ID to delete:");
        lblEnterId.setForeground(Color.cyan);
        lblEnterId.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        textField = new JTextField();
        textField.setColumns(10);

        JButton btnDelete = new JButton("Delete the Student");
        btnDelete.setBackground(Color.darkGray);
        btnDelete.setForeground(Color.cyan);
        btnDelete.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sid=textField.getText();
                if(sid==null||sid.trim().equals("")){
                    JOptionPane.showMessageDialog(DeleteStudent.this,"This field can not be empty");
                }else{
                    int id=Integer.parseInt(sid);
                    int i= StudentDB.delete(id);
                    if(i>0){
                        JOptionPane.showMessageDialog(DeleteStudent.this,"Student was deleted");
                    }else{
                        JOptionPane.showMessageDialog(DeleteStudent.this,"Impossible to delete");
                    }
                }
            }
        });


        JButton btnback = new JButton("GO...Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianPanel.main(new String[]{});
                statictobject.dispose(); }
        });
        btnback.setForeground(Color.cyan);
        btnback.setBackground(Color.darkGray);
        btnback.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        GroupLayout gridLay = new GroupLayout(contentPane);
        gridLay.setHorizontalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGap(39)
                        .addComponent(lblEnterId)
                       .addGap(57)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(107, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, gridLay.createSequentialGroup()
               .addContainerGap(175, Short.MAX_VALUE)
                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                    .addGap(140))
                        .addGroup(GroupLayout.Alignment.CENTER, gridLay.createSequentialGroup()

                                .addComponent(btnback, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)

                                 )
        );
        gridLay.setVerticalGroup(
                gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gridLay.createSequentialGroup()
                                .addGap(19)
                      .addGroup(gridLay.createParallelGroup(GroupLayout.Alignment.LEADING)
                          .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnterId))
                                .addGap(33)
                       .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                      .addGap(43)
             .addComponent(btnback)
                                )
        );
        contentPane.setLayout(gridLay);
    }
}
