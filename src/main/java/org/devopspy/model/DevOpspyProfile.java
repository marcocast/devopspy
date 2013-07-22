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
@Table(name = "DEVOPSPY_PROFILE")
public class DevOpspyProfile {
	
	@Id
	@GeneratedValue
	@Column(name = "DEVOPSPY_PROFILE_ID")
	private Long id;
	
	@NotNull
    @NotEmpty
	private String name;
	private String filePath;
	private String host;
	private String user;
	private String password;
	private String userAuthPrivateKeyLocation;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)	
	@JoinTable(name = "DEVOPSPY_PROFILE_GROUP", joinColumns = { @JoinColumn(name = "DEVOPSPY_PROFILE_ID") }, inverseJoinColumns = { @JoinColumn(name = "DEVOPSPY_GROUP_ID") })	
	private Set<DevOpspyProfileGroup> devOpspyProfileGroups = new HashSet<DevOpspyProfileGroup>();

	public void addDevOpspyProfileGroup(DevOpspyProfileGroup devOpspyProfileGroup) {
		if (devOpspyProfileGroups == null) {
			devOpspyProfileGroups = new HashSet<DevOpspyProfileGroup>();
		}
		devOpspyProfileGroups.add(devOpspyProfileGroup);
	}
	
	public DevOpspyProfile() {
		super();
	}
	
	public DevOpspyProfile(String name) {
		super();
		this.name = name;
	}	
	
}
