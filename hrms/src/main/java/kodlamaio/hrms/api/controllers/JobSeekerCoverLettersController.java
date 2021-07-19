package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobSeekerCoverLetterService;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

@RestController
@RequestMapping("/api/jobseekercovers")
@CrossOrigin
public class JobSeekerCoverLettersController {

	private JobSeekerCoverLetterService jobSeekerCoverLetterService;

	@Autowired
	public JobSeekerCoverLettersController(JobSeekerCoverLetterService jobSeekerCoverLetterService) {
		super();
		this.jobSeekerCoverLetterService = jobSeekerCoverLetterService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobSeekerCoverLetterService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerCoverLetter jobSeekerCoverLetter) {
		return ResponseEntity.ok(this.jobSeekerCoverLetterService.add(jobSeekerCoverLetter));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobSeekerCoverLetter jobSeekerCoverLetter){
		return ResponseEntity.ok(this.jobSeekerCoverLetterService.update(jobSeekerCoverLetter));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.jobSeekerCoverLetterService.delete(id));
	}	
	
	//TODO: Apileri kontrol et, entityleri ve jsonignorelarını kontrol et. Managerları kontrol et. Apide salak saçma bir şey yazmış mısın bak. Servicelere bi göz at.
	
}
