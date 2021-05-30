package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.bussiness.BussinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "All employers listed.");
	}

	@Override
	public Result add(Employer employer) {
		var error = BussinessRules.check(checkDomain(employer),isEmailExist(employer.getEmail()));
		if(error instanceof ErrorResult) {
			return error;
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer added.");
	}

	private Result checkDomain(Employer employer) {
		String domain ="";
		for (int i = 1; i < employer.getWebSite().split("\\.").length; i++) {
			domain+=employer.getWebSite().split("\\.")[i];
			if(i!=employer.getWebSite().split("\\.").length-1) {
				domain+=".";
			}
		}
		String regex = "^(.+)@"+domain+"$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(matcher.matches()) {
			return new SuccessResult();
		}else {
//			System.out.println(regex);
			return new ErrorResult("This e-mail address does not match the domain name.");
		}
	}
	
	private Result isEmailExist(String email) {
		return isExistControl(this.employerDao.findByEmail(email.trim()),"There is already a registered user with this email!");
	}

	private Result isExistControl(Employer employer, String errorMessage) {
		if(null != employer) {
			return new ErrorResult(errorMessage);
		}
		return new SuccessResult();
	}
}
