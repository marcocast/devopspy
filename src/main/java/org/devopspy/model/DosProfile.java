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
@Table(name = "DOS_PROFILE")
public class DosProfile {

	@Id
	@GeneratedValue
	@Column(name = "DOS_PROFILE_ID")
	private Long id;

	@NotNull
	@NotEmpty
	private String name;
	private String filePath;
	private String host;
	private String user;
	private String password;
	private String userAuthPrivateKeyLocation;

	public DosProfile() {
		super();
	}

	public DosProfile(String name) {
		super();
		this.name = name;
	}

}
