package interfazeak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datuak.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IDatuenKarga extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDatuenKarga frame = new IDatuenKarga();
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
	public IDatuenKarga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		KargaCSV karga = new KargaCSV();
		HashMap<Integer, ArrayList<Float>> prodBal = karga.produktuenBalorazioak();
		
		//zutabeak = ("Produktu","Balorazioa");
		//zutabeak2 = ("Produktu","Izenburua");
		DefaultTableModel modeloa = new DefaultTableModel();
		modeloa.addColumn("erabiltzailea");
		modeloa.addColumn("Balorazioak");
		table = new JTable(modeloa);
		
		scrollPane.setRowHeaderView(table);
	}

}
