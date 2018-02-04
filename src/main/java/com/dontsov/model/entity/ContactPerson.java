package com.dontsov.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="contact_person")
public class ContactPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="surname")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String surname;
	
	@Column(name="name")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String name;
	
	@Column(name="second_name")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{0,45}$", message="must be from 0 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String secondName;
	
	@Column(name="phone_number")
	@Pattern(regexp="^\\d{12}$", message="must contain 12 digits")
	private String phoneNumber;
	
	@ManyToOne(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	@JoinColumn(name="client_id")
	private Client client;

	public ContactPerson() {
	}

	public ContactPerson(String surname, String name, String secondName, String phoneNumber) {
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "ContactPerson [id=" + id + ", surname=" + surname + ", name=" + name + ", secondName=" + secondName
				+ ", phoneNumber=" + phoneNumber + "]";
	}


	
}
