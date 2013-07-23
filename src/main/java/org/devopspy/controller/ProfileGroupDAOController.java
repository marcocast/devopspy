package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosProfileGroup;
import org.devopspy.repository.DosProfileGroupRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/devopspyprofilegroup")
public class ProfileGroupDAOController extends
		RepositoryBasedRestController<DosProfileGroup, Long, DosProfileGroupRepository> {

	@Inject
	@Named("dosProfileGroupRepository")
	@Override
	public void setRepository(DosProfileGroupRepository repository) {
		this.repository = repository;
	}

}
