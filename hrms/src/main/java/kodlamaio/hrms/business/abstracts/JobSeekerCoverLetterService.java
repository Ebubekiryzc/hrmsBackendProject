package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

public interface JobSeekerCoverLetterService {

	DataResult<List<JobSeekerCoverLetter>> getAll();

	Result add(JobSeekerCoverLetter jobSeekerCoverLetter);

	Result update(JobSeekerCoverLetter jobSeekerCoverLetter);

	Result delete(int id);

}
