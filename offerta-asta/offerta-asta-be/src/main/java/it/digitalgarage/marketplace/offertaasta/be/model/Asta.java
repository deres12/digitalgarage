package it.digitalgarage.marketplace.offertaasta.be.model;

import java.util.Date;

public class Asta {
	private String nomeAsta;
	private User cliente;
	private String descrizione;
	private Date dataInizio;
	
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	private Date dataFine;
	
	
	public String getNomeAsta() {
		return nomeAsta;
	}
	public void setNomeAsta(String nomeAsta) {
		this.nomeAsta = nomeAsta;
	}
	public User getCliente() {
		return cliente;
	}
	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
