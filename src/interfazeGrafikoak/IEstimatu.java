package interfazeGrafikoak;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eragiketak.EstimazioaKalkulatu;
import eragiketak.GureSistema;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IEstimatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnEstimatu;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JButton btnItxi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstimazioaKalkulatu estimazioa = null;
					IEstimatu frame = new IEstimatu(estimazioa);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IEstimatu(EstimazioaKalkulatu estimazioa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		JLabel lblErabiltzailearenIdentifikatzailea = new JLabel("Erabiltzailearen identifikatzailea:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		getContentPane().setBackground(Color.CYAN);
		
		
		JLabel lblPelikularenIdentifikatzailea = new JLabel("Pelikularen identifikatzailea:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		btnEstimatu = new JButton("Estimatu!");
		btnEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int erabiltzaileaId = Integer.parseInt(textField.getText());
				int pelikulaId = Integer.parseInt(textField_1.getText());
				String estimazio = Float.toString(estimazioa.estimatuBalorazioak(erabiltzaileaId, pelikulaId));
				textField_2.setText(estimazio);
				
				
			}
		});
		btnNewButton = new JButton("Atzera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IDatuakNagusia frame = new IDatuakNagusia();
				frame.setVisible(true);
			}
		});
		
		btnItxi = new JButton("Itxi");
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEstimatu)
							.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(109))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addContainerGap(298, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblErabiltzailearenIdentifikatzailea))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPelikularenIdentifikatzailea)))
					.addContainerGap(260, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(335, Short.MAX_VALUE)
					.addComponent(btnItxi))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblErabiltzailearenIdentifikatzailea)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPelikularenIdentifikatzailea)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEstimatu)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnItxi))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
