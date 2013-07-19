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
public class DevOpspyGrep {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
    @NotEmpty
	private String expression;
	private boolean isRegex;
	
	@ManyToOne
	private DevOpspyProfile devOpspyProfile;
	
	@ManyToOne
	private DevOpspyProfileGroup opspyProfileGroup;
	
	public DevOpspyGrep() {
		super();
	}
	
}
