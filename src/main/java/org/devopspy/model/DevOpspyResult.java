package org.devopspy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DevOpspyResult {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String result;
	private Integer totOccourences;
		
	public DevOpspyResult() {
		super();
	}
	
}
