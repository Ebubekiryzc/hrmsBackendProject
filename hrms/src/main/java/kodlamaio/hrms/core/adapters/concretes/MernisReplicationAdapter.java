package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import mernisReplication.MernisValidationServiceReplication;

@Service("MernisServiceReplication")
public class MernisReplicationAdapter implements UserCheckService {

	@Override
	public Result checkJobSeeker(JobSeeker jobSeeker) {
		MernisValidationServiceReplication mernisValidationServiceReplication = new MernisValidationServiceReplication();
		boolean result = mernisValidationServiceReplication.userCheckService(jobSeeker.getNationalId(),
				jobSeeker.getYearOfBirth());
		if (result) {
			return new SuccessResult();
		}
		return new ErrorResult("Mernis validation failed.");
	}

}
