package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface UserCheckService {
	Result checkJobSeeker(JobSeeker jobSeeker);
	
}
