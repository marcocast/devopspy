package org.devopspy.service;

import static org.grep4j.core.Grep4j.constantExpression;
import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.fluent.Dictionary.on;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosGrep;
import org.devopspy.model.DosResult;
import org.devopspy.repository.DosGrepRepository;
import org.devopspy.repository.DosResultRepository;
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
	@Named("dosGrepRepository")
	private DosGrepRepository dosGrepRepository;
	
	@Inject
	@Named("dosResultRepository")
	private DosResultRepository dosResultRepository;
	
	
	public DosResult runGrep(DosGrep dosGrep){
		List<Profile> profiles = profileService.generateProfiles(dosGrep);		
		GrepResults results = grep(constantExpression(dosGrep.getExpression()), on(profiles));
		DosResult dosResult = new DosResult();
		dosResult.setResult(results.toString());
		dosResult.setDosGrep(dosGrep);
		dosResult.setExecutionDate(new Date());
		dosResult.setTotOccourences(results.totalLines());
		dosResultRepository.save(dosResult);
		return dosResult;
	}
	
	public DosResult runGrep(Long grepid){		
		return runGrep(dosGrepRepository.findOne(grepid));		
	}
	
	
}
