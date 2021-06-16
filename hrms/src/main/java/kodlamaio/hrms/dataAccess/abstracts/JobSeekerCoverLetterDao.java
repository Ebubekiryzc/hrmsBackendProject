package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerCoverLetter;

public interface JobSeekerCoverLetterDao extends JpaRepository<JobSeekerCoverLetter, Integer>{

}
