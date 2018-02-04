package com.dontsov.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="target")
public class Target {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@Pattern(regexp="^[^<>!@#$%&?*(){}:;\\[\\]\\\\/+*]{1,45}$", message="must be from 1 to 45 chars/digits and symbols except <>!@#$%&?*(){}:;[]\\/+*")
	private String name;
	
	@OneToMany(mappedBy="target",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
			)
	private List<Action> actions;

	public Target() {
	}

	public Target(String name) {
		this.name = name;
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

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void add(Action tempAction) {
		if(actions == null) {
			actions = new ArrayList<>();
		}
		actions.add(tempAction);
		tempAction.setTarget(this);
	}

	@Override
	public String toString() {
		return "Target [id=" + id + ", name=" + name +  "]";
	}
	
	
}
