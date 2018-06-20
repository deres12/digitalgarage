package it.digitalgarage.marketplace.offertaasta.be.model;

import java.util.List;

public class Professione {
	private String professione;
	//private String servizio;
	private List<ServizioOfferto> tipiServizi;
	
	public String getProfessione() {
		return professione;
	}
	public void setProfessione(String professione) {
		this.professione = professione;
	}
	public List<ServizioOfferto> getTipiServizi() {
		return tipiServizi;
	}
	public void setTipiServizi(List<ServizioOfferto> tipiServizi) {
		this.tipiServizi = tipiServizi;
	}

}
