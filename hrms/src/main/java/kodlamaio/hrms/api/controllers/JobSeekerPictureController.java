package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPictureService;
import kodlamaio.hrms.entities.concretes.JobSeekerPicture;

@RestController
@RequestMapping("/api/resumes/jobSeekerPicture")
public class JobSeekerPictureController {

	private JobSeekerPictureService jobSeekerPictureService;

	@Autowired
	public JobSeekerPictureController(JobSeekerPictureService jobSeekerPictureService) {
		super();
		this.jobSeekerPictureService = jobSeekerPictureService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobSeekerPictureService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add( @RequestBody final MultipartFile file, @Valid @RequestBody JobSeekerPicture jobSeekerPicture) throws Exception{
		return ResponseEntity.ok(this.jobSeekerPictureService.uploadPicture(file, jobSeekerPicture));
	}
	
		
	
}
