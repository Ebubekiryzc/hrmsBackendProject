package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getAllActiveAdvertisements")
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisement() {
		return this.jobAdvertisementService.getAllActiveAdvertisements();
	}

	@GetMapping("/getAllActiveAdvertisementsSortedDESC")
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisementSorted() {
		return this.jobAdvertisementService.getAllActiveAdvertisementsSorted();
	}

	@GetMapping("/getAllActiveAdvertisementsOfEmployer")
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisementsOfEmployer(@RequestParam int employerId) {
		return this.jobAdvertisementService.getAllActiveAdvertisementsOfmployer(employerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}

}
