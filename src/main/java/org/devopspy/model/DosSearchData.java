package org.devopspy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class DosSearchData {

	@Id
	@GeneratedValue
	@Column(name = "SEARCH_DATA_ID")
	private Long id;

	@NotNull
	@NotEmpty
	private String expression;
	private boolean isRegex;

	@NotNull
	@NotEmpty
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEARCH_DATA_ID")
	private Set<DosProfile> dosProfiles = new HashSet<DosProfile>();

	public void addDosProfile(DosProfile dosProfile) {
		dosProfiles.add(dosProfile);
	}

	public DosSearchData() {
		super();
	}

}
