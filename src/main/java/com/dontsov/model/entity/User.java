package com.dontsov.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {

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
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String secondName;

	@Column(name="phone_number")
	@Pattern(regexp="^[\\d]{10}$", message="must be contain 10 digits")
	private String phoneNumber;

    @ManyToMany()
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	@Column(name = "username")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String username;

	@Column(name = "password")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String password;

	@Transient
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String confirmPassword;

	@OneToMany(mappedBy="user",
			fetch = FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	private List<Client> clients;

	public User() {
	}

	public User(
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String surname,
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String name,
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String secondName,
			@Pattern(regexp = "^[\\d]{10}$", message = "must be contain 10 digits") String phoneNumber,
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String username,
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String password,
			@Pattern(regexp = "^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message = "must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*") String confirmPassword) {
		super();
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
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
	
	public List<Client> getClients() {
		return clients;
	}

	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void add(Client tempClient) {
		if(clients == null) {
			clients = new ArrayList<>();
		}
		clients.add(tempClient);
		tempClient.setUser(this);
	}

	@Override
	public String toString() {
		return "User [surname=" + surname + ", name=" + name + ", secondName=" + secondName + ", phoneNumber="
				+ phoneNumber + ", username=" + username + "]";
	}

	public String getFullName() {
		return surname + " " + name + " " + secondName;
	}
}
