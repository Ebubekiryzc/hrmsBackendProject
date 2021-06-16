package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerPicture;

public interface JobSeekerPictureService {

	DataResult<List<JobSeekerPicture>> getAll();
	
	Result addJobSeekerPicture(JobSeekerPicture jobSeekerPicture);
	
	Result uploadPicture(MultipartFile file, JobSeekerPicture jobSeekerPicture) throws IOException;
	
}
