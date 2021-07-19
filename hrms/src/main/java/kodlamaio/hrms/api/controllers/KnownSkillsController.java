package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.KnownSkillService;
import kodlamaio.hrms.entities.concretes.KnownSkill;

@RestController
@RequestMapping("/api/knownskills")
@CrossOrigin
public class KnownSkillsController {

	private KnownSkillService knownSkillService;

	@Autowired
	public KnownSkillsController(KnownSkillService knownSkillService) {
		super();
		this.knownSkillService = knownSkillService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.knownSkillService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody KnownSkill knownSkill) {
		return ResponseEntity.ok(this.knownSkillService.add(knownSkill));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody KnownSkill knownSkill){
		return ResponseEntity.ok(this.knownSkillService.update(knownSkill));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.knownSkillService.delete(id));
	}	
	
}
