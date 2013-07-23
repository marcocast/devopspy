package org.devopspy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosGrep;
import org.devopspy.model.DosResult;
import org.devopspy.repository.DosResultRepository;
import org.grep4j.core.result.GrepResult;
import org.grep4j.core.result.GrepResults;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Named("resultService")
public class ResultService {
	
	@Inject
	@Named("dosResultRepository")
	private DosResultRepository dosResultRepository;
	
	
	public List<DosResult> save(DosGrep dosGrep, GrepResults results){	
		List<DosResult> dosResults = new ArrayList<DosResult>();
		for (GrepResult grepResult : results) {			
			DosResult dosResult = new DosResult();
			dosResult.setResult(grepResult.toString());
			dosResult.setProfileName(grepResult.getProfileName());
			dosResult.setExecutionDate(new Date());
			dosResult.setTotOccourences(grepResult.totalLines());									
			dosResults.add(dosResult);
		}								
		dosResultRepository.save(dosResults);
		return dosResults;
	}
	
}
