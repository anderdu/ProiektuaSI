package datuak;

import java.io.*;
import java.util.*;

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
		//a
		String csvFile = "csv/movie-ratings.csv";
//		String csvFile = "C:\\Users\\yo\\git\\ProiektuaSI\\ProiektuaSI\\csv\\movie-ratings.csv";
//		String csvFile = "C:\\Users\\Oihanion\\git\\ProiektuaSI\\ProiektuaSI\\csv\\movie-ratings.csv";
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            String[] lerroa;
            Integer userId,produktuId;
            Float balorazio;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                lerroa = line.split(cvsSplitBy);
                userId = Integer.parseInt(lerroa[0]);
                produktuId = Integer.parseInt(lerroa[1]);
                balorazio = Float.parseFloat(lerroa[2]);
//                System.out.println("userId: " + userId + " , produktuId: " + produktuId + " , balorazio: " + balorazio);
                
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

                // use comma as separator
                lerroa = line.split(cvsSplitBy);
                produktuId = Integer.parseInt(lerroa[0]);
                izenburua = lerroa[1];
                
               // System.out.println("produktuId: " + produktuId + " , izenburua: " + izenburua);
                
                if (!this.produkIzenburuak.containsKey(produktuId)) {
                	this.produkIzenburuak.put(produktuId, izenburua);
                } else {
                	System.out.println("Produktu hau badago");
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
		
		String csvFile = "C:/Users/-/git/ProiektuaSI/ProiektuaSI/csv/movie-ratings.csv";
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

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

                // use comma as separator
                lerroa = line.split(cvsSplitBy);
                userId = Integer.parseInt(lerroa[0]);
                produktuId = Integer.parseInt(lerroa[1]);
                balorazio = Float.parseFloat(lerroa[2]);
//                System.out.println("userId: " + userId + " , produktuId: " + produktuId + " , balorazio: " + balorazio);
                
                if (!aurrekoUserId.equals(userId)) {
                	this.listaPertsonak.add(new Pertsona(userId));
                	pos ++;
                	aurrekoUserId = userId;
                }
                
                this.listaPertsonak.get(pos).balorazioaSartu(produktuId, balorazio);

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
