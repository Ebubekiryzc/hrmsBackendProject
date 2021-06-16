package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownLanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownLanguageDao;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

@Service
public class KnownLanguageManager implements KnownLanguagesService{

	private KnownLanguageDao knownLanguageDao;
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
	}

	@Override
	public DataResult<List<KnownLanguage>> getAll() {
		return new SuccessDataResult<List<KnownLanguage>>(this.knownLanguageDao.findAll(),"All known language records listed.");
	}

	@Override
	public Result add(KnownLanguage knownLanguage) {
		this.knownLanguageDao.save(knownLanguage);
		return new SuccessResult("Known language added to resume.");
	}

	@Override
	public Result update(KnownLanguage knownLanguage) {
		if(this.knownLanguageDao.findById(knownLanguage.getId())==null) {
			return new ErrorResult("Known language not exist.");
		}
		this.knownLanguageDao.save(knownLanguage);
		return new SuccessResult("Known language updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.knownLanguageDao.findById(id)==null) {
			return new ErrorResult("Known language not exist.");
		}
		this.knownLanguageDao.deleteById(id);
		return new SuccessResult("Known language deleted.");
	}
	
}
