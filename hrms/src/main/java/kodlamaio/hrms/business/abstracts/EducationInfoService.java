package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInfo;

public interface EducationInfoService {

	DataResult<List<EducationInfo>> getAll();
	
	DataResult<List<EducationInfo>> getByEndDateOrderByDesc();

	Result add(EducationInfo educationInfo);

	Result update(EducationInfo educationInfo);

	Result delete(int id);

}
