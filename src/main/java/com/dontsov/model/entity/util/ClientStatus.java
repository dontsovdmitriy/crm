package com.dontsov.model.entity.util;

public enum ClientStatus {
	AWARENESS("Awareness"), INTEREST("Interest"), DECISION("Decision"), ACTION("Action");
	
	 private final String status;

	 private ClientStatus(String status) {
	     this.status = status;
	 }
	public String getStatus() {
		return status;
	}

	
}
