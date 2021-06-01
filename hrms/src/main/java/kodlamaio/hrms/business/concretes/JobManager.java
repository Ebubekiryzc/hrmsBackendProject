package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.bussiness.BussinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "All job positions listed.");
	}

	@Override
	public DataResult<Job> getByName(String jobName) {
		return new SuccessDataResult<Job>(this.jobDao.getByName(jobName), "Operation Success.");
	}

	@Override
	public Result add(Job job) {
		var error = BussinessRules.check(isNameExist(job.getName()));
		if (error instanceof ErrorResult) {
			return error;
		}
		this.jobDao.save(job);
		return new SuccessDataResult<Job>(job, "Position added!");
	}

	private Result isNameExist(String name) {
		name = name.trim();
		if (null != this.jobDao.getByName(name)) {
			return new ErrorResult("There is already such a job position!");
		}
		return new SuccessResult();
	}

}
