package com.m2i.tp.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "T_ROLE")
public class Role {
	private int role_id;
	private String role_name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ROLE_ID")
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Column(name="ROLE_NAME", nullable = false)
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Role(String role_name) {
		this.role_name = role_name;
	}

	public Role() {
	}
}

//nullable = false, columnDefinition = "BOOLEAN DEFAULT false"