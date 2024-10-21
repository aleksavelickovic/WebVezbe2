package model;

public class Osoba {

	private String ime;
	private String prezime;
	private String korIme;
	private String lozinka;

	public Osoba(String ime, String prezime, String korIme, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korIme = korIme;
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + "]";
	}

}
