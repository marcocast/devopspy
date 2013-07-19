package org.devopspy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
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
