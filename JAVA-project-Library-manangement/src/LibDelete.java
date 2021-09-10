import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibDelete extends JFrame {
	static LibDelete statictobject;
	private JPanel Panel;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statictobject = new LibDelete();
					statictobject.setVisible(true);
					statictobject.setTitle("Librarian Delete ");
					statictobject.setIconImage(new ImageIcon("icons/library.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LibDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 230, 450, 300);
		Panel = new JPanel();
		Panel.setBackground(Color.ORANGE);
		Panel.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(Panel);
		
		JLabel lblEnterId = new JLabel("Insert the ID of librarian:");
		lblEnterId.setForeground(Color.BLUE);
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete the librarian");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(LibDelete.this,"This field can not be empty");
				}else{
					int id=Integer.parseInt(sid);
					int i= LibrarianDB.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(LibDelete.this,"librarian was deleted");
					}else{
						JOptionPane.showMessageDialog(LibDelete.this,"Impossible to delete");
					}
				}
			}
		});
		btnDelete.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		btnDelete.setBackground(Color.darkGray);
		btnDelete.setForeground(Color.cyan);
		JButton btnNewButton = new JButton("GO...Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratorPanel.main(new String[]{});
				statictobject.dispose();
			}
		});
		btnNewButton.setFont(new Font("TimesRoman", Font.PLAIN, 17));
btnNewButton.setForeground(Color.cyan);
btnNewButton.setBackground(Color.darkGray);
		GroupLayout gridLay = new GroupLayout(Panel);
		gridLay.setHorizontalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addGap(39)
					.addComponent(lblEnterId)
					.addGap(57)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gridLay.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(140))
				.addGroup(Alignment.CENTER, gridLay.createSequentialGroup()

					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)

				)
		);
		gridLay.setVerticalGroup(
			gridLay.createParallelGroup(Alignment.LEADING)
				.addGroup(gridLay.createSequentialGroup()
					.addGap(19)
					.addGroup(gridLay.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterId))
					.addGap(33)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnNewButton)
						)
		);
		Panel.setLayout(gridLay);
	}
}
