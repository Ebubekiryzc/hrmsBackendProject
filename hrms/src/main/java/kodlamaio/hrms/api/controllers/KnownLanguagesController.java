package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.KnownLanguagesService;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@RestController
@RequestMapping("/api/knownlanguages")
public class KnownLanguagesController {

	private KnownLanguagesService knownLanguagesService;

	@Autowired
	public KnownLanguagesController(KnownLanguagesService knownLanguagesService) {
		super();
		this.knownLanguagesService = knownLanguagesService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.knownLanguagesService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody KnownLanguage knownLanguage) {
		return ResponseEntity.ok(this.knownLanguagesService.add(knownLanguage));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody KnownLanguage knownLanguage){
		return ResponseEntity.ok(this.knownLanguagesService.update(knownLanguage));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.knownLanguagesService.delete(id));
	}
	
}
