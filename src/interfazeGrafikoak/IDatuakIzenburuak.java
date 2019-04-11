package interfazeGrafikoak;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.Iterator;
import java.util.Map;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IDatuakIzenburuak extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAtzera;
	private JButton btnItxi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashMap<Integer, String> produkIzenburuak = null;
					IDatuakIzenburuak frame = new IDatuakIzenburuak(produkIzenburuak);
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
	public IDatuakIzenburuak(HashMap<Integer, String> produkIzenburuak) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		this.setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
		getContentPane().setBackground(Color.RED);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 55, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -54, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -75, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
	
		
	
		String[] columns = {"ProduktuId","Izenburua"};
		
		Iterator it = produkIzenburuak.entrySet().iterator();
		DefaultTableModel model = new DefaultTableModel(columns,0);
		while(it.hasNext()) {
			Map.Entry lerro = (Map.Entry) it.next();
//			System.out.println(lerro.getKey() +"----"+ lerro.getValue());
			Object[] rowData = { lerro.getKey(), lerro.getValue() };
			model.addRow(rowData);
		}

		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		btnAtzera = new JButton("Atzera");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAtzera, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAtzera, 171, SpringLayout.WEST, contentPane);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				IDatuakNagusia frame = new IDatuakNagusia();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAtzera);
		
		btnItxi = new JButton("Itxi");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnItxi, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnItxi, -10, SpringLayout.EAST, contentPane);
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnItxi);
	}
}