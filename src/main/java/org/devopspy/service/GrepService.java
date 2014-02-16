package org.devopspy.service;

import static org.grep4j.core.Grep4j.constantExpression;
import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.fluent.Dictionary.on;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosSearchData;
import org.devopspy.model.DosResult;
import org.devopspy.repository.DosSearchDataRepository;
import org.grep4j.core.model.Profile;
import org.grep4j.core.result.GrepResults;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Named("grepService")
public class GrepService {
	

	@Inject
	@Named("profileService")
	private ProfileService profileService;
	
	@Inject
	@Named("dosSearchDataRepository")
	private DosSearchDataRepository dosSearchDataRepository;
	
	@Inject
	@Named("resultService")
	private ResultService resultService;
	
	
	public List<DosResult> runGrep(DosSearchData dosGrep){
		List<Profile> profiles = profileService.generateProfiles(dosGrep);		
		GrepResults results = grep(constantExpression(dosGrep.getExpression()), on(profiles));
		return resultService.save(dosGrep,results);		
	}
	
	public List<DosResult> runGrep(Long grepid){		
		return runGrep(dosSearchDataRepository.findOne(grepid));		
	}
	
	
}
