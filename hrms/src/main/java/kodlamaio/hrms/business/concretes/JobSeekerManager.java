package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.bussiness.BussinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserCheckService checkService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService checkService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.checkService = checkService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "All job seekers listed.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var error = BussinessRules.check(isEmailExist(jobSeeker.getEmail()), isNationalIdExist(jobSeeker.getNationalId()), checkService.checkJobSeeker(jobSeeker));
		if(error instanceof ErrorResult) {
			return error;
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job seeker added.");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByEmail(email),"Operation success.");
	}

	@Override
	public DataResult<JobSeeker> getByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByNationalId(nationalId),"Operation success.");
	}
	
	//abc@xyz.com
	//abc@xyz.com
	
	private Result isEmailExist(String email) {
		return isExistControl(this.jobSeekerDao.getByEmail(email.trim()),"There is already a registered user with this email!");
	}
	
	private Result isNationalIdExist(String nationalId) {
		return isExistControl(this.jobSeekerDao.getByNationalId(nationalId.trim()),"There is already a registered user with this national id!");
	}
	
	private Result isExistControl(JobSeeker jobSeeker, String errorMessage) {
		if(null != jobSeeker) {
			return new ErrorResult(errorMessage);
		}
		return new SuccessResult();
	}

}
