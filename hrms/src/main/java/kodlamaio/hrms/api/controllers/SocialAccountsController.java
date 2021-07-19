package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.entities.concretes.SocialAccount;

@RestController
@RequestMapping("/api/socialAccounts")
@CrossOrigin
public class SocialAccountsController {

	private SocialAccountService socialAccountService;

	@Autowired
	public SocialAccountsController(SocialAccountService socialAccountService) {
		super();
		this.socialAccountService = socialAccountService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.socialAccountService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SocialAccount socialAccount) {
		return ResponseEntity.ok(this.socialAccountService.add(socialAccount));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody SocialAccount socialAccount){
		return ResponseEntity.ok(this.socialAccountService.update(socialAccount));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.socialAccountService.delete(id));
	}	
	
	
}
