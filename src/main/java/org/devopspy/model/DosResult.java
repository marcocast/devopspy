package org.devopspy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DosResult {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Transient
	private String result;
	
	@OneToOne
	private DosGrep dosGrep;
	
	private Date executionDate;
	
	private Integer totOccourences;
		
	public DosResult() {
		super();
	}
	
}
