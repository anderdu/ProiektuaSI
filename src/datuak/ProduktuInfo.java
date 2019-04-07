package datuak;


public class ProduktuInfo {
	
	private int id;
	private Float antzekotasuna;
	
	public ProduktuInfo(int pId, Float pAnt) {
		this.id = pId;
		this.antzekotasuna = pAnt;
	}
	
	public void inprimatu() {
		System.out.println("Id: " + this.id);
		System.out.println("Antzekotasuna: " + this.antzekotasuna);
		System.out.println("---------------------");
	}
	
	public int getId() {
		return this.id;
	}
	
	public Float getAntzekotasuna() {
		return this.antzekotasuna;
	}
}