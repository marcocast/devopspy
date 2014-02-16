package org.devopspy;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.DosSearchData;
import org.devopspy.model.DosProfile;
import org.devopspy.repository.DosSearchDataRepository;
import org.devopspy.repository.DosProfileRepository;
import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

@Named("dosProfileInitializer")
public class DosProfileInitializer {

	@Inject
	@Named("dosProfileRepository")
	private DosProfileRepository dosProfileRepository;

	@Inject
	@Named("dosSearchDataRepository")
	private DosSearchDataRepository dosSearchDataRepository;


	@PostInitialize
	@Transactional(readOnly = false)
	public void init() {

		DosProfile dosProfile1 = createProfile("profile 1", "/opt/somewhere",
				"host1", "user", "password");		
		dosProfileRepository.save(dosProfile1);

		DosProfile dosProfile2 = createProfile("profile 2",	"/opt/ops/logs/jboss/ramp-all/server.log", "localhost", "", "");
		dosProfileRepository.save(dosProfile2);

		DosProfile dosProfile3 = createProfile("profile 3",	"/opt/ops/logs/jboss/serv", "host3", "user", null, "/home/user/.ssh/id_dsa");
		dosProfileRepository.save(dosProfile3);

		DosProfile dosProfile4 = createProfile("profile 4",	"/opt/ops/logs/jboss/ramp-all/server.log", "localhost", "", "");
		dosProfileRepository.save(dosProfile4);

		DosSearchData searchData = new DosSearchData();
		searchData.addDosProfile(dosProfile2);
		searchData.addDosProfile(dosProfile4);
		searchData.setExpression("WARN");
		searchData.setRegex(false);
		dosSearchDataRepository.save(searchData);
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
