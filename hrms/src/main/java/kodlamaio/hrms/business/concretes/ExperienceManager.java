package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "All experience records listed.");
	}

	@Override
	public DataResult<List<Experience>> getByEndDateOrderByDesc() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByOrderByEndDateDesc(),
				"All experience records listed regarding the end date.");
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience added.");
	}

	@Override
	public Result update(Experience experience) {
		if (this.experienceDao.findById(experience.getId()) == null) {
			return new ErrorResult("Experience not exist.");
		}
		this.experienceDao.save(experience);
		return new SuccessResult("Experience updated.");
	}

	@Override
	public Result delete(int id) {
		if (this.experienceDao.findById(id) == null) {
			return new ErrorResult("Experience not exist.");
		}
		this.experienceDao.deleteById(id);
		return new SuccessResult("Experience deleted.");
	}

}
