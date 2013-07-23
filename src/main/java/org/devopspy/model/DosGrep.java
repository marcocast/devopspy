package org.devopspy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class DosGrep {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	private String expression;
	private boolean isRegex;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<DosProfile> dosProfiles = new HashSet<DosProfile>();

	public void addDosProfile(DosProfile dosProfile) {
		if (dosProfiles == null) {
			dosProfiles = new HashSet<DosProfile>();
		}
		dosProfiles.add(dosProfile);
	}

	public DosGrep() {
		super();
	}

}
