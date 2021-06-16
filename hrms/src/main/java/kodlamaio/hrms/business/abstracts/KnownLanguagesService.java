package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

public interface KnownLanguagesService {
	DataResult<List<KnownLanguage>> getAll();
	
	Result add(KnownLanguage knownLanguage);
	
	Result update(KnownLanguage knownLanguage);
	
	Result delete(int id);
}
