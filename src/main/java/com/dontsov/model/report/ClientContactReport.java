package com.dontsov.model.report;

import javax.persistence.Entity;

@Entity
public class ClientContactReport {

	private int clientId;

	public ClientContactReport() {
	}

	public ClientContactReport(int clientId) {
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ClientContactReport [clientId=" + clientId + "]";
	}
	

}
