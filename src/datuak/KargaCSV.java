package datuak;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class KargaCSV implements DatuenKarga {
	
	private HashMap<Integer, ArrayList<Float>> produkBal;
	private HashMap<Integer, String> produkIzenburuak;
	private ArrayList<Pertsona> listaPertsonak;
	
	public KargaCSV() {
		this.produkBal =  new HashMap<Integer, ArrayList<Float>>();
		this.produkIzenburuak =  new HashMap<Integer, String>();
		this.listaPertsonak = new ArrayList<Pertsona>();
	}

	public HashMap<Integer, ArrayList<Float>> produktuenBalorazioak() {
		
		String csvFile = "csv/movie-ratings.csv";
//		String csvFile = "C:\\Users\\yo\\git\\ProiektuaSI\\ProiektuaSI\\csv\\movie-ratings.csv"; asas
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            String[] lerroa;
            Integer produktuId;
            Float balorazio;
            while ((line = br.readLine()) != null) {

                lerroa = line.split(cvsSplitBy);
                produktuId = Integer.parseInt(lerroa[1]);
                balorazio = Float.parseFloat(lerroa[2]);
                
                if (!this.produkBal.containsKey(produktuId)) {
                	ArrayList<Float> bereBalorazioak = new ArrayList<Float>();
                	bereBalorazioak.add(balorazio);
                	this.produkBal.put(produktuId, bereBalorazioak);
                } else {
                	produkBal.get(produktuId).add(balorazio);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return this.produkBal;
	}
	

	public HashMap<Integer, String> produktuenIzenburuak(){
		
		String csvFile = "csv/movie-titles.csv";
//		String csvFile = "C:\\Users\\yo\\git\\ProiektuaSI\\ProiektuaSI\\csv\\movie-titles.csv";
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            String[] lerroa;
            Integer produktuId;
            String izenburua;
            while ((line = br.readLine()) != null) {

                lerroa = line.split(cvsSplitBy);
                produktuId = Integer.parseInt(lerroa[0]);
                izenburua = lerroa[1];
                
                if (!this.produkIzenburuak.containsKey(produktuId)) {
                	this.produkIzenburuak.put(produktuId, izenburua);
                } else {
//                	System.out.println("Produktu hau badago");
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return this.produkIzenburuak;
    
		
	}
	
	public ArrayList<Pertsona> pertsonakAtera() {
		
//		String csvFile = "C:/Users/-/git/ProiektuaSI/ProiektuaSI/csv/movie-ratings.csv";
		String csvFile = "csv/movie-ratings.csv";
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Pertsona p;
        
        HashMap<Integer, String> produktuGuztiak = this.produktuenIzenburuak();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            String[] lerroa;
            Integer aurrekoUserId,userId,produktuId;
            Float balorazio;
            
            line = br.readLine();
            lerroa = line.split(cvsSplitBy);
            aurrekoUserId = Integer.parseInt(lerroa[0]);
            produktuId = Integer.parseInt(lerroa[1]);
            balorazio = Float.parseFloat(lerroa[2]);
            
            this.listaPertsonak.add(new Pertsona(aurrekoUserId));
            this.listaPertsonak.get(0).balorazioaSartu(produktuId, balorazio);
            
            int pos = 0;
            
            while ((line = br.readLine()) != null) {

                lerroa = line.split(cvsSplitBy);
                userId = Integer.parseInt(lerroa[0]);
                produktuId = Integer.parseInt(lerroa[1]);
                balorazio = Float.parseFloat(lerroa[2]);
                
                if (!aurrekoUserId.equals(userId)) {
                	p = new Pertsona(userId);
                	// meter todos los productos en la lista de no valoradas de la persona nueva
                	for(Entry<Integer, String> entry : produktuGuztiak.entrySet()) {
						p.baloratuEzDuenaSartu(entry.getKey(), 0.0f);
					}
                	this.listaPertsonak.add(p);
                	pos ++;
                	aurrekoUserId = userId;
                }
                
                this.listaPertsonak.get(pos).balorazioaSartu(produktuId, balorazio);
                this.listaPertsonak.get(pos).getBaloratuEzDituenak().remove(produktuId);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		
		return this.listaPertsonak;
	}
	
	public static void main(String[] args) {
		KargaCSV proba = new KargaCSV();
		HashMap<Integer, ArrayList<Float>> produk = proba.produktuenBalorazioak();
		proba.produktuenBalorazioak();
		System.out.println(produk.size());
	}
}