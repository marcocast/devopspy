package org.devopspy.service;

import static org.grep4j.core.Grep4j.constantExpression;
import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.fluent.Dictionary.on;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DevOpspyGrep;
import org.devopspy.model.DevOpspyResult;
import org.devopspy.repository.DevOpspyGrepRepository;
import org.devopspy.repository.DevOpspyResultRepository;
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
	@Named("devOpspyGrepRepository")
	private DevOpspyGrepRepository devOpspyGrepRepository;
	
	@Inject
	@Named("devOpspyResultRepository")
	private DevOpspyResultRepository devOpspyResultRepository;
	
	
	public DevOpspyResult runGrep(DevOpspyGrep devOpspyGrep){
		List<Profile> profiles = profileService.generateProfiles(devOpspyGrep);		
		GrepResults results = grep(constantExpression(devOpspyGrep.getExpression()), on(profiles));
		DevOpspyResult devOpspyResult = new DevOpspyResult();
		devOpspyResult.setResult(results.toString());
		devOpspyResult.setDevOpspyGrep(devOpspyGrep);
		devOpspyResult.setExecutionDate(new Date());
		devOpspyResult.setTotOccourences(results.totalLines());
		devOpspyResultRepository.save(devOpspyResult);
		return devOpspyResult;
	}
	
	public DevOpspyResult runGrep(Long grepid){		
		return runGrep(devOpspyGrepRepository.findOne(grepid));		
	}
	
	
}
