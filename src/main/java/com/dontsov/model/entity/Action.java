package com.dontsov.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.dontsov.model.entity.util.ActionType;

@Entity
@Table(name="action")
public class Action {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	@JoinColumn(name="client_id")
	private Client client;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private ActionType type;
	
	@Column(name="description")
	@Pattern(regexp="^[^<>{}]{1,200}$", message="must be from 1 to 200 chars/digits and symbols except <>{}")
	private String description;
	
	@Column(name="date_time")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private LocalDate dateTime;
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	@JoinColumn(name="target_id")
	private Target target;

	public Action() {
	}

	public Action(ActionType type, String description, LocalDate dateTime) {
		this.type = type;
		this.description = description;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", type=" + type + ", description=" + description + ", dateTime=" + dateTime + "]";
	}
	
}
