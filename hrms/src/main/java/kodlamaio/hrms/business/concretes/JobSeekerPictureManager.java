package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerPictureService;
import kodlamaio.hrms.core.adapters.abstracts.UserImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerPictureDao;
import kodlamaio.hrms.entities.concretes.JobSeekerPicture;

@Service
public class JobSeekerPictureManager implements JobSeekerPictureService{

	private JobSeekerPictureDao jobSeekerPictureDao;
	
	private  UserImageService userImageService;
	
	@Autowired
	public JobSeekerPictureManager(JobSeekerPictureDao jobSeekerPictureDao, UserImageService userImageService) {
		super();
		this.jobSeekerPictureDao = jobSeekerPictureDao;
		this.userImageService = userImageService;
	}

	@Override
	public DataResult<List<JobSeekerPicture>> getAll() {
		return new SuccessDataResult<List<JobSeekerPicture>>(this.jobSeekerPictureDao.findAll(),"All job seeker picture records listed.");
	}
	
	@Override
	public Result uploadPicture(MultipartFile file, JobSeekerPicture jobSeekerPicture) throws IOException {
		var result = this.userImageService.addJobSeekerPicture(file);
		if(result instanceof ErrorDataResult<String>) {
			return result;
		}
		jobSeekerPicture.setPictureUrl(result.getData());
		return addJobSeekerPicture(jobSeekerPicture);		
	}
	
	@Override
	public Result addJobSeekerPicture(JobSeekerPicture jobSeekerPicture) {
		this.jobSeekerPictureDao.save(jobSeekerPicture);
		return new SuccessResult("Picture added to database.");
	}	
	
}
