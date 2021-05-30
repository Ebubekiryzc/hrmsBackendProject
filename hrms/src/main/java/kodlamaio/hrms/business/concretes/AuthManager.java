package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private MailService mailService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public AuthManager(MailService mailService, EmployerService employerService, JobSeekerService jobSeekerService) {
		super();
		this.mailService = mailService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
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

}
