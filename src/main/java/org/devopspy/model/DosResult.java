package org.devopspy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DosResult {

	@Id
	@GeneratedValue
	private Long id;

	private String result;

	private String profileName;

	private Date executionDate;

	private Integer totOccourences;

	public DosResult() {
		super();
	}

}
