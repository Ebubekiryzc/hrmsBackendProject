package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {

	DataResult<List<Experience>> getAll();

	DataResult<List<Experience>> getByEndDateOrderByDesc();

	Result add(Experience experience);

	Result update(Experience experience);

	Result delete(int id);

}
