package com.sample.db.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
	@Id
	private String id;
	private String password;
	private String first_name;
	private String last_name;

}
