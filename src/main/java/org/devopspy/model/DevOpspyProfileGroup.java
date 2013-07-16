package org.devopspy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
public class DevOpspyProfileGroup {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
    @NotEmpty
	private String name;
	
	public DevOpspyProfileGroup() {
		super();
	}
	
	public DevOpspyProfileGroup(String name) {
		super();
		this.name = name;
	}	

}
