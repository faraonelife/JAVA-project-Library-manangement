import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookDelete extends JFrame{
    static BookDelete statictobject;
    private JPanel contentPane;
    private JTextField textField;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    statictobject = new BookDelete();
                    statictobject.setVisible(true);
                    statictobject.setTitle("Books Delete ");
                    statictobject.setIconImage(new ImageIcon("icons/book.png").getImage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public BookDelete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 230, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(contentPane);
        contentPane.setBackground(Color.ORANGE);

        JLabel lblEnterId = new JLabel("Insert Book ID:");
        lblEnterId.setForeground(Color.blue);
        textField = new JTextField();
        textField.setColumns(10);
        lblEnterId.setFont(new Font("TimesRoman", Font.PLAIN, 13));

        JButton btnDelete = new JButton("Delete the book");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studeNtId=textField.getText();
                if(studeNtId==null||studeNtId.trim().equals("")){
                    JOptionPane.showMessageDialog(BookDelete.this,"This field can not be empty");
                }else{
                    int id=Integer.parseInt(studeNtId);
                    int stat= BookDB.delete(id);
                    if(stat>0){ JOptionPane.showMessageDialog(BookDelete.this,"Book was deleted");
                    }else{
                        JOptionPane.showMessageDialog(BookDelete.this,"Impossible to delete"); } } }
        });
        btnDelete.setBackground(Color.darkGray);
        btnDelete.setForeground(Color.cyan);
        btnDelete.setFont(new Font("TimesRoman", Font.PLAIN, 13));

        JButton btnback = new JButton("GO...Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdministratorPanel.main(new String[]{});
                statictobject.dispose();
            }
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
                        .addGroup(GroupLayout.Alignment.CENTER, gridLay.createSequentialGroup()
                              //  .addContainerGap(175, Short.MAX_VALUE)
                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                //.addGap(140)
                                )
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
