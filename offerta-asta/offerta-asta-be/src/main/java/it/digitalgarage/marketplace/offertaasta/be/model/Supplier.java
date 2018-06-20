package it.digitalgarage.marketplace.offertaasta.be.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Supplier extends User {

	private String info;

	public Supplier() {

	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Supplier [User=" + super.toString() + ", info=" + getInfo() + super.toString() + "]";
	}

}
