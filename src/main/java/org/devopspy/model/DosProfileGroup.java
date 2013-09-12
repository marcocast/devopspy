package org.devopspy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "DOS_PROFILE_GROUP")
public class DosProfileGroup {

	@Id
	@GeneratedValue
	@Column(name = "DOS_GROUP_ID")
	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@OneToMany(targetEntity = DosProfile.class, fetch=FetchType.EAGER)
	private Set<DosProfile> dosProfiles = new HashSet<DosProfile>();

	public DosProfileGroup() {
		super();
	}

	public DosProfileGroup(String name) {
		super();
		this.name = name;
	}
}
