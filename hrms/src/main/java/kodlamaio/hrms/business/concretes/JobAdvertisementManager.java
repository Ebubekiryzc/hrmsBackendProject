package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.bussiness.BussinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(),
				"All active advertisements listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisementsSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "creationDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(sort),
				"All active advertisements sorted in descending order by creation date and listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveAdvertisementsOfmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_Id(employerId),
				"All active advertisements of the employer are listed.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (checkSalaryExist(jobAdvertisement).isSuccess()) {
			jobAdvertisement.getSalary().setAdvertisement(jobAdvertisement);
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		var errors = BussinessRules.check(checkJobAdvertisementExist(jobAdvertisement.getId()));
		if (errors instanceof ErrorResult) {
			return errors;
		}
		if (checkSalaryExist(jobAdvertisement).isSuccess()) {
			jobAdvertisement.getSalary().setAdvertisement(jobAdvertisement);
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement updated.");
	}

	private Result checkSalaryExist(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getSalary() != null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	private Result checkJobAdvertisementExist(Integer jobAdvertisementId) {
		if (this.jobAdvertisementDao.findById(jobAdvertisementId).get() != null) {
			return new SuccessResult();
		}
		return new ErrorResult("There is no such job advertisement.");
	}

}
