package interfazeGrafikoak;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eragiketak.ProdukturarekinEstimazioa;
import eragiketak.GureSistema;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdukturarekinEstimazioa estimazioa = null;
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
	public IEstimatu(ProdukturarekinEstimazioa estimazioa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		JLabel lblErabiltzailearenIdentifikatzailea = new JLabel("Erabiltzailearen identifikatzailea:");
		lblErabiltzailearenIdentifikatzailea.setBounds(15, 29, 190, 14);
		
		textField = new JTextField();
		textField.setBounds(44, 54, 86, 20);
		textField.setColumns(10);
		
		getContentPane().setBackground(Color.CYAN);
		
		
		JLabel lblPelikularenIdentifikatzailea = new JLabel("Pelikularen identifikatzailea:");
		lblPelikularenIdentifikatzailea.setBounds(15, 92, 190, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 117, 86, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(284, 166, 86, 20);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		
		JLabel lblEmaitza = new JLabel("Emaitza:");
		lblEmaitza.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmaitza.setForeground(Color.WHITE);
		lblEmaitza.setBounds(301, 141, 69, 14);
		contentPane.add(lblEmaitza);
		lblEmaitza.setVisible(false);
		
		btnEstimatu = new JButton("Estimatu!");
		btnEstimatu.setBounds(45, 165, 102, 21);
		btnEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int erabiltzaileaId = Integer.parseInt(textField.getText());
				int pelikulaId = Integer.parseInt(textField_1.getText());
				String estimazio = Float.toString(estimazioa.estimatuBalorazioak(erabiltzaileaId, pelikulaId));
				textField_2.setVisible(true);
				lblEmaitza.setVisible(true);
				if(estimazio.equals(null))
					textField_2.setText("Datuak txarto");
				else
					textField_2.setText(estimazio);
				
				
				
			}
		});
		btnNewButton = new JButton("Atzera");
		btnNewButton.setBounds(257, 277, 102, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IDatuakNagusia frame = new IDatuakNagusia();
				frame.setVisible(true);
			}
		});
		
		btnItxi = new JButton("Itxi");
		btnItxi.setBounds(391, 277, 83, 23);
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnEstimatu);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(btnNewButton);
		contentPane.add(lblErabiltzailearenIdentifikatzailea);
		contentPane.add(textField);
		contentPane.add(lblPelikularenIdentifikatzailea);
		contentPane.add(btnItxi);
	
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("atzealdeak/film-real-and-clapboard-abstract.jpg"));
		lblNewLabel.setBounds(0, 0, 494, 323);
		contentPane.add(lblNewLabel);
	}
}
