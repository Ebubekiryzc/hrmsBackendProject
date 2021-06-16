package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownSkill;

public interface KnownSkillService {

	DataResult<List<KnownSkill>> getAll();

	Result add(KnownSkill knownSkill);

	Result update(KnownSkill knownSkill);

	Result delete(int id);
	
}
