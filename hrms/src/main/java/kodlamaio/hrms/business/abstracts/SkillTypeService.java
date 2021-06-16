package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillType;

public interface SkillTypeService {

	DataResult<List<SkillType>> getAll();
	
	Result add(SkillType skillType);
	
	Result update(SkillType skillType);
	
	Result delete(int id);
}
