package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialAccountDao;
import kodlamaio.hrms.entities.concretes.SocialAccount;

@Service
public class SocialAccountManager implements SocialAccountService {

	private SocialAccountDao socialAccountDao;

	@Autowired
	public SocialAccountManager(SocialAccountDao socialAccountDao) {
		super();
		this.socialAccountDao = socialAccountDao;
	}

	@Override
	public DataResult<List<SocialAccount>> getAll() {
		return new SuccessDataResult<List<SocialAccount>>(this.socialAccountDao.findAll(),"All social account records listed.");
	}

	@Override
	public Result add(SocialAccount socialAccount) {
		this.socialAccountDao.save(socialAccount);
		return new SuccessResult("Social account added to resume.");
	}

	@Override
	public Result update(SocialAccount socialAccount) {
		if(this.socialAccountDao.findById(socialAccount.getId())==null) {
			return new ErrorResult("Social account not exist.");
		}
		this.socialAccountDao.save(socialAccount);
		return new SuccessResult("Social account updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.socialAccountDao.findById(id)==null) {
			return new ErrorResult("Social account not exist.");
		}
		this.socialAccountDao.deleteById(id);
		return new SuccessResult("Social account deleted.");
	}

}
