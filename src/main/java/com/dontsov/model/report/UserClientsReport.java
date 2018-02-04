package com.dontsov.model.report;

import javax.persistence.Entity;

@Entity
public class UserClientsReport {

	private int userId;

	public UserClientsReport() {
	}

	public UserClientsReport(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserClientsReport [userId=" + userId + "]";
	}

}
