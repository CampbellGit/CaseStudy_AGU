package com.m2i.tp.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User {

	private int id;

	private String username;

	private String password;
	
	private Set<Role> role_user = new HashSet<Role>(0);
	
	private boolean enabled;

	@Id
	@Column(name="USER_ID", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_USER_ROLES", 
	joinColumns = { @JoinColumn(name = "USER_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	public Set<Role> getRole_user() {
		return role_user;
	}

	public void setRole_user(Set<Role> role_user) {
		this.role_user = role_user;
	}

	@Column(name="ENABLED", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	
}