package com.dontsov.model.report;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ActionClientReport {

	private int clientId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private LocalDate dateFrom;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private LocalDate dateTo;

	public ActionClientReport() {
	}

	public ActionClientReport(int clientId, LocalDate dateFrom, LocalDate dateTo) {
		this.clientId = clientId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	@Override
	public String toString() {
		return "ActionClientReport [clientId=" + clientId + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}
		
}
