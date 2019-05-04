package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class IPertsonaAntzekoak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Integer[] a = {1,2,3};
					IPertsonaAntzekoak frame = new IPertsonaAntzekoak(a);
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
	public IPertsonaAntzekoak(Integer[] listaErab) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZureAntzekoGustuak = new JLabel("ZURE ANTZEKO GUSTUAK DITUZTEN PERTSONAK");
		lblZureAntzekoGustuak.setBounds(76, 21, 264, 55);
		contentPane.add(lblZureAntzekoGustuak);
		
		JLabel label = new JLabel("1.");
		label.setBounds(63, 118, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(63, 143, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(63, 168, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setBounds(63, 193, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setBounds(63, 218, 46, 14);
		contentPane.add(label_4);
		
		JLabel lblEr = new JLabel("er1");
		lblEr.setBounds(103, 118, 206, 14);
		contentPane.add(lblEr);
		
		JLabel lblEr_1 = new JLabel("er2");
		lblEr_1.setBounds(103, 143, 206, 14);
		contentPane.add(lblEr_1);
		
		JLabel lblEr_2 = new JLabel("er3");
		lblEr_2.setBounds(103, 168, 206, 14);
		contentPane.add(lblEr_2);
		
		JLabel lblEr_3 = new JLabel("er4");
		lblEr_3.setBounds(103, 193, 206, 14);
		contentPane.add(lblEr_3);
		
		JLabel lblEr_4 = new JLabel("er5");
		lblEr_4.setBounds(103, 218, 206, 14);
		contentPane.add(lblEr_4);
		
		
		lblEr.setText(listaErab[0].toString());
		lblEr_1.setText(listaErab[1].toString());
		lblEr_2.setText(listaErab[2].toString());
		lblEr_3.setText(listaErab[3].toString());
		lblEr_4.setText(listaErab[4].toString());
		
	}

}
