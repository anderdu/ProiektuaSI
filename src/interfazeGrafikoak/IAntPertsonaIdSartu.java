package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datuak.Pertsona;
import eragiketak.AntzekoPertsonak;
import eragiketak.GureSistema;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IAntPertsonaIdSartu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IAntPertsonaIdSartu frame = new IAntPertsonaIdSartu();
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
	public IAntPertsonaIdSartu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(155, 92, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnZurePertsonaAntzekoenak = new JButton("Zure Pertsona Antzekoenak");
		btnZurePertsonaAntzekoenak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GureSistema.getGureSistema().pertsonakAtera();
				GureSistema.getGureSistema().produktuenBalorazioak();
				GureSistema.getGureSistema().produktuenIzenburuak();
				
				String erabiltzaileID = textField.getText();
				int eralID = Integer.parseInt(erabiltzaileID);
				
				Pertsona p = new Pertsona(eralID);
				
				Integer[] lista = p.getAntzekoPertsonak();
				for (int j = 0; j < lista.length; j++) {
					System.out.println(lista[j]);
				}
				dispose();
				new IPertsonaAntzekoak(p.getAntzekoPertsonak());
			}
		});
		btnZurePertsonaAntzekoenak.setBounds(92, 141, 235, 33);
		contentPane.add(btnZurePertsonaAntzekoenak);
		
		JButton btnNewButton = new JButton("Itxi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(320, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IDatuakNagusia frame = new IDatuakNagusia();
				frame.setVisible(true);
			}
		});
		btnAtzera.setBounds(206, 228, 89, 23);
		contentPane.add(btnAtzera);
		
		JLabel lblZureErabiltzaileIda = new JLabel("Zure erabiltzaile id-a sar ezazu:");
		lblZureErabiltzaileIda.setBounds(128, 67, 281, 14);
		contentPane.add(lblZureErabiltzaileIda);
	}
}
