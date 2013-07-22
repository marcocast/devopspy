package org.devopspy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "DEVOPSPY_GROUP")
public class DevOpspyProfileGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "DEVOPSPY_GROUP_ID")
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
