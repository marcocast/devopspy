package org.devopspy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "DOS_PROFILE_GROUP", joinColumns = { @JoinColumn(name = "DOS_PROFILE_ID") }, inverseJoinColumns = { @JoinColumn(name = "DOS_GROUP_ID") })
	private Set<DosProfileGroup> dosProfileGroups = new HashSet<DosProfileGroup>();

	public void addDosProfileGroup(DosProfileGroup dosProfileGroup) {
		if (dosProfileGroups == null) {
			dosProfileGroups = new HashSet<DosProfileGroup>();
		}
		dosProfileGroups.add(dosProfileGroup);
	}

	public DosProfile() {
		super();
	}

	public DosProfile(String name) {
		super();
		this.name = name;
	}

}
