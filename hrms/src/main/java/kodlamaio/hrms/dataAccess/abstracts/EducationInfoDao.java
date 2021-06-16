package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EducationInfo;

public interface EducationInfoDao extends JpaRepository<EducationInfo, Integer>{
	
	List<EducationInfo> getAllByOrderByEndDateDesc();
	
}
