package eu.grmdev.sm.core;


public class DaneTytoniu {
	
	private String marka;
	private String smak;
	private double ocenaOgolna;
	private double cena;
	
	public DaneTytoniu(String marka, String smak, double ocenaOgolna,
			double cena) {
		this.marka = marka;
		this.smak = smak;
		this.ocenaOgolna = ocenaOgolna;
		this.cena = cena;
	}
	
	public double getCena() {
		return cena;
	}
	
	public String getMarka() {
		return marka;
	}
	
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
	public String getSmak() {
		return smak;
	}
	
	public void setSmak(String smak) {
		this.smak = smak;
	}
	
	public double getOcenaOgolna() {
		return ocenaOgolna;
	}
	
	public void setOcenaOgolna(double ocenaOgolna) {
		this.ocenaOgolna = ocenaOgolna;
	}
	
	public void setCena(double cena) {
		this.cena = cena;
	}

}
