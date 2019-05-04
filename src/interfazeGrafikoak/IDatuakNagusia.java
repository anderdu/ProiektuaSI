package interfazeGrafikoak;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datuak.DatuenKarga;
import datuak.KargaCSV;
import datuak.Pertsona;
import eragiketak.ProdukturarekinEstimazioa;
import eragiketak.AntzekoPertsonak;
import eragiketak.GureSistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IDatuakNagusia extends JFrame {

	private JPanel contentPane;
	private GureSistema nGureSistema;
	private DatuenKarga kargaInterfaze;
	private ProdukturarekinEstimazioa estimazioa;
	
	private ImageIcon argazkia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDatuakNagusia frame = new IDatuakNagusia();
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
	public IDatuakNagusia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		nGureSistema = GureSistema.getGureSistema();
		estimazioa = ProdukturarekinEstimazioa.getEstimazioaKalkulatu();
		kargaInterfaze = new KargaCSV();
		
		getContentPane().setBackground(Color.CYAN);
		
		// JPanel batean
//		Dimension tamaina = getSize();
//		argazkia = new ImageIcon(getClass().getResource("tv-the-flash05.jpg"));
//		Graphics g = null;
//		g.drawImage(argazkia.getImage(), 0, 0, tamaina.width, tamaina.height, null);
//		setOpaque(false);
//		super.paint(g);
		
		JButton btnBalorazioak = new JButton("Balorazioak");
		btnBalorazioak.setBounds(46, 128, 170, 56);
		btnBalorazioak.setVisible(true);
		btnBalorazioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				new IDatuakBalorazioak(produkBal);
				
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBalorazioak);
		
		JButton btnIzenburuak = new JButton("Izenburuak");
		btnIzenburuak.setBounds(297, 128, 170, 56);
		btnIzenburuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HashMap<Integer, String> produkIzenburuak = nGureSistema.produktuenIzenburuak();
				new IDatuakIzenburuak(produkIzenburuak);

//				HashMap<Integer, String> produkIz = nGureSistema.produktuenIzenburuak();
//				new IDatuaIzenburuak(produkIz);
				
				dispose();

			}
		});
		
		JButton btnPelikulaEstimatu = new JButton("Pelikula estimatu!");
		btnPelikulaEstimatu.setBounds(181, 221, 151, 29);
		btnPelikulaEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				ArrayList<Pertsona> pertsonak = nGureSistema.pertsonakAtera();
				nGureSistema.antzekotasunGuztiakKalkulatu();
				dispose();
				new IEstimatu(estimazioa);
			}
		});
		contentPane.add(btnPelikulaEstimatu);
		contentPane.add(btnIzenburuak);
		
		JButton btnAtera = new JButton("Itxi");
		btnAtera.setBounds(431, 291, 71, 26);
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnAtera);
		
		JButton btnPertsonaAntzekoenak = new JButton("Pertsona antzekoenak");
		btnPertsonaAntzekoenak.setBounds(294, 60, 173, 34);
		btnPertsonaAntzekoenak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//llamar a pertsona antzekoenak o a la interfaz suya
				dispose();
				new IAntPertsonaIdSartu();
			}
		});
		contentPane.add(btnPertsonaAntzekoenak);
		
		JButton btnNewButton = new JButton("10 pelikula zuretzat!");
		btnNewButton.setBounds(46, 58, 170, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new IHamarPelikula();
			}
		});
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("atzealdeak/fondoNagusi.jpeg"));
		//		getContentPane().setComponentZOrder(lblNewLabel, 1); //Debajo de la anterior 
		lblNewLabel.setBounds(0, 0, 534, 341);
		contentPane.add(lblNewLabel);
	}
}
