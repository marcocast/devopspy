package org.devopspy;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosGrep;
import org.devopspy.model.DosProfile;
import org.devopspy.model.DosProfileGroup;
import org.devopspy.repository.DosGrepRepository;
import org.devopspy.repository.DosProfileGroupRepository;
import org.devopspy.repository.DosProfileRepository;
import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

@Named("dosProfileInitializer")
public class DosProfileInitializer {

	@Inject
	@Named("dosProfileRepository")
	private DosProfileRepository dosProfileRepository;
	
	@Inject
	@Named("dosGrepRepository")
	private DosGrepRepository dosGrepRepository;

	@Inject
	@Named("dosProfileGroupRepository")
	private DosProfileGroupRepository dosProfileGroupRepository;

	@PostInitialize
	@Transactional(readOnly = false)
	public void init() {

		DosProfileGroup firstGroup = new DosProfileGroup("first group");
		dosProfileGroupRepository.save(firstGroup);

		DosProfile dosProfile1 = createProfile("profile 1", "/opt/somewhere", "host1", "user", "password");
		dosProfile1.addDosProfileGroup(firstGroup);
		dosProfileRepository.save(dosProfile1);

		DosProfile dosProfile2 = createProfile("profile 2", "/opt/ops/logs/jboss/ramp-all/server.log", "localhost", "", "");
		dosProfileRepository.save(dosProfile2);

		DosProfile dosProfile3 = createProfile("profile 3", "/opt/ops/logs/jboss/serv", "host3", "user", null, "/home/user/.ssh/id_dsa");
		dosProfileRepository.save(dosProfile3);
		
		
		DosGrep dosGrep = new DosGrep();
		dosGrep.addDosProfile(dosProfile2);
		dosGrep.setExpression("ERROR");
		dosGrep.setRegex(false);
		dosGrepRepository.save(dosGrep);
	}

	private DosProfile createProfile(String name, String filePath, String url, String passsword, String user) {
		return createProfile(name, filePath, url, passsword, user, null);
	}

	private DosProfile createProfile(String name, String filePath, String url, String passsword, String user, String userAuthPrivateKeyLocation) {
		DosProfile dosProfile = new DosProfile(name);
		dosProfile.setFilePath(filePath);
		dosProfile.setHost(url);
		dosProfile.setPassword(passsword);
		dosProfile.setUser(user);
		dosProfile.setUserAuthPrivateKeyLocation(userAuthPrivateKeyLocation);
		return dosProfile;
	}
}
