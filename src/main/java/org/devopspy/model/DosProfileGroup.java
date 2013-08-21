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
@Table(name = "DOS_GROUP")
public class DosProfileGroup {

	@Id
	@GeneratedValue
	@Column(name = "DOS_GROUP_ID")
	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	public DosProfileGroup() {
		super();
	}

	public DosProfileGroup(String name) {
		super();
		this.name = name;
	}
}
