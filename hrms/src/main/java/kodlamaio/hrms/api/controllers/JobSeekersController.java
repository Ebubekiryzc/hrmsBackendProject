package kodlamaio.hrms.api.controllers;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/job_seekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobSeekerService.getAll());
	}

	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@RequestParam String email) {
		return ResponseEntity.ok(this.jobSeekerService.getByEmail(email));
	}

	@GetMapping("/getByNationalId")
	public ResponseEntity<?> getByNationalId(@RequestParam String nationalId) {
		return ResponseEntity.ok(this.jobSeekerService.getByNationalId(nationalId));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}

}
