package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialAccount;

public interface SocialAccountService {

	DataResult<List<SocialAccount>> getAll();

	Result add(SocialAccount socialAccount);

	Result update(SocialAccount socialAccount);

	Result delete(int id);
}
