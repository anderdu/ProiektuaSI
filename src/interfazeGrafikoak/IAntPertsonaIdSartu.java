package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
		textField = new JTextField();
		textField.setBounds(155, 92, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnZurePertsonaAntzekoenak = new JButton("Zure Pertsona Antzekoenak");
		btnZurePertsonaAntzekoenak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erabiltzaileID = textField.getText();
				int eralID = Integer.parseInt(erabiltzaileID);
				AntzekoPertsonak ap = new AntzekoPertsonak();
				GureSistema gs = GureSistema.getGureSistema();
				gs.pertsonakAtera();
				gs.produktuenBalorazioak();
				gs.produktuenIzenburuak();
				Integer[] lista = ap.pertsonaAntzekoenakEman(eralID);
				new IPertsonaAntzekoak(lista);
//				dispose();
			}
		});
		btnZurePertsonaAntzekoenak.setBounds(92, 141, 235, 33);
		contentPane.add(btnZurePertsonaAntzekoenak);
		
		JLabel lblZureErabiltzaileIda = new JLabel("Zure erabiltzaile id-a sar ezazu:");
		lblZureErabiltzaileIda.setBounds(136, 67, 191, 14);
		contentPane.add(lblZureErabiltzaileIda);
	}
}
