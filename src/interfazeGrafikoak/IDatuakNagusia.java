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
		setBounds(100, 100, 450, 300);
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
		btnBalorazioak.setBounds(24, 112, 151, 45);
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
		btnIzenburuak.setBounds(253, 139, 141, 45);
		btnIzenburuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HashMap<Integer, String> produkIzenburuak = nGureSistema.produktuenIzenburuak();
				new IDatuakIzenburuak(produkIzenburuak);

//				HashMap<Integer, String> produkIz = nGureSistema.produktuenIzenburuak();
//				new IDatuaIzenburuak(produkIz);
				
				dispose();

			}
		});
		contentPane.add(btnIzenburuak);
		
		JButton btnPelikulaEstimatu = new JButton("Pelikula estimatu!");
		btnPelikulaEstimatu.setBounds(125, 220, 115, 29);
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
		
		JButton btnAtera = new JButton("Itxi");
		btnAtera.setBounds(358, 223, 49, 23);
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnAtera);
		
		JButton btnNewButton = new JButton("10 pelikula zuretzat!");
		btnNewButton.setBounds(148, 80, 129, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new IHamarPelikula();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\-\\git\\ProiektuaSI\\WhatsApp Image 2019-04-11 at 10.57.23.jpeg"));
		//		getContentPane().setComponentZOrder(lblNewLabel, 1); //Debajo de la anterior 
				lblNewLabel.setBounds(10, 139, 392, 110);
				contentPane.add(lblNewLabel);
	}
}
