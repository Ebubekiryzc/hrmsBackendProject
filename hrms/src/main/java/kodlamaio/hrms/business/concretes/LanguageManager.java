package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"All language records listed.");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Language added.");
	}

	@Override
	public Result update(Language language) {
		if(this.languageDao.findById(language.getId())==null) {
			return new ErrorResult("Language not exist.");
		}
		this.languageDao.save(language);
		return new SuccessResult("Language updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.languageDao.findById(id)==null) {
			return new ErrorResult("Language not exist.");
		}
		this.languageDao.deleteById(id);
		return new SuccessResult("Language deleted.");
	}
	
	
	
}
