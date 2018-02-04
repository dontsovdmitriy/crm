package com.dontsov.model.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.dontsov.model.entity.util.ClientStatus;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,200}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	@Column(name="name")
	private String name;
	
	@Pattern(regexp="^[+-]?[0-9]{1,3}(?:[0-9]*(?:[.,][0-9]{2})?|(?:,[0-9]{3})*(?:\\.[0-9]{2})?|(?:\\.[0-9]{3})*(?:,[0-9]{2})?)$", message="must be from 1 to 20 digits. format -123123,12 � | 12312432134 | -12.234.123,23")
	@Column(name="turnover")
	private String turnover;
	

	@ManyToOne(
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private ClientStatus status;

	@OneToMany(mappedBy="client",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	private List<ContactPerson> contactPersons;

	@OneToMany(mappedBy="client",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	private List<Action> actions;

	public Client() {
	}

	public Client(int id, String name, String turnover, User user, ClientStatus status) {
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.user = user;
		this.status = status;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void add(ContactPerson tempContactPerson) {
		if(contactPersons == null) {
			contactPersons = new ArrayList<>();
		}
		contactPersons.add(tempContactPerson);
		tempContactPerson.setClient(this);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", turnover=" + turnover + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}
