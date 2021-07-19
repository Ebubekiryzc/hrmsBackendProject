package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EducationInfoService;
import kodlamaio.hrms.entities.concretes.EducationInfo;

@RestController
@RequestMapping("/api/educationinfo")
@CrossOrigin
public class EducationInfoController {

	private EducationInfoService educationInfoService;

	@Autowired
	public EducationInfoController(EducationInfoService educationInfoService) {
		super();
		this.educationInfoService = educationInfoService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.educationInfoService.getAll());
	}

	@GetMapping("/getByEndDateOrdeByDesc")
	public ResponseEntity<?> getByEndDateOrderByDesc() {
		return ResponseEntity.ok(this.educationInfoService.getByEndDateOrderByDesc());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationInfo educationInfo) {
		return ResponseEntity.ok(this.educationInfoService.add(educationInfo));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody EducationInfo educationInfo){
		return ResponseEntity.ok(this.educationInfoService.update(educationInfo));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.educationInfoService.delete(id));
	}

		
}
