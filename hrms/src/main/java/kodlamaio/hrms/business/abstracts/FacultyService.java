package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Faculty;

public interface FacultyService {
	DataResult<List<Faculty>> getAll();
	
	Result add(Faculty faculty);
	
	Result update(Faculty faculty);
	
	Result delete(int id);
}
