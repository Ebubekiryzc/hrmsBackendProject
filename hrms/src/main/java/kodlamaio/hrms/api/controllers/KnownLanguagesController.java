package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.KnownLanguagesService;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@RestController
@RequestMapping("/api/knownlanguages")
@CrossOrigin
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
