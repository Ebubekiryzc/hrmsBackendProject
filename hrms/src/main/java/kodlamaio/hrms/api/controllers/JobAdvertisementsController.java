package kodlamaio.hrms.api.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getAllActiveAdvertisements")
	public ResponseEntity<?> getAllActiveAdvertisement() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAllActiveAdvertisements());
	}

	@GetMapping("/getAllActiveAdvertisementsSortedDESC")
	public ResponseEntity<?> getAllActiveAdvertisementSorted() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAllActiveAdvertisementsSorted());
	}

	@GetMapping("/getAllActiveAdvertisementsOfEmployer")
	public ResponseEntity<?> getAllActiveAdvertisementsOfEmployer(@RequestParam int employerId) {
		return ResponseEntity.ok(this.jobAdvertisementService.getAllActiveAdvertisementsOfmployer(employerId));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
	}

}
