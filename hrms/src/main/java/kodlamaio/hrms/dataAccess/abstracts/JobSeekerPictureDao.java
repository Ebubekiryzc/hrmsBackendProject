package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerPicture;

public interface JobSeekerPictureDao extends JpaRepository<JobSeekerPicture, Integer>{
	
}
