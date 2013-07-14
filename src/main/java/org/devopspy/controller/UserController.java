package org.devopspy.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.devopspy.model.User;
import org.devopspy.repository.UserRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller
@Controller
@RequestMapping(value = "/api/user")
public class UserController extends RepositoryBasedRestController<User, Long, UserRepository> {

 @Inject
 @Named("userRepository")
 @Override
 public void setRepository(UserRepository repository) {
     this.repository = repository;
 }

}
