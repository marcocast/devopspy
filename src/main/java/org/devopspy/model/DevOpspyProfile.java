package org.devopspy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
public class DevOpspyProfile {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
    @NotEmpty
	private String name;
	private String filePath;
	private String host;
	private String user;
	private String password;
	private String userAuthPrivateKeyLocation;
	
	@ManyToOne
	private DevOpspyProfileGroup devOpspyProfileGroup;
	
	public DevOpspyProfile() {
		super();
	}
	
	public DevOpspyProfile(String name) {
		super();
		this.name = name;
	}	
	
}