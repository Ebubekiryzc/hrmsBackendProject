package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCoverLetterDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

@Service
public class JobSeekerCoverLetterManager implements JobSeekerCoverLetterService {

	private JobSeekerCoverLetterDao jobSeekerCoverLetterDao;

	@Autowired
	public JobSeekerCoverLetterManager(JobSeekerCoverLetterDao jobSeekerCoverLetterDao) {
		super();
		this.jobSeekerCoverLetterDao = jobSeekerCoverLetterDao;
	}

	@Override
	public DataResult<List<JobSeekerCoverLetter>> getAll() {
		return new SuccessDataResult<List<JobSeekerCoverLetter>>(this.jobSeekerCoverLetterDao.findAll(),
				"All job seeker cover letter records listed.");
	}

	@Override
	public Result add(JobSeekerCoverLetter jobSeekerCoverLetter) {
		this.jobSeekerCoverLetterDao.save(jobSeekerCoverLetter);
		return new SuccessResult("Job seeker cover letter added to resume.");
	}

	@Override
	public Result update(JobSeekerCoverLetter jobSeekerCoverLetter) {
		if (this.jobSeekerCoverLetterDao.findById(jobSeekerCoverLetter.getId()) == null) {
			return new ErrorResult("Job seeker cover letter not exist.");
		}
		this.jobSeekerCoverLetterDao.save(jobSeekerCoverLetter);
		return new SuccessResult("Job seeker cover letter updated.");
	}

	@Override
	public Result delete(int id) {
		if (this.jobSeekerCoverLetterDao.findById(id) == null) {
			return new ErrorResult("Job seeker cover letter not exist.");
		}
		this.jobSeekerCoverLetterDao.deleteById(id);
		return new SuccessResult("Job seeker cover letter deleted.");

	}

}
