package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActiveTrue();

	List<JobAdvertisement> getByIsActiveTrue(Sort sort);

	List<JobAdvertisement> getByIsActiveTrueAndEmployer_Id(int employerId);
}
