package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.entities.User;
//import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/registerEmployer")
	public ResponseEntity<?> registerEmployer(@RequestBody Employer employer) {
		return ResponseEntity.ok(this.authService.employerRegister(employer));
	}

	@PostMapping("/registerJobSeeker")
	public ResponseEntity<?> registerJobSeekers(@RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(authService.jobSeekerRegister(jobSeeker));
	}
	
	@PostMapping("/logIn")
	public ResponseEntity<?> logIn(@RequestBody User user){
		return ResponseEntity.ok(authService.logIn(user));
	}

}
