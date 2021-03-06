package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.experienceService.getAll());
	}
	
	@GetMapping("/getByEndDateOrdeByDesc")
	public ResponseEntity<?> getByEndDateOrderByDesc() {
		return ResponseEntity.ok(this.experienceService.getByEndDateOrderByDesc());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience) {
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.update(experience));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.experienceService.delete(id));
	}
	
}
