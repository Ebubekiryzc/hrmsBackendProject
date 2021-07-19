package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.resumeService.getAll());
	}
	
	@GetMapping("/getByJobSeekerId")
	public ResponseEntity<?> getByJobSeekerId(@RequestParam int id){
		return ResponseEntity.ok(this.resumeService.getByJobSeekerId(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Resume resume) {
		return ResponseEntity.ok(this.resumeService.add(resume));
	}

}
