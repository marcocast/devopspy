package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosProfile;
import org.devopspy.repository.DosProfileRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspyprofile")
public class ProfileDAOController extends
		RepositoryBasedRestController<DosProfile, Long, DosProfileRepository> {

	@Inject
	@Named("dosProfileRepository")
	@Override
	public void setRepository(DosProfileRepository repository) {
		this.repository = repository;
	}

}
