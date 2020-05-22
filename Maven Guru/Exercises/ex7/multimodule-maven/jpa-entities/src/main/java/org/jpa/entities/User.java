package org.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
}
