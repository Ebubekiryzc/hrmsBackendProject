package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.bussiness.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private MailService mailService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private UserService userService;

	@Autowired
	public AuthManager(MailService mailService, EmployerService employerService, JobSeekerService jobSeekerService,
			UserService userService) {
		super();
		this.mailService = mailService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.userService = userService;
	}

	@Override
	public Result employerRegister(Employer employer) {
		var canEmployerRegister = employerService.add(employer);
		if (canEmployerRegister instanceof ErrorResult) {
			return canEmployerRegister;
		}
		// persist mail verification:
		// codes will be added

		// persist admin verification:
		// codes will be added

		// verification message:
		mailService.sendVerificationMessage(employer, "randomtoken");
		return canEmployerRegister;
	}

	@Override
	public Result jobSeekerRegister(JobSeeker jobSeeker) {
		var canJobSeekerRegister = jobSeekerService.add(jobSeeker);
		if (canJobSeekerRegister instanceof ErrorResult) {
			return canJobSeekerRegister;
		}
		// persist mail verification:
		// codes will be added

		// verification message:
		mailService.sendVerificationMessage(jobSeeker, "randomtoken");
		return canJobSeekerRegister;
	}

	@Override
	public DataResult<User> logIn(User user) {
		var userExist = this.userService.getByEmail(user.getEmail()).getData();
		if ((userExist != null) && (userExist.getEmail().equals(user.getPassword()))) {
			return new SuccessDataResult<User>(userExist, "Authorization completed.");
		}
		return new ErrorDataResult<User>(userExist, "Operation failed, there is no user matching this.");
	}
}
